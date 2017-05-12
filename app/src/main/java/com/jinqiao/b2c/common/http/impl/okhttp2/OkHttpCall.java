package com.jinqiao.b2c.common.http.impl.okhttp2;

import com.jinqiao.b2c.common.http.ApiCall;
import com.jinqiao.b2c.common.http.IRequest;
import com.jinqiao.b2c.common.http.IResponse;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;

/**
 * 用途：
 * Created by milk on 17/4/21.
 * 邮箱：649444395@qq.com
 */

public class OkHttpCall extends ApiCall {
    protected Call call;

    public OkHttpCall(IRequest httpRequest, Call call) {
        super(httpRequest);
        this.call = call;
    }

    @Override
    public IRequest getRequest() {
        return null;
    }

    @Override
    protected void doCancel() {
        call.cancel();
    }

    @Override
    protected IResponse doExecute() throws Exception {
        Response response=call.execute();
        return new OkHttpResponse(response);
    }
}
