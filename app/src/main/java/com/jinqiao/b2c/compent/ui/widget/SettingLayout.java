package com.jinqiao.b2c.compent.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseLinearLayout;
import com.jinqiao.b2c.compent.helper.Util;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/28.
 * 邮箱：liulei2@aixuedai.com
 */


public class SettingLayout extends BaseLinearLayout {
    @Bind(R.id.iv_left)
    ImageView mIvLeft;
    @Bind(R.id.tv_left_msg)
    TextView mTvLeftMsg;
    @Bind(R.id.iv_right)
    ImageView mIvRight;
    private OnItemClick itemClick;
    private String mLeftMsg;
    private String mRightMsg;
    private boolean hasArrow;
    private Drawable mLeftDrawable;

    public void setHasArrow(boolean hasArrow) {
        this.hasArrow = hasArrow;
        if (hasArrow) {
            mIvRight.setVisibility(VISIBLE);
        } else {
            mIvRight.setVisibility(GONE);
        }
    }

    public void setItemClick(OnItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public SettingLayout(Context context) {
        super(context);
    }

    public SettingLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getRootLayoutId() {
        return R.layout.widget_setting;
    }

    @Override
    public void init(Context context, AttributeSet mAttributeSet) {
        super.init(context, mAttributeSet);
        TypedArray t = context.obtainStyledAttributes(mAttributeSet, R.styleable.Setting);
        mLeftDrawable = t.getDrawable(R.styleable.Setting_leftIcon);
        mLeftMsg = (String) t.getText(R.styleable.Setting_leftMsg);
        mRightMsg = (String) t.getText(R.styleable.Setting_rightMsg);
        t.recycle();
    }

    @Override
    public void afterViewBind(View view) {
        super.afterViewBind(view);
        mTvLeftMsg.setText(Util.cutNull(mLeftMsg));
        mIvLeft.setImageDrawable(mLeftDrawable);

    }

    @OnClick(R.id.tv_left_msg)
    public void onViewClicked() {
        itemClick.onCLick();
    }

    public interface OnItemClick {
        void onCLick();
    }
}
