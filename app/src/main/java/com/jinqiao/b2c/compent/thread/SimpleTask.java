package com.jinqiao.b2c.compent.thread;


import com.jinqiao.b2c.compent.base.ILoading;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/4.
 * 邮箱：liulei2@aixuedai.com
 */


public abstract class SimpleTask<Result> extends SimpleCallback<Result> implements ITask<Result> {
    public SimpleTask() {

    }

    public SimpleTask(ILoading loading) {
        setLoading(loading);
    }
}
