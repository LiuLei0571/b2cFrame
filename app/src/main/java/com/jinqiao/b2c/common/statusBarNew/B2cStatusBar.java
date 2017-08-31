package com.jinqiao.b2c.common.statusBarNew;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;


/**
 * Created by LuckyCrystal on 2017/8/4.
 *
 */

public class B2cStatusBar {


    public static B2cStatusBar.Builder builder(AppCompatActivity mActivity) {
        return new B2cStatusBar.Builder(mActivity);
    }

    public static class Builder {

        private boolean fitsSystemWindows = true;
        @IdRes
        private int viewId;
        private View topVIew;
        private int statusBarColor = UIHelper.getColor(R.color.white);
        private int topVIewColor = UIHelper.getColor(R.color.white);
        private View toolBarView;
        private boolean fullScreen = false;
        int toolBarId;

        AppCompatActivity activity;
        Fragment mFragment;

        public Builder(Fragment fragment) {
            mFragment = fragment;
            immersionBar = ImmersionBar.with(mFragment)
                    .navigationBarAlpha(1.0f).navigationBarColor(R.color.black)
                    .navigationBarWithKitkatEnable(false).fitsSystemWindows(fitsSystemWindows)
                    .statusBarDarkFont(true);
        }

        private ImmersionBar immersionBar;
        private Builder(@NonNull AppCompatActivity activity) {
            this.activity = activity;
            immersionBar = ImmersionBar.with(activity)
                    .navigationBarAlpha(1.0f).navigationBarColor(R.color.black)
                    .navigationBarWithKitkatEnable(false).fitsSystemWindows(fitsSystemWindows)
                    .statusBarDarkFont(true);
        }

        public Builder setTopVIewId(View topVIew) {
            this.topVIew = topVIew;
            immersionBar.fitsSystemWindows(false);
            immersionBar.statusBarView(topVIew);
            return this;
        }

        public Builder setTopVIewId(@IdRes int topViewId) {
            this.viewId = topViewId;
            immersionBar.fitsSystemWindows(false);
            topVIew = activity.findViewById(topViewId);
            immersionBar.statusBarView(topVIew);
            return this;
        }

        public Builder setStatusBarColor(int statusBarColor) {
            this.statusBarColor = statusBarColor;
            immersionBar.statusBarColor(statusBarColor);
            return this;
        }


        public Builder setTopVIewColor(int topVIewColor) {
            this.topVIewColor = topVIewColor;
            if (topVIew != null) {
                topVIew.setBackgroundColor(topVIewColor);
            }
            if (topVIewColor != R.color.white) {
                immersionBar.statusBarDarkFont(true);
            } else {
                immersionBar.statusBarDarkFont(true, 0.2f);
            }
            return this;
        }


        public Builder setToolBarId(@IdRes int toolBarId) {
            toolBarView = activity.findViewById(toolBarId);
            immersionBar.fitsSystemWindows(false);
            if (toolBarView != null) {
                immersionBar.titleBar(toolBarView);
            }
            this.toolBarId = toolBarId;
            return this;
        }

        public void setFitsSystemWindows(boolean fitsSystemWindows) {
            this.fitsSystemWindows = fitsSystemWindows;
            immersionBar.fitsSystemWindows(fitsSystemWindows)
                    .statusBarColor(statusBarColor);
        }

        public Builder setFullScreen(boolean fullScreen) {
            this.fullScreen = fullScreen;
            immersionBar.hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                    .fitsSystemWindows(false);
            return this;
        }

        public void applyToSystem() {
            immersionBar.init();
        }
    }
}
