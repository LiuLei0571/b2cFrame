package com.jinqiao.b2c.compent.base;

import android.content.ContentResolver;

import com.jinqiao.b2c.common.helper.ContextHelper;
import com.jinqiao.b2c.common.task.IGroup;
import com.jinqiao.b2c.common.task.ITaskBackGround;
import com.jinqiao.b2c.common.task.ITaskCallBack;
import com.jinqiao.b2c.compent.helper.TaskHelper;
import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.compent.thread.ITask;

import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/4/19.
 * 邮箱：649444395@qq.com
 */

public class BaseSimplePresenter {
    IGroup mIGroup;

    public BaseSimplePresenter(IGroup IGroup) {
        mIGroup = IGroup;
    }

    protected final String getNameFromTrace(StackTraceElement[] traceElements, int place) {
        String taskName;
        String className = getClass().getName();
        if (traceElements != null && traceElements.length > place) {
            StackTraceElement traceElement = traceElements[place];
            taskName = className + ":" + traceElement.getLineNumber();
        } else {
            taskName = className + ":task-" + System.currentTimeMillis();
        }
        return taskName;
    }

    public final <T> void submitTask(ITask<T> task) {
        submitTask(getNameFromTrace(Thread.currentThread().getStackTrace(), 3), task);
    }

    public final <T> void submitTask(String taskName, ITask<T> task) {
        TaskHelper.submitTask(taskName, mIGroup.groupName(), task, task);
    }

    public final <T> void submitTask(String taskName, ITaskBackGround<T> task, ITaskCallBack<T> callBack) {
        TaskHelper.submitTask(taskName, mIGroup.groupName(), task, callBack);
    }

    public final <T> void submitTask(ITaskBackGround<T> task, ITaskCallBack<T> callBack) {
        TaskHelper.submitTask(getNameFromTrace(Thread.currentThread().getStackTrace(), 3), mIGroup.groupName(), task, callBack);
    }

    public final <T> void apiCall(Api api, Map<String, Object> params, ITaskCallBack<T> apiCallback) {
        TaskHelper.apiCall(mIGroup, api, params, apiCallback);
    }

    public final <T> void apiCall(Api api, ITaskCallBack<T> apiCallback) {
        TaskHelper.apiCall(mIGroup, api, apiCallback);
    }


    public ContentResolver getContentResolver() {
        return ContextHelper.getContext().getContentResolver();
    }

    public String getString(int strId, Object fromObj) {
        return ContextHelper.getContext().getString(strId, fromObj);
    }
}
