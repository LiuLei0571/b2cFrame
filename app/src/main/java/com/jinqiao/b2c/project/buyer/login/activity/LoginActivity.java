package com.jinqiao.b2c.project.buyer.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.StatusBarHelper;
import com.jinqiao.b2c.common.statusBar.StatusBarState;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.ui.popup.PopupWindowsUtil;
import com.jinqiao.b2c.compent.ui.widget.CustomButton;
import com.jinqiao.b2c.compent.ui.widget.EditTextWithDelete;
import com.jinqiao.b2c.project.buyer.login.presenter.LoginPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/2.
 * 邮箱：liulei2@aixuedai.com
 */


public class LoginActivity extends TempleActivity {
    public static final int ROLEBUYER = 0;
    public static final int ROLESELLER = 1;
    public static final int ROLEXPRESS = 2;

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
    @Bind(R.id.lyt_other_login)
    LinearLayout mLytOther;

    List<String> mListRole = new ArrayList<>();
    String roleSelect;
    @Inject
    LoginPresenter mPresenter;
    private int mPostion;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_login;
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mListRole.add("买家");
        mListRole.add("卖家");
        mListRole.add("物流");

    }

    @Override
    public void intStatusBar() {
        StatusBarHelper.initStatusBar(this, StatusBarState.TOOLBAR_VIEW, R.id.login_b2c_tool_bar);

    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @OnClick({R.id.iv_close, R.id.btn_login, R.id.tv_new_buyer, R.id.tv_fgt_psw, R.id.tv_express_forget, R.id.tv_user_select, R.id.face_book_login})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.login(mEtUsername.getText().toString(), mEtPassword.getText().toString(), Configs.USER.TYPE.BUYER);
                break;
            case R.id.tv_new_buyer:
                intent = new Intent(this, RegisterActivity.class);
                if (mPostion == 0) {
                    intent.putExtra("roleType", ROLEBUYER);
                } else {
                    intent.putExtra("roleType", ROLESELLER);
                }
                break;
            case R.id.tv_fgt_psw:
                intent = new Intent(this, ForgetPasswordActivity.class);
                if (mPostion == 0) {
                    intent.putExtra("roleType", ROLEBUYER);
                } else {
                    intent.putExtra("roleType", ROLESELLER);
                }
                break;
            case R.id.tv_express_forget:
                intent = new Intent(this, ForgetPasswordActivity.class);
                intent.putExtra("roleType", ROLEXPRESS);
                break;
            case R.id.tv_user_select:
                PopupWindowsUtil.showListPopupWindows(this, mListRole, null, new PopupWindowsUtil.CallBack() {
                    @Override
                    public void onClick(int position, Object... objects) {
                        mPostion = position;
                        roleSelect = mListRole.get(position);
                        mTvUserSelect.setText(roleSelect);
                        switch (position) {
                            case 0:
                                mLytOther.setVisibility(View.VISIBLE);
                                mRlyExpress.setVisibility(View.GONE);
                                mRlyBuyer.setVisibility(View.VISIBLE);
                                break;
                            case 1:
                                mRlyExpress.setVisibility(View.GONE);
                                mLytOther.setVisibility(View.GONE);
                                mRlyBuyer.setVisibility(View.VISIBLE);
                                break;
                            case 2:
                                mLytOther.setVisibility(View.GONE);
                                mRlyExpress.setVisibility(View.VISIBLE);
                                mRlyBuyer.setVisibility(View.GONE);
                                break;
                        }

                    }
                }, mTvUserSelect);
                break;
            case R.id.face_book_login:
                break;
            case R.id.iv_close:
                finish();
                break;
        }
        if (intent != null) {
            startActivityForResult(intent, mPostion);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
