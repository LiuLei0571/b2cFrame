package com.jinqiao.b2c.project.buyer.home.manager;


import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BaseManager;
import com.jinqiao.b2c.compent.constants.Apis;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public class HomeManager extends BaseManager {
    public IResult<Object> home(){
        return super.execute(Apis.home);

    }
}
