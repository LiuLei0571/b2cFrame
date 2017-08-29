package com.jinqiao.b2c.common.statusbar;

import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 用途：    /**
 * 设置Android状态栏的字体颜色，状态栏为亮色的时候字体和图标是黑色，状态栏为暗色的时候字体和图标为白色
 * lightStatusBar 状态栏字体和图标是否为深色
 * 作者：Created by liulei on 17/8/29.
 * 邮箱：liulei2@aixuedai.com
 */


public class LightStatusBarCompat {


    interface ILightStatusBar {
        void setLightStatusBar(Window window, boolean lightStatusBar);
    }

    public static ILightStatusBar IMPL;

    static {
        if (StatusBarFontDarkMIUI.isMe()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                IMPL = new MLightStatusBar() {
                    private ILightStatusBar DEFAULT = new MLightStatusBar();

                    @Override
                    public void setLightStatusBar(Window window, boolean lightStatusBar) {
                        super.setLightStatusBar(window, lightStatusBar);
                        DEFAULT.setLightStatusBar(window, lightStatusBar);
                    }
                };
            } else {
                IMPL = new StatusBarFontDarkMIUI();
            }
        } else if (StatusBarFontDarkMEIZU.isMe()) {
            IMPL = new StatusBarFontDarkMEIZU();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            IMPL = new MLightStatusBar();
        } else {
            IMPL = new ILightStatusBar() {
                @Override
                public void setLightStatusBar(Window window, boolean lightStatusBar) {

                }
            };
        }
    }

    public static void setLighStatusBar(Window window, boolean lightBar) {
        IMPL.setLightStatusBar(window, lightBar);
    }

    protected static class MLightStatusBar implements ILightStatusBar {

        @Override
        public void setLightStatusBar(Window window, boolean lightStatusBar) {
            View decor = window.getDecorView();
            int ui = decor.getSystemUiVisibility();
            if (lightStatusBar) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                ui &= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            decor.setSystemUiVisibility(ui);
        }
    }

    protected static class StatusBarFontDarkMIUI implements ILightStatusBar {
        // 小米MIUI
        private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
        private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
        private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

        static boolean isMe() {
            FileInputStream is = null;
            try {
                is = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                Properties prop = new Properties();
                prop.load(is);
                return prop.getProperty(KEY_MIUI_VERSION_CODE) != null
                        || prop.getProperty(KEY_MIUI_VERSION_NAME) != null
                        || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE) != null;
            } catch (final IOException e) {
                return false;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        // ignore all exception
                    }
                }
            }
        }

        @Override
        public void setLightStatusBar(Window window, boolean lightStatusBar) {
            try {
                Class clazz = window.getClass();
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                int darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (lightStatusBar) {    //状态栏亮色且黑色字体
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
                } else {       //清除黑色字体
                    extraFlagField.invoke(window, 0, darkModeFlag);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static class StatusBarFontDarkMEIZU implements ILightStatusBar {

        public static boolean isMe() {
            try {
                return Build.DISPLAY.startsWith("Flyme");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public void setLightStatusBar(Window window, boolean lightStatusBar) {
            // 魅族FlymeUI
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (lightStatusBar) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // android6.0+系统
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (lightStatusBar) {
                    window.getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            }

        }

    }

}
