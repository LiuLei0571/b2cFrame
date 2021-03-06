package com.jinqiao.b2c.compent.web.sechuduler.impl;

import android.text.TextUtils;

import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.web.ExecuteFactory;
import com.jinqiao.b2c.compent.web.bean.ProtocolBean;
import com.jinqiao.b2c.compent.web.callback.ICallBack;
import com.jinqiao.b2c.compent.web.parser.IParamParser;
import com.jinqiao.b2c.compent.web.protocol.IProtocol;
import com.jinqiao.b2c.compent.web.protocol.param.UriBean;
import com.jinqiao.b2c.compent.web.utils.WebUtil;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/1/18.
 * 邮箱：649444395@qq.com
 */

public class ActionScheduler {
    private Map<String, ProtocolBean> hybrid = new HashMap<>();
    private IParamParser mIParamParser;
    private ExecuteFactory mExecuteFactory;

    public ActionScheduler(ProtocolBean[] executes, IParamParser iParamParser) {
        mExecuteFactory = ExecuteFactory.getInstance();
        this.mIParamParser = iParamParser;
        loadExecutes(executes);
    }

    private void loadExecutes(ProtocolBean[] protocols) {
        if (protocols != null) {
            for (ProtocolBean protocol : protocols) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!TextUtils.isEmpty(protocol.getModule())) {
                    stringBuilder.append(protocol.getModule());
                }
                stringBuilder.append(protocol.getMethod());
                hybrid.put(stringBuilder.toString(), protocol);
            }
        }
    }

    public <T> boolean doExecute(IAct iAct, UriBean uriBean) {
        String module = uriBean.getModule();
        String method = uriBean.getMethod();
        String param = uriBean.getParams();
        boolean result = false;
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(module)) {
            stringBuilder.append(module);
        }
        stringBuilder.append(method);
        ProtocolBean hybridExecute = hybrid.get(stringBuilder.toString());
        if (hybridExecute != null) {
            Object paramObj=null;
            if (this.mIParamParser != null) {
                Type type = WebUtil.getSuperClassParam(hybridExecute.getExecuteCls());
                paramObj=mIParamParser.getParam(type,param);
            }
            IProtocol instane=mExecuteFactory.getExexuteInstance(hybridExecute);
            instane.doExecute(iAct, ICallBack.empty,paramObj);
            result=true;
        }
        if (!result) {

        }

        return result;
    }
}
