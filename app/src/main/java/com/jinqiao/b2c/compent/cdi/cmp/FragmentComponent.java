package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.compent.cdi.annotation.FragmentScope;
import com.jinqiao.b2c.compent.web.view.fragment.WebViewFragment;
import com.jinqiao.b2c.project.buyer.collection.fragment.BuyerGoodCollectionFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeCarFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeClassifyFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeIndexFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeMineFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeCollectionFragment;
import com.jinqiao.b2c.project.buyer.collection.fragment.BuyerShopCollectionFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderAllFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderReceivedFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderRejectFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderReturnFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderWaitReceiptFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderWaitSendFragment;

import dagger.Subcomponent;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
 public interface FragmentComponent {
    void plus(WebViewFragment webViewFragment);

    void plus(BuyerHomeIndexFragment buyerHomeIndexFragment);

    void plus(BuyerHomeCarFragment buyerHomeCarFragment);

    void plus(BuyerHomeClassifyFragment buyerHomeClassifyFragment);

    void plus(BuyerHomeCollectionFragment buyerHomeCollectionFragment);

    void plus(BuyerHomeMineFragment buyerHomeMineFragment);

    void plus(BuyerGoodCollectionFragment buyerGoodCollectionFragment);

   void plus(BuyerShopCollectionFragment buyerShopCollectionFragment);

    void plus(OrderAllFragment orderAllFragment);

    void plus(OrderWaitSendFragment orderWaitSendFragment);

    void plus(OrderWaitReceiptFragment orderWaitReceiptFragment);

    void plus(OrderReturnFragment orderReturnFragment);

    void plus(OrderRejectFragment orderRejectFragment);

    void plus(OrderReceivedFragment orderReceivedFragment);
}
