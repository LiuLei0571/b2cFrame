package com.jinqiao.b2c.compent.helper;

import android.text.TextUtils;

import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.project.common.manager.UserType;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class UserHelper {
    public static UserType sEmptyUserType = new UserType();

    public static void clearUserLocalAll() {
        SPHelper.remove(Configs.USER_TYPE.TYPE);
        SPHelper.remove(Configs.isLogin);
        SPHelper.remove(Configs.TOKEN);
        SPHelper.remove(Configs.USERID);
        SPHelper.remove(Configs.NAME);
        SPHelper.remove("countryCode");
        SPHelper.remove("deliveryCompanyPhone");
        SPHelper.remove("staffPhone");
    }

    public static void clear(String name) {
        SPHelper.remove(name);
    }


    public static int getType() {
        int UserType = SPHelper.getInt(Configs.USER_TYPE.TYPE);
        return UserType;
    }


    public static UserType getUserFromLocal() {
        UserType UserType = SPHelper.getBean(Configs.USER.INFO, UserType.class);
        if (UserType != null) {
            return UserType;
        }
        return sEmptyUserType;
    }

    public static boolean isUserLogin() {
        UserType UserType = getUserFromLocal();

        return !((UserType == sEmptyUserType) || TextUtils.isEmpty(UserType.getToken()));
    }

    public static String getUsertoken() {
        UserType user = getUserFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getToken();
        }
    }

    public static String getUserName() {
        UserType user = getUserFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getLoginName();
        }
    }

    public static int getUserId() {
        UserType user = getUserFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserId();
        }
    }

    public static void saveUserUpdateInfoLocal(UserType UserType) {
        UserType oldUserType = getUserFromLocal();
        if (oldUserType != null) {
            UserType.setUserId(oldUserType.getUserId());
            UserType.setLoginName(oldUserType.getLoginName());
            UserType.setToken(oldUserType.getToken());
        }
    }

    public static void saveUserReplaceInfoLocal(UserType UserType) {
        SPHelper.putBean(Configs.USER.INFO, UserType.class);
    }
}
