package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.compent.cdi.annotation.ActivityScope;
import com.jinqiao.b2c.compent.web.view.activity.WebViewActivity;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.common.activity.SplashActivity;
import com.jinqiao.b2c.project.express.home.activity.ExpressHomeActivity;
import com.jinqiao.b2c.project.logistics.home.activity.LogisticsHomeActivity;
import com.jinqiao.b2c.project.seller.home.activity.SellerHomeActivity;

import dagger.Subcomponent;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void plus(WebViewActivity webViewActivity);

    void plus(SplashActivity splashActivity);


    void plus(LogisticsHomeActivity logisticsHomeActivity);

    void plus(ExpressHomeActivity expressHomeActivity);

    void plus(SellerHomeActivity sellerHomeActivity);

    void plus(BuyerHomeActivity buyerHomeActivity);
}
