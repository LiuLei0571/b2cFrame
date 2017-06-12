package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.home.manager.bean.CategoryFirstListResult;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteGoods;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteShop;
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
    Api translates = Api.Post("common/listTranslates.htm", TranslatesResult.class).setLogin(false);
    Api homeClassifty = Api.GET("category/getCategoryList.htm", CategoryFirstListResult.class).setLogin(false);
    Api buyerLogin = Api.Post("user/login.htm", BuyerUser.class).setLogin(false);
    Api buyerShopCollection = Api.Post("user/favoriteShopList.htm", FavoriteShop.class);
    Api buyerGoodCollection = Api.Post("user/favoriteSampleList", FavoriteGoods.class);
}
