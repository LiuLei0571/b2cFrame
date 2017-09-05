package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.compent.cdi.annotation.ActivityScope;
import com.jinqiao.b2c.compent.web.view.activity.WebViewActivity;
import com.jinqiao.b2c.project.buyer.goods.GoodsDetailActivity;
import com.jinqiao.b2c.project.buyer.goods.GoodsListActivity;
import com.jinqiao.b2c.project.buyer.goods.ShopHomesActivity;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.buyer.home.activity.SearchActivity;
import com.jinqiao.b2c.project.buyer.login.activity.LoginActivity;
import com.jinqiao.b2c.project.buyer.user.activity.ForgetPswActivity;
import com.jinqiao.b2c.project.buyer.user.activity.RegisterActivity;
import com.jinqiao.b2c.project.common.activity.SelectLoginActivity;
import com.jinqiao.b2c.project.common.activity.SplashActivity;
import com.jinqiao.b2c.project.express.home.activity.ExpressHomeActivity;
import com.jinqiao.b2c.project.express.user.activity.ExpressLoginActivity;
import com.jinqiao.b2c.project.logistics.LivesCommuntiyHomeActivity;
import com.jinqiao.b2c.project.logistics.home.activity.LogisticsHomeActivity;
import com.jinqiao.b2c.project.logistics.user.CompanyLoginActivity;
import com.jinqiao.b2c.project.seller.home.activity.SellerHomeActivity;
import com.jinqiao.b2c.project.seller.user.SellerLoginActivity;

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

    void plus(GoodsDetailActivity goodsDetailActivity);

    void plus(ShopHomesActivity shopHomesActivity);

    void plus(GoodsListActivity goodsListActivity);

    void plus(SearchActivity searchActivity);

    void plus(LivesCommuntiyHomeActivity livesCommuntiyHomeActivity);

    void plus(com.jinqiao.b2c.project.buyer.user.activity.BuyerLoginActivity loginActivity);

    void plus(SelectLoginActivity sellectLoginActivity);

    void plus(CompanyLoginActivity companyLoginActivity);

    void plus(ExpressLoginActivity expressLoginActivity);

    void plus(SellerLoginActivity sellerLoginActivity);

    void plus(RegisterActivity registerActivity);

    void plus(ForgetPswActivity forgetPswActivity);

    void plus(LoginActivity bueyerLoginActivity);
}
