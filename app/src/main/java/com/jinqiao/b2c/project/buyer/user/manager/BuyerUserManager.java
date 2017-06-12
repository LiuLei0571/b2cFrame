package com.jinqiao.b2c.project.buyer.user.manager;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.common.utils.encrypt.Md5Encrypt;
import com.jinqiao.b2c.compent.base.BaseManager;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.project.buyer.user.manager.module.BuyerUser;

import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerUserManager extends BaseManager {

    public IResult<BuyerUser> login(String name, String password, String type) {
        Map<String, Object> parameter = getHashMap();
        parameter.put("loginName", name);
        parameter.put("password", Md5Encrypt.md5(password));
        parameter.put("type", type);
        return execute(Apis.buyerLogin, parameter);
    }
}
