package com.jinqiao.b2c.project.buyer.login.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.ui.widget.CustomButton;
import com.jinqiao.b2c.compent.ui.widget.EditTextWithDelete;
import com.jinqiao.b2c.compent.ui.widget.SendSmsSimpleButton;
import com.jinqiao.b2c.project.buyer.login.presenter.AutoCodePresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class ForgetPasswordActivity extends TempleActivity implements AutoCodePresenter.AuthCodeAct {
    @Bind(R.id.et_username)
    EditTextWithDelete mEtUsername;
    @Bind(R.id.et_email)
    EditTextWithDelete mEtEmail;
    @Bind(R.id.btn_send)
    SendSmsSimpleButton mBtnSend;
    @Bind(R.id.et_code)
    EditTextWithDelete mEtCode;
    @Bind(R.id.et_password)
    EditTextWithDelete mEtPassword;
    @Bind(R.id.et_password_new)
    EditTextWithDelete mEtPasswordNew;
    @Bind(R.id.btn_submit)
    CustomButton mBtnSubmit;
    private int type;
    @Inject
    AutoCodePresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_forget_psw;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    protected void initParams(Bundle extras) {
        super.initParams(extras);
        type = extras.getInt("roleType", 0);
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle("忘记密码");
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sedMsg(mEtEmail.getText().toString(), "3");
            }
        });
        mEtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mBtnSend.setEmail(s.toString().trim());
            }
        });
    }

    @OnClick({R.id.btn_send, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                break;
            case R.id.btn_submit:
                break;
        }
    }

    @Override
    public void setText(String text, boolean enabled) {
        mBtnSend.setState(text, enabled);

    }

    @Override
    public void setNeedOutSend(boolean needOutSend) {

    }

    @Override
    public String getPhone() {
        return "";
    }

    @Override
    public String getEmail() {
        return mEtEmail.getText().toString().replace(" ", "");
    }
}
