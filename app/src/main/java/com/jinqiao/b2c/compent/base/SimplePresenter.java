package com.jinqiao.b2c.compent.base;


import com.jinqiao.b2c.common.task.IGroup;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/3.
 * 邮箱：liulei2@aixuedai.com
 */


public class SimplePresenter extends BaseSimplePresenter {
    @Inject
    public SimplePresenter(IGroup IGroup) {
        super(IGroup);
    }
}
