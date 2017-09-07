package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.Variants;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public interface Configs {
    boolean LOG_D = Variants.LOG_D;
    boolean LOG_E = Variants.LOG_E;
    boolean LOG_DB = Variants.LOG_DB;
    boolean RELEASE = Variants.RELEASE;
    String BASE_URL = Variants.BASE_URL;
    String BASE_IOS=Variants.BASE_IOS;
    String EXPRESS_URL = Variants.BASE_URL_EXPRESS;
    String IMAGE_URL = Variants.BASE_PIC_URL;
    String BASE_PIC_URL = Variants.BASE_PIC_URL;

    interface USER_TYPE {
        String TYPE = "userType";
        int BUYER = 0;
        int SELLER = 1;
        int EXPRESS = 2;
        int COURIER = 3;
    }


    String URL_PRE = "axd://";
    String JS_INTERFACE = "appJS";
    String JS_INTERFACE_EXECUTE = JS_INTERFACE + ".postMessage";
    String JS_INTERFACE_GETRESULT = JS_INTERFACE + ".getResult";
    int PAGESIZE = 20;

    /**
     * 当返回的对象长度过长则通过变相方式获取结果
     */
    int MAX_H5_ARG_LENGTH = 400;

    String CURRENCY_UNIT = "Ks";
    String isLogin = "isLogin";
    String USERID = "userId";
    String TOKEN = "token";
    String NAME = "username";
    String LANGUAGE = "language";
    int MAX_IMAGE_SIZE = 6;
    String APPNAME = "appName";
    String DOMAIN = "android.jinqiao.com";


    interface USER {
        String INFO = "userInfo";

        interface TYPE {
            int BUYER = 0;
            int SELLER = 1;
            int LOGISTIC = 2;
            int EXPRESS = 3;
        }
    }

}
