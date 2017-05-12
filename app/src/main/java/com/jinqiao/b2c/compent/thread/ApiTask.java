package com.jinqiao.b2c.compent.thread;


import com.jinqiao.b2c.common.helper.ThreadHelper;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.ILoading;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/4.
 * 邮箱：liulei2@aixuedai.com
 */


public class ApiTask<Result> extends ApiCallback<Result> implements ITask<IResult<Result>> {
    public ApiTask() {
    }

    public ApiTask(ILoading loading) {
        super.setLoading(loading);
    }

    public void doFailure(final IResult<String> result) {
        if (ThreadHelper.isMainThread()) {
            onFailure(result);
        } else {
            ThreadHelper.postMain(new Runnable() {
                @Override
                public void run() {
                    onFailure(result);
                }
            });
        }
    }


    @Override
    public <T> T onBackGround() throws Exception {
        return null;
    }
}
