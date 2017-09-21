package com.jinqiao.b2c.compent.ui.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BasePopupWindow;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.compent.ui.bubbleview.BubbleList;
import com.jinqiao.b2c.project.buyer.home.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/19.
 * 邮箱：liulei2@aixuedai.com
 */


public class PopupFactory {
    private String type;
    private List<String> obj;
    private Context mContext;
    BubbleList mBubbleList;
    List<String> mData = new ArrayList<>();
    SearchAdapter mAdapter;
    private BasePopupWindow mPopopView;
    private OnItemClick mOnItemClick;
    private View viewId;

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

    public PopupFactory(Context context, String type, List<String> obj) {
        View popupLayout = UIHelper.inflaterLayout(context, R.layout.popup_search);
        mPopopView = new BasePopupWindow(popupLayout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopopView.setFocusable(true);
        mPopopView.setOutsideTouchable(true);
        mBubbleList = (BubbleList) popupLayout.findViewById(R.id.list);
        mAdapter = new SearchAdapter(context);
        mAdapter.setData(mData);
        mBubbleList.setAdapter(mAdapter);
        if (!mPopopView.isShowing()) {
            mPopopView.showAsDropDown(viewId);
        }
        mBubbleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mOnItemClick.getItem(position);
            }
        });
    }

    public static void buid(Context context, String type, List<String> obj, View id, OnItemClick listener) {
        new PopupFactory(context, type, obj).setViewId(id).setOnItemClick(listener);
    }

    public void show() {
    }

    public interface OnItemClick {
        void getItem(int position);
    }

}
