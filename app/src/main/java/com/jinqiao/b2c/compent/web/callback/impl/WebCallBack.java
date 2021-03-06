package com.jinqiao.b2c.compent.web.callback.impl;


import com.jinqiao.b2c.compent.web.WebInterface;
import com.jinqiao.b2c.compent.web.bean.WebCall;
import com.jinqiao.b2c.compent.web.callback.ICallBack;

/**
 * 用途：
 * Created by milk on 17/1/19.
 * 邮箱：649444395@qq.com
 */

public class WebCallBack implements ICallBack {
    private String callBackJs;
    private WebInterface mWebInterface;

    public WebCallBack(String callBackJs, WebInterface webInterface) {
        this.callBackJs = callBackJs;
        mWebInterface = webInterface;
    }

    @Override
    public void invoke(Object data) {
        WebCall webCall = null;
        if (data instanceof WebCall) {
            webCall = (WebCall) data;
        } else {
            if (data instanceof Object[]) {
                webCall = WebCall.newWebCall(callBackJs);
                if (webCall != null) {
                    Object[] args = (Object[]) data;
                    webCall.setArgs(args);
                }
            }
        }
        mWebInterface.callWeb(webCall);
    }

    @Override
    public void invokeAndKeepAlive(Object data) {
        invoke(data);
    }
}
