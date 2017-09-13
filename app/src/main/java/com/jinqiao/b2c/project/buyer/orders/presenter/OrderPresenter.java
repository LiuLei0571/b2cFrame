package com.jinqiao.b2c.project.buyer.orders.presenter;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderTempleRefreshFragment;
import com.jinqiao.b2c.project.buyer.orders.module.MyOrderResult;
import com.jinqiao.b2c.project.buyer.orders.module.OrderManager;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderPresenter extends BasePresenter<OrderTempleRefreshFragment> {
    @Inject
    OrderManager mManager;

    @Inject
    public OrderPresenter(IView iView) {
        super(iView);
    }

    public void getOrderList(int mPage, String type,boolean isFirst) {
        submitTask(new ApiTask<IResult<MyOrderResult>>(getILoading()) {
            @Override
            public IResult<MyOrderResult> onBackGround() throws Exception {
                return mManager.getOrderList(mPage, type);
            }

            @Override
            public void onSuccess(IResult<IResult<MyOrderResult>> result) {
                super.onSuccess(result);
                if (result.data() != null) {
                    MyOrderResult myOrderResult= (MyOrderResult) result.data();
                    getView().initData(myOrderResult,isFirst);
                }
            }

            @Override
            public void onAfterCall() {
                super.onAfterCall();
                getView().refreshData(isFirst);
            }
        });
    }
}
