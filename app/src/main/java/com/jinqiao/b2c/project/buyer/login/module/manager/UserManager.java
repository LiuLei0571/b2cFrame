package com.jinqiao.b2c.project.buyer.login.module.manager;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.common.utils.DateUtil;
import com.jinqiao.b2c.common.utils.encrypt.Md5Encrypt;
import com.jinqiao.b2c.compent.base.BaseManager;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.project.buyer.login.module.User;
import com.jinqiao.b2c.project.buyer.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class UserManager extends BaseManager {
    public IResult<User> login(String username, String password, int type) {
        updateLoginTime();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("loginName", username);
        parameters.put("type", type + "");

        try {
            parameters.put("password", Md5Encrypt.md5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute(Apis.buyerLogin, parameters);
    }

    public IResult<String> getEmail(String email, String type) {
        Map<String, Object> parameters = getHashMap();
        parameters.put("email", email);
        parameters.put("type", type + "");
        return execute(Apis.getEmail, parameters);
    }
    public IResult<UserInfo> getUserInfo(){
        return execute(Apis.getUserInfo);
    }

    public void updateLoginTime() {
        SPHelper.putString(Configs.APPNAME, Configs.DOMAIN + "-" + DateUtil.getTimeStamp());

    }
}
