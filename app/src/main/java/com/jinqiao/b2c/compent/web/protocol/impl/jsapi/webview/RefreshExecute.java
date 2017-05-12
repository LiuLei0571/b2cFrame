package com.jinqiao.b2c.compent.web.protocol.impl.jsapi.webview;


import com.jinqiao.b2c.compent.web.WebInterface;
import com.jinqiao.b2c.compent.web.callback.ICallBack;
import com.jinqiao.b2c.compent.web.protocol.BaseProtocolInstance;
import com.jinqiao.b2c.compent.web.protocol.param.WebRefreshParam;
import com.jinqiao.b2c.compent.web.utils.WebUtil;
import com.tencent.smtt.sdk.WebView;


/**
 * 用途：
 * Created by milk on 17/3/17.
 * 邮箱：649444395@qq.com
 */

public class RefreshExecute extends BaseProtocolInstance<WebRefreshParam> {
    @Override
    public void doExecute(WebInterface iAct, ICallBack iCallBack, WebRefreshParam params) {
        if (params == null) {
            fail_arg_error(iCallBack);
        }
        WebView webView=iAct.getWebView();
        String reloadUrl=webView.getUrl();
        if(params.joinLoinInfo){
        webView.loadUrl( WebUtil.refresh(reloadUrl));
        }else {
            webView.loadUrl(reloadUrl);
        }
        success(iCallBack);
    }
}
