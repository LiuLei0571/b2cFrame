package com.jinqiao.b2c.project.buyer.home.presenter;

import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerGoodCollectionFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeCollectionFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerShopCollectionFragment;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/9.
 * 邮箱：liulei2@aixuedai.com
 */


public class HomeCollectionPresenter extends BasePresenter<BuyerHomeCollectionFragment> {
    private static HomePage[] pages = new HomePage[]{
            new HomePage("店铺", BuyerShopCollectionFragment.class),
            new HomePage("商品", BuyerGoodCollectionFragment.class)
    };

    @Inject
    public HomeCollectionPresenter(IView iView) {
        super(iView);
    }

    public void onTabClick(int position) {
        setCurrentChildTab(position, pages,getView());
        getView().setTabItem(position);

    }
}
