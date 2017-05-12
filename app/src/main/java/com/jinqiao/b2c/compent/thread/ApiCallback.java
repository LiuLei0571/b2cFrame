package com.jinqiao.b2c.compent.thread;

import android.accounts.NetworkErrorException;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.ILoading;
import com.jinqiao.b2c.compent.helper.ToastHelper;
import com.jinqiao.b2c.compent.http.ErrorInfo;
import com.jinqiao.b2c.compent.http.Result;

import java.net.SocketException;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/4.
 * 邮箱：liulei2@aixuedai.com
 */


public class ApiCallback<T> extends SimpleCallback<IResult<T>> implements IApiCAllback<T> {

    public ApiCallback(ILoading loading) {
        setLoading(loading);
    }

    public ApiCallback() {
    }

    @Override
    public void onException(Throwable throwable) {
        if (throwable instanceof NetworkErrorException) {
            onFailure(Result.fail("网络未开启"));
        } else if (throwable instanceof SocketException) {
            onFailure(Result.fail("网络异常"));
        }

    }

    @Override
    public void onComplete(IResult result) {
        if (result.success()) {
            onSuccess(result);
        } else {
            onFailure(result);
        }
    }

    @Override
    public void onSuccess(IResult<T> result) {

    }

    @Override
    public void onFailure(IResult<String> result) {
        if (result != null) {
            ErrorInfo errorInfo = result.errorInfo();
            if (result.msg() != null) {
                ToastHelper.makeErrorToast(result.msg());

            } else if (errorInfo != null) {
                ToastHelper.makeErrorToast(errorInfo.getErrorInfo());
            }
        }
    }

    @Override
    public void onAfterCall() {
        super.onAfterCall();
    }
}
