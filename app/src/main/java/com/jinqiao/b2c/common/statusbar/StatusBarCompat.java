package com.jinqiao.b2c.common.statusbar;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/28.
 * 邮箱：liulei2@aixuedai.com
 */


public class StatusBarCompat {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static    void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                // 去掉系统状态栏下的windowContentOverlay
                View v = window.findViewById(android.R.id.content);
//                if (v != null) {
//                    v.setForeground(null);
//                }
                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
