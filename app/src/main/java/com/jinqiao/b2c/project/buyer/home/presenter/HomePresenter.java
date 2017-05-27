package com.jinqiao.b2c.project.buyer.home.presenter;


import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeCarFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeClassifyFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeCollectionFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeIndexFragment;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeMineFragment;

import javax.inject.Inject;

/**
 * 用途：
 * Created by milk on 17/4/19.
 * 邮箱：649444395@qq.com
 */

public class HomePresenter extends BasePresenter<BuyerHomeActivity> {
    private static HomePage[] pages = new HomePage[]{
            new HomePage("商城", BuyerHomeIndexFragment.class),
            new HomePage("分类", BuyerHomeClassifyFragment.class),
            new HomePage("购物车", BuyerHomeCarFragment.class),
            new HomePage("收藏", BuyerHomeCollectionFragment.class),
            new HomePage("我的", BuyerHomeMineFragment.class)

    };

    @Inject
    public HomePresenter(IView iView) {
        super(iView);
    }

    public void onTabClick(int position) {
        setCurrentTab(position, pages);
        getView().setTabItem(position);

    }
}
