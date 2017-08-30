package com.jinqiao.b2c.common.statusbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 用途：
 * 作者：Created by liulei on 17/8/28.
 * 邮箱：liulei2@aixuedai.com
 */


public class StatusBarCompat {
    static final IStatusBar IMPL;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            IMPL = new StatusBarMImpl();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !isEMUI() ) {
            IMPL = new StatusBarLollipopImpl();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            IMPL = new StatusBarKitkatImpl();
        } else {
            IMPL = new IStatusBar() {
                @Override
                public void setStatusBarColor(Window window, int color) {

                }
            };
        }
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static void setFitsSystemWindows(Window window, boolean fitSystemWindows) {
        ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
            mChildView.setFitsSystemWindows(fitSystemWindows);
        }
    }
    private static boolean isEMUI() {
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (file.exists()) {
            Properties properties = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                properties.load(fis);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return properties.containsKey("ro.build.hw_emui_api_level");
        }
        return false;
    }
    public static void setStatusBarColor(Activity activity, @ColorInt int color) {
        boolean isLightColor = toGrey(color) > 225;
        //默认全部为深色状态栏lightStatusBar=true
        setStatusBarColor(activity, color, true);
    }

    /**
     * 把颜色转换成灰度值。(计算得出是否需要设置深色)
     * 代码来自 Flyme 示例代码
     */
    public static int toGrey(@ColorInt int color) {
        int blue = Color.blue(color);
        int green = Color.green(color);
        int red = Color.red(color);
        return (red * 38 + green * 75 + blue * 15) >> 7;
    }

    /**
     * Set system status bar color.
     *
     * @param activity
     * @param color          status bar color
     * @param lightStatusBar if the status bar color is light. Only effective in some devices.
     */
    public static void setStatusBarColor(Activity activity, @ColorInt int color, boolean lightStatusBar) {
        setStatusBarColor(activity.getWindow(), color, lightStatusBar);
    }

    public static void setStatusBarColor(Window window, @ColorInt int color, boolean lightStatusBar) {
        IMPL.setStatusBarColor(window, color);
        LightStatusBarCompat.setLighStatusBar(window, lightStatusBar);
    }


}
