package com.jinqiao.b2c.compent.web.sechuduler.impl;

import android.content.Intent;

import com.jinqiao.b2c.compent.web.WebInterface;
import com.jinqiao.b2c.compent.web.bean.ProtocolBean;
import com.jinqiao.b2c.compent.web.callback.ICallBack;
import com.jinqiao.b2c.compent.web.callback.impl.WebCallBack;
import com.jinqiao.b2c.compent.web.parser.IParamParser;
import com.jinqiao.b2c.compent.web.protocol.IProtocol;
import com.jinqiao.b2c.compent.web.sechuduler.BaseSecheduler;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/1/18.
 * 邮箱：649444395@qq.com
 */

public class WebSecheduler extends BaseSecheduler<String> {
    private WebInterface mWebInterface;
    private Map<String, ICallBack> mICallBackMap;

    public WebSecheduler(WebInterface webInterface, ProtocolBean[] executes, IParamParser iParamParser) {
        super(executes, iParamParser);
        this.mWebInterface = webInterface;
        mICallBackMap = new HashMap<>();
    }

    @Override
    protected void doAction(IProtocol intance, ICallBack callBack, Object paramObj) {
        intance.doExecute(mWebInterface, callBack, paramObj);
    }

    @Override
    protected void doActivityResult(IProtocol instance, ICallBack callBack, int requestCode, int resultCode, Intent data) {
        instance.onActivityResult(mWebInterface, callBack, requestCode, resultCode, data);
    }

    @Override
    protected ICallBack initCallBack(String callbackStr, String defaultCallBack) {
        if (callbackStr == null) {
            callbackStr = defaultCallBack;
        }
        ICallBack callBackHandler = mICallBackMap.get(callbackStr);
        if (callBackHandler == null) {
            callBackHandler = new WebCallBack(callbackStr, mWebInterface);
            mICallBackMap.put(callbackStr, callBackHandler);
        }
        return callBackHandler;
    }
}
