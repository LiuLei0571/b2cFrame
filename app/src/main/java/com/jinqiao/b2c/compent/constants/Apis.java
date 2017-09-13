package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.collection.module.manager.FavoriteGoods;
import com.jinqiao.b2c.project.buyer.collection.module.manager.FavoriteShop;
import com.jinqiao.b2c.project.buyer.home.manager.bean.CategoryFirstListResult;
import com.jinqiao.b2c.project.buyer.login.module.User;
import com.jinqiao.b2c.project.buyer.orders.module.MyOrderResult;
import com.jinqiao.b2c.project.buyer.user.UserInfo;
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
    Api buyerLogin = Api.Post("user/login.htm", User.class).setLogin(false);
    Api buyerShopCollection = Api.Post("user/favoriteShopList.htm", FavoriteShop.class);
    Api buyerGoodCollection = Api.Post("user/favoriteSampleList.htm", FavoriteGoods.class);
    Api buyerDeleteGoodFavorite = Api.Post("user/deleteFavorite.htm");
    Api buyerDeleteShopFavorite = Api.Post("user/deleteFavorite.htm");
    Api getEmail = Api.Post("user/send-email-code.htm").setLogin(false);
    Api getUserInfo = Api.Post("user/getUserInfo.htm",UserInfo.class).setIHost(Hosts.ios);
    Api buyerOrder=Api.Post("trade/buyer/orderList.htm",MyOrderResult.class);
    Api buyerRemindOrder=Api.Post("trade/buyer/remindSellerToShip.htm",MyOrderResult.class);
}
