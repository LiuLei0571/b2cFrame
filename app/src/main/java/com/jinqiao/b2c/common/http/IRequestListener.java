package com.jinqiao.b2c.common.http;

/**
 * 用途：
 * Created by milk on 17/4/21.
 * 邮箱：649444395@qq.com
 */

public interface IRequestListener {
    void beforeRequest(ICall iCall);

    void afterRequest(ICall call, IResponse response);
}
