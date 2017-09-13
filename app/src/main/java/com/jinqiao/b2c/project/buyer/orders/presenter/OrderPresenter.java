package com.jinqiao.b2c.project.buyer.orders.presenter;

import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderTempleRefreshFragment;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderPresenter extends BasePresenter<OrderTempleRefreshFragment> {
    @Inject
    public OrderPresenter(IView iView) {
        super(iView);
    }
}
