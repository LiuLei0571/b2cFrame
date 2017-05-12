package com.jinqiao.b2c.common.http.impl.okhttp3;


import com.jinqiao.b2c.common.http.ApiCall;
import com.jinqiao.b2c.common.http.IRequest;
import com.jinqiao.b2c.common.http.IResponse;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 用途：
 * Created by milk on 17/4/21.
 * 邮箱：649444395@qq.com
 */

public class OkHttpCall extends ApiCall {
    public Call call;
    public OkHttpCall(IRequest httpRequest, Call call) {
        super(httpRequest);
        this.call = call;
        setReady();
    }


    @Override
    protected void doCancel() {
        call.cancel();
    }

    @Override
    protected IResponse doExecute() throws Exception {
        Response  response = call.execute();
        return new OkHttpResponse(response);
    }
}
