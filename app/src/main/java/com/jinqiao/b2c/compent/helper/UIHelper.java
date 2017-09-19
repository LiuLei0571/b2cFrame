package com.jinqiao.b2c.compent.helper;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jinqiao.b2c.project.App;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class UIHelper {
    public static Context context = App.getContext();

    public static String getString(int textId) {
        return App.getContext().getString(textId);
    }

    /**
     * 获取图片资源文件
     *
     * @param drawableId
     * @return
     */
    public static Drawable getDrawable(int drawableId) {
        return context.getResources().getDrawable(drawableId);
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

    /**
     * px转dp
     *
     * @param pxVal
     * @return
     */
    public float px2dp(float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
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

    public static View inflaterLayout(Context context, int popup_search) {
        return LayoutInflater.from(context).inflate(popup_search, null);
    }
}
