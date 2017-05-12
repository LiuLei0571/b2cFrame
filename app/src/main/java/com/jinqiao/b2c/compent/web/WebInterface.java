package com.jinqiao.b2c.compent.web;


import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.web.bean.WebCall;
import com.jinqiao.b2c.compent.web.protocol.param.UriBean;
import com.tencent.smtt.sdk.WebView;

/**
 * 用途：
 * Created by milk on 17/1/16.
 * 邮箱：649444395@qq.com
 */

public interface WebInterface extends IAct {
    WebView getWebView();
    boolean callWeb(WebCall webCall);
    void doJsExecute(UriBean uriBean);
}
