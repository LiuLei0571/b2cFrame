package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.compent.cdi.annotation.ActivityScope;
import com.jinqiao.b2c.compent.web.view.activity.WebViewActivity;
import com.jinqiao.b2c.project.buyer.collection.activity.MyCollectionActivity;
import com.jinqiao.b2c.project.buyer.goods.GoodsDetailActivity;
import com.jinqiao.b2c.project.buyer.goods.GoodsListActivity;
import com.jinqiao.b2c.project.buyer.goods.ShopHomesActivity;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.buyer.home.activity.SearchActivity;
import com.jinqiao.b2c.project.buyer.login.activity.LoginActivity;
import com.jinqiao.b2c.project.buyer.login.activity.ForgetPasswordActivity;
import com.jinqiao.b2c.project.buyer.login.activity.RegisterActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderEvaluateActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderLogisticsActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderReturnActivity;
import com.jinqiao.b2c.project.buyer.user.UserInfoActivity;
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

    void plus(CompanyLoginActivity companyLoginActivity);

    void plus(ExpressLoginActivity expressLoginActivity);

    void plus(SellerLoginActivity sellerLoginActivity);

    void plus(RegisterActivity registerActivity);

    void plus(ForgetPasswordActivity forgetPasswordActivity);

    void plus(LoginActivity bueyerLoginActivity);

    void plus(MyCollectionActivity myCollectionActivity);

    void plus(OrderActivity orderActivity);

    void plus(UserInfoActivity userInfoActivity);

    void plus(OrderReturnActivity orderReturnActivity);

    void plus(OrderLogisticsActivity orderLogisticsActivity);

    void plus(OrderEvaluateActivity orderEvaluateActivity);
}
