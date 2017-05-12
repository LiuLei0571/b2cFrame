package com.jinqiao.b2c.compent.thread;


import com.jinqiao.b2c.common.task.ITaskBackGround;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/4.
 * 邮箱：liulei2@aixuedai.com
 */


public interface ITask<T> extends ITaskBackGround<T>,ITaskCallbackWithLoading<T> {
}
