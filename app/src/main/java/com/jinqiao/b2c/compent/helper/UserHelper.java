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

    public static UserType getBuyerFromLocal() {
        UserType UserType = SPHelper.getBean(Configs.BUYER.INFO, UserType.class);
        if (UserType != null) {
            return UserType;
        }
        return sEmptyUserType;
    }
    public static boolean isLivesLogin() {
        UserType UserType = getLivesFromLocal();

        return !((UserType == sEmptyUserType) || TextUtils.isEmpty(UserType.getToken()));
    }
    public static boolean isBuyerLogin() {
        UserType UserType = getBuyerFromLocal();

        return !((UserType == sEmptyUserType) || TextUtils.isEmpty(UserType.getToken()));
    }

    public static String getBuyertoken() {
        UserType user = getBuyerFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getToken();
        }
    }

    public static String getBuyerName() {
        UserType user = getBuyerFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getLoginName();
        }
    }

    public static int getBuyerId() {
        UserType user = getBuyerFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserId();
        }
    }

    public static void saveBuyerUpdateInfoLocal(UserType UserType) {
        UserType oldUserType = getBuyerFromLocal();
        if (oldUserType != null) {
            UserType.setUserId(oldUserType.getUserId());
            UserType.setLoginName(oldUserType.getLoginName());
            UserType.setToken(oldUserType.getToken());
        }
    }

    public static void saveButerReplaceInfoLocal(UserType UserType) {
        SPHelper.putBean(Configs.SELLER.INFO, UserType.class);
    }
    public static UserType getLivesFromLocal() {
        UserType UserType = SPHelper.getBean(Configs.LIVES.INFO, UserType.class);
        if (UserType != null) {
            return UserType;
        }
        return sEmptyUserType;
    }
    public static UserType getSellerFromLocal() {
        UserType UserType = SPHelper.getBean(Configs.SELLER.INFO, UserType.class);
        if (UserType != null) {
            return UserType;
        }
        return sEmptyUserType;
    }

    public static boolean isSellerLogin() {
        UserType UserType = getSellerFromLocal();

        return !((UserType == sEmptyUserType) || TextUtils.isEmpty(UserType.getToken()));
    }
    public static  int getLivesID(){
        UserType user = getLivesFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserId();
        }
    }
    public static int getSellerID() {
        UserType user = getSellerFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserId();
        }
    }
    public static int getSellerStep() {
        UserType user = getSellerFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getStep();
        }
    }
    public static String getLivesToken(){
        UserType user = getLivesFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getToken();
        }
    }
    public static String getSellerToken() {
        UserType user = getSellerFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getToken();
        }
    }

    public static String getSellerLoginName() {
        UserType user = getSellerFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getLoginName();
        }
    }

    public static void saveSellerUpdateInfoLocal(UserType UserType) {
        UserType oldUserType = getBuyerFromLocal();
        if (oldUserType != null) {
            UserType.setUserId(oldUserType.getUserId());
            UserType.setLoginName(oldUserType.getLoginName());
            UserType.setToken(oldUserType.getToken());
        }
    }

    public static void saveSellerReplaceInfoLocal(UserType UserType) {
        SPHelper.putBean(Configs.SELLER.INFO, UserType.class);
    }

    public static void clearUserLocalAll() {
        SPHelper.remove(Configs.BUYER.INFO);
        SPHelper.remove(Configs.SELLER.INFO);
        SPHelper.remove(Configs.COURIER.INFO);
        SPHelper.remove(Configs.EXPRESS.INFO);
        SPHelper.remove(Configs.LIVES.INFO);
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

    public static UserType getExpressFromLocal() {
        UserType UserType = SPHelper.getBean(Configs.EXPRESS.INFO, UserType.class);
        if (UserType != null) {
            return UserType;
        }
        return sEmptyUserType;
    }


    public static boolean isExpressLogin() {
        UserType UserType = getExpressFromLocal();

        return !((UserType == sEmptyUserType) || TextUtils.isEmpty(UserType.getToken()));
    }

    public static int getExpressID() {
        UserType user = getExpressFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserId();
        }
    }
    public static int getType(){
        int UserType = SPHelper.getInt(Configs.USER_TYPE.TYPE);
        return UserType;
    }
    public static int getExpressType() {
        UserType user = getExpressFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getUserType();
        }
    }
    public static int getLivesLoginId(){
        UserType livesFromLocal = getLivesFromLocal();
        if (livesFromLocal == sEmptyUserType) {
            return -1;
        } else {
            return livesFromLocal.getDeliveryCompanyId();
        }
    }
    public static int getExpressLoginId() {
        UserType user = getExpressFromLocal();
        if (user == sEmptyUserType) {
            return -1;
        } else {
            return user.getDeliveryCompanyId();
        }
    }

    public static String getSExpressToken() {
        UserType user = getExpressFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getToken();
        }
    }

    public static String getExpressLoginName() {
        UserType user = getExpressFromLocal();
        if (user == sEmptyUserType) {
            return "";
        } else {
            return user.getLoginName();
        }
    }

    public static void saveExpressUpdateInfoLocal(UserType UserType) {
        UserType oldUserType = getExpressFromLocal();
        if (oldUserType != null) {
            UserType.setUserId(oldUserType.getUserId());
            UserType.setLoginName(oldUserType.getLoginName());
            UserType.setToken(oldUserType.getToken());
        }
    }

    public static void saveExpressReplaceInfoLocal(UserType UserType) {
        SPHelper.putBean(Configs.EXPRESS.INFO, UserType);
    }
}
