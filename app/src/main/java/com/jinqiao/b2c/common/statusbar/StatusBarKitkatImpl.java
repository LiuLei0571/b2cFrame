package com.jinqiao.b2c.common.statusbar;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/29.
 * 邮箱：liulei2@aixuedai.com
 */


public class StatusBarKitkatImpl implements IStatusBar {
    private static final String STATUS_BAR_VIEW_TAG = "ghStatusBarView";

    @Override
    public void setStatusBarColor(Window window, int color) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
        View statusBarView = decorViewGroup.findViewWithTag(STATUS_BAR_VIEW_TAG);
        if (statusBarView == null) {
            statusBarView = new View(window.getContext());
            statusBarView.setTag(STATUS_BAR_VIEW_TAG);
            int statusBarHeight = getStatusHeight(window.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
            params.gravity = Gravity.TOP;
            statusBarView.setLayoutParams(params);
            decorViewGroup.addView(statusBarView);
        }
        statusBarView.setBackgroundColor(color);
        StatusBarCompat.setFitsSystemWindows(window,true);
    }

    public static int getStatusHeight(Context mContext) {
        int statusBarHeight = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
