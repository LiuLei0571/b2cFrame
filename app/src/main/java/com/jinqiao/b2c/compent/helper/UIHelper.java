package com.jinqiao.b2c.compent.helper;


import android.support.v4.content.ContextCompat;

import com.jinqiao.b2c.project.App;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class UIHelper {
    public static String getString(int textId) {
        return App.getContext().getString(textId);
    }

    public static int getColor(int color) {
        return ContextCompat.getColor(App.getContext(), color);
    }
}
