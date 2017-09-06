package com.jinqiao.b2c.project.buyer.login.presenter;

import android.text.TextUtils;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.helper.ToastHelper;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.login.activity.LoginActivity;
import com.jinqiao.b2c.project.buyer.login.module.BuyerUser;
import com.jinqiao.b2c.project.buyer.login.module.manager.UserManager;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class LoginPresenter extends BasePresenter<LoginActivity> {
    @Inject
    UserManager mUserManager;

    @Inject
    public LoginPresenter(IView iView) {
        super(iView);
    }

    public void login(String name, String password, int type) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            ToastHelper.makeToast("用户名不允许为空");
            return;
        } else if (TextUtils.isEmpty(password)) {
            ToastHelper.makeToast("密码不允许为空");
            return;
        }

        submitTask(new ApiTask<IResult<BuyerUser>>(getILoading()) {
            @Override
            public IResult<BuyerUser> onBackGround() throws Exception {
                return mUserManager.login(name, password, type);
            }

            @Override
            public void onSuccess(IResult<IResult<BuyerUser>> result) {
                if (result.data() != null) {
                    BuyerUser user = (BuyerUser) result.data();
                    doSuccessLogin(user);
                }
            }
        });
    }

    public void doSuccessLogin(BuyerUser user) {

    }
}
