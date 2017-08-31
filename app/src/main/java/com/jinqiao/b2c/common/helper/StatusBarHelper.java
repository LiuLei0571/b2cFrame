package com.jinqiao.b2c.common.helper;

import android.support.v7.app.AppCompatActivity;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.statusBarNew.B2cStatusBar;
import com.jinqiao.b2c.common.statusBarNew.StatusBarState;
import com.jinqiao.b2c.compent.helper.UIHelper;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/31.
 * 邮箱：liulei2@aixuedai.com
 */


public class StatusBarHelper {
    public static void initStatusBar(AppCompatActivity activity,int state){
        initStatusBar(activity,state,-1);
    }
    public static void initStatusBar(AppCompatActivity activity,int state,int viewId){
        initStatusBar(activity,viewId,state, UIHelper.getColor(R.color.white));

    }
    public static void initStatusBar(AppCompatActivity activity,int viewId,int state,int color){
        B2cStatusBar.Builder builder=B2cStatusBar.builder(activity);
        switch (state) {
            case StatusBarState.NO_INIT:
                return;
            case StatusBarState.NO_VIEW:
            case StatusBarState.NO_VIEW_COLOR_STATUS:
                builder.setStatusBarColor(color);
                break;
            case StatusBarState.TOOLBAR_VIEW:
                builder.setToolBarId(viewId);
                break;
            case StatusBarState.NORMAL_VIEW:
                builder.setTopVIewId(viewId);
                break;
            case StatusBarState.NORMAL_COLOR_VIEW:
                builder.setTopVIewId(viewId).setTopVIewColor(color);
                break;
            case StatusBarState.FULLSCREEN:
                builder.setFullScreen(true);
                break;
            default:
                break;
        }
        builder.applyToSystem();
    }
}
