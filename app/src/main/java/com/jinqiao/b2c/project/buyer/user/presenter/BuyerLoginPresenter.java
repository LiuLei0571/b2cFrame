package com.jinqiao.b2c.project.buyer.user.presenter;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.compent.helper.SysHelper;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.user.activity.BuyerLoginActivity;
import com.jinqiao.b2c.project.buyer.user.manager.BuyerUserManager;
import com.jinqiao.b2c.project.buyer.user.manager.module.BuyerUser;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerLoginPresenter extends BasePresenter<BuyerLoginActivity> {
    @Inject
    BuyerUserManager mBuyerUserManager;

    @Inject
    public BuyerLoginPresenter(IView iView) {
        super(iView);
    }

    public void login(String name, String password, String type) {
        submitTask(new ApiTask<BuyerUser>(getBaseActivity()) {
            @Override
            public IResult onBackGround() throws Exception {
                return mBuyerUserManager.login(name, password, type);
            }

            @Override
            public void onSuccess(IResult<BuyerUser> result) {
                super.onSuccess(result);
                if (result.data() != null) {
                    SPHelper.putBean(Configs.BUYER.INFO, result.data());
                    SysHelper.goBuyerHome(getBaseActivity(), 4);
                }
            }
        });
    }
}
