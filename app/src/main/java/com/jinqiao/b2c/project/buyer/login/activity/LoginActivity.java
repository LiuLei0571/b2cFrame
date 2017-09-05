package com.jinqiao.b2c.project.buyer.login.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.ui.widget.CustomButton;
import com.jinqiao.b2c.compent.ui.widget.EditTextWithDelete;
import com.jinqiao.b2c.project.buyer.login.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/2.
 * 邮箱：liulei2@aixuedai.com
 */


public class LoginActivity extends TempleActivity {
    @Bind(R.id.iv_close)
    ImageView mIvClose;
    @Bind(R.id.et_username)
    EditTextWithDelete mEtUsername;
    @Bind(R.id.et_password)
    EditTextWithDelete mEtPassword;
    @Bind(R.id.btn_login)
    CustomButton mBtnLogin;
    @Bind(R.id.tv_new_buyer)
    TextView mTvNewBuyer;
    @Bind(R.id.tv_fgt_psw)
    TextView mTvFgtPsw;
    @Bind(R.id.rly_buyer)
    RelativeLayout mRlyBuyer;
    @Bind(R.id.tv_express_forget)
    TextView mTvExpressForget;
    @Bind(R.id.rly_express)
    RelativeLayout mRlyExpress;
    @Bind(R.id.tv_user_select)
    TextView mTvUserSelect;
    @Bind(R.id.face_book_login)
    ImageView mFaceBookLogin;

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_login;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @OnClick({R.id.iv_close, R.id.btn_login, R.id.tv_new_buyer, R.id.tv_fgt_psw, R.id.tv_express_forget, R.id.tv_user_select, R.id.face_book_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.login(mEtUsername.getText().toString(),mEtPassword.getText().toString(), Configs.USER.TYPE.BUYER);
                break;
            case R.id.tv_new_buyer:
                break;
            case R.id.tv_fgt_psw:
                break;
            case R.id.tv_express_forget:
                break;
            case R.id.tv_user_select:
                break;
            case R.id.face_book_login:
                break;
            case R.id.iv_close:
                finish();
                break;
        }
    }
}
