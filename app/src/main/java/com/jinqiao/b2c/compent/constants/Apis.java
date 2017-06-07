package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.home.manager.bean.CategoryFirstListResult;
import com.jinqiao.b2c.project.buyer.user.manager.module.BuyerUser;
import com.jinqiao.b2c.project.common.manager.bean.TranslatesResult;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public interface Apis {
    //buyer
    Api home = Api.Post("banner/homePage.htm", Types.home).setLogin(false);
    Api translates = Api.Post("common/listTranslates.htm", TranslatesResult.class);
    Api homeClassifty = Api.GET("category/getCategoryList.htm", CategoryFirstListResult.class);
    Api buerLogin = Api.Post("user/login.htm", BuyerUser.class);

}
