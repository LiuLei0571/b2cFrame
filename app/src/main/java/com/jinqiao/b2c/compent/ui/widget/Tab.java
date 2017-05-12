package com.jinqiao.b2c.compent.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseLinearLayout;
import com.jinqiao.b2c.compent.helper.UIHelper;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class Tab extends BaseLinearLayout {
    @Bind(R.id.imageButton)
    ImageButton mImageButton;
    @Bind(R.id.title)
    TextView mTitle;
    private Drawable defaultRes;
    private CharSequence defaultTitle;
    private Drawable selectRes;

    public Tab(Context context) {
        super(context);
    }

    public Tab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(Context context, AttributeSet mAttributeSet) {
        super.init(context, mAttributeSet);
        TypedArray t = context.obtainStyledAttributes(mAttributeSet, R.styleable.Tab);
        defaultRes = t.getDrawable(R.styleable.Tab_defaultDes);
        defaultTitle = t.getText(R.styleable.Tab_defaultTitle);
        selectRes = t.getDrawable(R.styleable.Tab_selectDes);
        t.recycle();

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.widget_tab;
    }

    @Override
    public void afterViewBind(View view) {
        super.afterViewBind(view);
        mTitle.setText(defaultTitle);
        mImageButton.setImageDrawable(defaultRes);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitle.setTextColor(UIHelper.getColor(R.color.title_background));
                mImageButton.setImageDrawable(selectRes);
            }
        });
    }

    public void setTabItem(boolean isSelect) {
        setSelected(isSelect);
    }

    public void setTitle(String title) {
        mTitle.setText(title);

    }

    @Override
    public void setSelected(boolean selected) {
        if (selected) {
            mTitle.setTextColor(UIHelper.getColor(R.color.title_background));
            mImageButton.setImageDrawable(selectRes);
        } else {
            mTitle.setTextColor(UIHelper.getColor(R.color.color_text_major));
            mImageButton.setImageDrawable(defaultRes);
        }
        super.setSelected(selected);
    }
}
