package com.jinqiao.b2c.compent.helper;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;

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

    /**
     * dp转px
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public static int getColor(String color) {
        if (TextUtils.isEmpty(color) || !checkColor(color)) {
            return 0;
        }
        return Color.parseColor(color);
    }
    public static boolean checkColor(String color) {
        if (TextUtils.isEmpty(color))
            return false;
        return color.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$");
    }
    public static void showHtmlContent(TextView tv, String content) {
        if (TextUtils.isEmpty(content)) {
            tv.setText("");
        } else {
            tv.setText(Html.fromHtml(content));
        }
    }
}