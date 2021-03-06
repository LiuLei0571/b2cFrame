package com.jinqiao.b2c.compent.thread;


import com.jinqiao.b2c.common.http.IResult;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/4.
 * 邮箱：liulei2@aixuedai.com
 */


public interface IApiCAllback<T> {
    void onSuccess(IResult<T> result);

    void onFailure(IResult<String> result);
}
