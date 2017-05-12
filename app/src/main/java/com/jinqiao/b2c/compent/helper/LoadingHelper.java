package com.jinqiao.b2c.compent.helper;


import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.ui.widget.Progress;

/**
 * 用途：
 * Created by milk on 16/8/27.
 * 邮箱：649444395@qq.com
 */
public class LoadingHelper {
    public static void showLoading(BaseActivity fragmentActivity) {
        Progress.show(fragmentActivity, null);
    }

    public static void showLoading(BaseActivity fragmentActivity, String content) {
        Progress.show(fragmentActivity, content);
    }

    public static void dismiss() {
        Progress.dismiss();
    }
}
