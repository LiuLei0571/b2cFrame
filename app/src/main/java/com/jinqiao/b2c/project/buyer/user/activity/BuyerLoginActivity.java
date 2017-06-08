package com.jinqiao.b2c.project.buyer.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.ui.SimpleTextWatcher;
import com.jinqiao.b2c.compent.ui.widget.CustomButton;
import com.jinqiao.b2c.compent.ui.widget.EditTextWithDelete;
import com.jinqiao.b2c.project.buyer.user.presenter.BuyerLoginPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.jinqiao.b2c.R.id.btn_login;
import static com.jinqiao.b2c.R.id.et_password;
import static com.jinqiao.b2c.R.id.et_username;
import static com.jinqiao.b2c.R.id.tv_register;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerLoginActivity extends TempleActivity {


    @Bind(R.id.iv_username)
    ImageView mIvUsername;
    @Bind(et_username)
    EditTextWithDelete mEtUsername;
    @Bind(R.id.iv_password)
    ImageView mIvPassword;
    @Bind(et_password)
    EditTextWithDelete mEtPassword;
    @Bind(R.id.iv_eye)
    ImageView mIvEye;
    @Bind(btn_login)
    CustomButton mBtnLogin;
    @Bind(R.id.face_book_login)
    ImageView mFaceBookLogin;
    @Bind(R.id.tv_fgt_psw)
    TextView mTvFgtPsw;
    @Bind(tv_register)
    TextView mTvRegister;
    @Inject
    BuyerLoginPresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_login;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        mBtnLogin.setEnabled(false);
        mEtUsername.setHint(mTranslatesString.getNotice_inputusername());
        mEtPassword.setHint(mTranslatesString.getValidate_inputpassword());
        mBtnLogin.setText(mTranslatesString.getCommon_login());
        mTvRegister.setText(mTranslatesString.getCommon_registersongjuan());
        mTvFgtPsw.setText(mTranslatesString.getCommon_forgetpassword());
        mEtPassword.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                mBtnLogin.setEnabled(true);

            }
        });
    }

    @OnClick({R.id.iv_eye, btn_login, R.id.face_book_login, R.id.tv_fgt_psw, tv_register})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_eye:
                break;
            case btn_login:
                doLogin();
                break;
            case R.id.face_book_login:
                break;
            case R.id.tv_register:
                intent = new Intent(this, RegisterActivity.class);
                break;
            case R.id.tv_fgt_psw:
                intent = new Intent(this, ForgetPswActivity.class);
                intent.putExtra(Configs.USER_TYPE.TYPE, Configs.USER_TYPE.BUYER);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void doLogin() {
        mPresenter.login(mEtUsername.getText().toString().trim(), mEtPassword.getText().toString().trim(), "0");
    }
}
