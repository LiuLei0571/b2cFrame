package com.jinqiao.b2c.project.buyer.collection.presenter;

import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.project.buyer.collection.activity.MyCollectionActivity;
import com.jinqiao.b2c.project.buyer.collection.fragment.BuyerGoodCollectionFragment;
import com.jinqiao.b2c.project.buyer.collection.fragment.BuyerShopCollectionFragment;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/9.
 * 邮箱：liulei2@aixuedai.com
 */


public class MyCollectionPresenter extends BasePresenter<MyCollectionActivity> {
    private static HomePage[] pages = new HomePage[]{
            new HomePage("店铺", BuyerShopCollectionFragment.class),
            new HomePage("商品", BuyerGoodCollectionFragment.class)
    };

    @Inject
    public MyCollectionPresenter(IView iView) {
        super(iView);
    }

    public void onTabClick(int position) {
        setCurrentTab(position, pages);
        getView().setTabItem(position);

    }
}
