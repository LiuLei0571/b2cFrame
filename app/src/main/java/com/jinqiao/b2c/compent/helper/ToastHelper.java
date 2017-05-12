package com.jinqiao.b2c.compent.helper;


import com.jinqiao.b2c.compent.ui.AppToast;

/**
 * 用途：
 * Created by milk on 17/4/20.
 * 邮箱：649444395@qq.com
 */

public class ToastHelper {
    private static AppToast sAppToast;

    static {
        sAppToast = CDIHelper.getInstance().mAppToast;
    }

    public static void makeToast(String content) {
        sAppToast.makeToast(content);
    }

    public static void makeErrorToast(String content) {
        sAppToast.makeImgToast(content);
    }
}
