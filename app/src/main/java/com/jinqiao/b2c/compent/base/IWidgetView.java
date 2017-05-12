package com.jinqiao.b2c.compent.base;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * 用途：
 * Created by milk on 17/4/19.
 * 邮箱：649444395@qq.com
 */

public interface IWidgetView {
    @LayoutRes
    int getRootLayoutId();

    void beforeViewBind(View view);

    void afterViewBind(View view);
}
