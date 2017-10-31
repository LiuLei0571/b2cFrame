package com.jinqiao.b2c.compent.ui.popup;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BasePopupWindow;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.compent.ui.bubbleview.BubbleList;
import com.jinqiao.b2c.project.buyer.home.adapter.SearchAdapter;

import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/19.
 * 邮箱：liulei2@aixuedai.com
 */


public class PopupFactory {
    private String type;
    private Context mContext;
    BubbleList mBubbleList;
    SearchAdapter mAdapter;
    private BasePopupWindow mPopopView;
    private OnItemClick mOnItemClick;
    private View viewId;
    private View popupLayoutView;

    public String getType() {
        return type;
    }

    public PopupFactory setType(String type) {
        this.type = type;
        return this;
    }

    public OnItemClick getOnItemClick() {
        return mOnItemClick;
    }

    public PopupFactory setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
        return this;
    }

    public View getViewId() {
        return viewId;
    }

    public PopupFactory setViewId(View viewId) {
        this.viewId = viewId;
        return this;
    }

    public PopupFactory(Context context, String type, List<String> mData) {
        popupLayoutView = UIHelper.inflaterLayout(context, R.layout.popup_search);
        mAdapter = new SearchAdapter(context);
        mPopopView = new BasePopupWindow(popupLayoutView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopopView.setFocusable(true);
        mPopopView.setOutsideTouchable(true);
        mBubbleList = (BubbleList) popupLayoutView.findViewById(R.id.list);
        mAdapter.setData(mData);
        mBubbleList.setAdapter(mAdapter);

        mBubbleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mOnItemClick.getItem(position);
            }
        });
    }

    public void show() {
        if (!mPopopView.isShowing()) {
            if (viewId != null) {
                mBubbleList.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                mPopopView.setWidth(mBubbleList.getMeasuredWidth());
                mPopopView.showAsDropDown(viewId);
            } else {
                mPopopView.showAtLocation(popupLayoutView, Gravity.BOTTOM, 0, 0);
            }

        }
    }

    public static void builder(Context context, String type, List<String> obj, View view, OnItemClick listener) {
        new PopupFactory(context, type, obj).setViewId(view).setOnItemClick(listener).show();
    }

    public interface OnItemClick {
        void getItem(int position);
    }

    /**
     * 内容区域从底部进入
     *
     * @param mContext
     * @return
     */
    public Animation getTranAnimation(Context mContext) {
        Animation trantAnimation = AnimationUtils.loadAnimation(mContext, R.anim.popup_bottom_enter);
        return trantAnimation;
    }
}
