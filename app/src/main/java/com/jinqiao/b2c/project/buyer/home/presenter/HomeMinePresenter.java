package com.jinqiao.b2c.project.buyer.home.presenter;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.home.fragment.BuyerHomeMineFragment;
import com.jinqiao.b2c.project.buyer.login.module.User;
import com.jinqiao.b2c.project.buyer.login.module.manager.UserManager;
import com.jinqiao.b2c.project.buyer.user.UserInfo;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class HomeMinePresenter extends BasePresenter<BuyerHomeMineFragment> {
    @Inject
    UserManager mUserManager;

    @Inject
    public HomeMinePresenter(IView iView) {
        super(iView);
    }

    public void getUserInfo() {
        submitTask(new ApiTask<IResult<UserInfo>>() {
            @Override
            public IResult<UserInfo> onBackGround() throws Exception {
                return mUserManager.getUserInfo();
            }

            @Override
            public void onSuccess(IResult<IResult<UserInfo>> result) {
                super.onSuccess(result);
                if (result.data() != null) {
                    UserInfo mUser = (UserInfo) result.data();
                    SPHelper.putBean(Configs.USER.INFO, mUser);
                    getView().initData(mUser);
                }
            }

            @Override
            public void onFailure(IResult<String> result) {
            }
        });
    }

}
