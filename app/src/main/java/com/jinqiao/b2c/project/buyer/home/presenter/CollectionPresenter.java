package com.jinqiao.b2c.project.buyer.home.presenter;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.base.TempleRefreshFragment;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.home.manager.HomeManager;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/20.
 * 邮箱：liulei2@aixuedai.com
 */


public class CollectionPresenter extends BasePresenter<TempleRefreshFragment> {
    @Inject
    HomeManager mManager;

    @Inject
    public CollectionPresenter(IView iView) {
        super(iView);
    }

    public void getDeletCollectGood(int id) {
        submitTask(new ApiTask<Object>(getBaseActivity()) {
            @Override
            public IResult onBackGround() throws Exception {
                return mManager.deleteGoodCollection(id);
            }

            @Override
            public void onSuccess(IResult<Object> result) {
                super.onSuccess(result);
                getView().refreshData();
            }
        });
    }

    public void getDeletCollectShop(int id) {
        submitTask(new ApiTask<Object>(getBaseActivity()) {
            @Override
            public IResult onBackGround() throws Exception {
                return mManager.deleteShopCollection(id);
            }

            @Override
            public void onSuccess(IResult<Object> result) {
                super.onSuccess(result);
                getView().refreshData();
            }
        });
    }

}
