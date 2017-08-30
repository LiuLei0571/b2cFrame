package com.jinqiao.b2c.common.statusbar;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/29.
 * 邮箱：liulei2@aixuedai.com
 */


public class StatusBarLollipopImpl implements IStatusBar{
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setStatusBarColor(Window window, int color) {
        //取消设置透明状态栏，使ContentView内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个flag才能调用setStatusBarColor来设置状态颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }
}
