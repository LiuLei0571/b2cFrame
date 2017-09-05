package com.jinqiao.b2c.project.buyer.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.base.LoginControl;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.helper.LoginHelper;
import com.jinqiao.b2c.compent.helper.UserHelper;
import com.jinqiao.b2c.compent.ui.widget.SettingLayout;
import com.jinqiao.b2c.project.buyer.collection.MyCollectionActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeMineFragment extends BaseFragment implements LoginHelper.LoginListener {


    Toolbar mToolbar;
    @Bind(R.id.toolbar_right)
    ImageView mToolbarRight;
    @Bind(R.id.iv_head)
    ImageView mIvHead;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.waite_send)
    LinearLayout mWaiteSend;
    @Bind(R.id.lyt_waite_receipt)
    LinearLayout mLytWaiteReceipt;
    @Bind(R.id.lyt_)
    LinearLayout mLyt;
    @Bind(R.id.lyt_refuse)
    LinearLayout mLytRefuse;
    @Bind(R.id.lyt_return)
    LinearLayout mLytReturn;
    @Bind(R.id.lyt_buyer_account_security)
    SettingLayout mLytBuyerAccountSecurity;
    @Bind(R.id.lyt_buyer_account_address)
    SettingLayout mLytBuyerAccountAddress;
    @Bind(R.id.lyt_buyer_account_coupon)
    SettingLayout mLytBuyerAccountCoupon;
    @Bind(R.id.lyt_buyer_account_pay)
    SettingLayout mLytBuyerAccountPay;
    @Bind(R.id.lyt_buyer_account_collection)
    SettingLayout mLytBuyerAccountCollection;

    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_mine;
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mToolbar = (Toolbar) rootView.findViewById(R.id.mine_b2c_tool_bar);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.toolbar_right, R.id.tv_name, R.id.waite_send, R.id.lyt_waite_receipt, R.id.lyt_, R.id.lyt_refuse, R.id.lyt_return, R.id.lyt_buyer_account_security, R.id.lyt_buyer_account_address, R.id.lyt_buyer_account_coupon, R.id.lyt_buyer_account_pay, R.id.lyt_buyer_account_collection})
    public void onViewClicked(View view) {
        doClick(view.getId());

    }

    private void doClick(int view) {
        Intent intent = null;
        if (!UserHelper.isUserLogin()) {
            LoginHelper.startLogin(this, null, view, null);
        } else {
            switch (view) {
                case R.id.toolbar_right:
                    break;
                case R.id.tv_name:
                    break;
                case R.id.waite_send:
                    break;
                case R.id.lyt_waite_receipt:
                    break;
                case R.id.lyt_:
                    break;
                case R.id.lyt_refuse:
                    break;
                case R.id.lyt_return:
                    break;
                case R.id.lyt_buyer_account_security:
                    break;
                case R.id.lyt_buyer_account_address:
                    break;
                case R.id.lyt_buyer_account_coupon:
                    break;
                case R.id.lyt_buyer_account_pay:
                    break;
                case R.id.lyt_buyer_account_collection:
                    intent = new Intent(getBaseActivity(), MyCollectionActivity.class);
                    break;
            }
            getBaseActivity().startActivity(intent);
        }
    }

    @Override
    public void onLoginSuccess(LoginControl user, int actionId, Object passThough) {
        doClick(actionId);
    }

    @Override
    public void onLoginFail(int actionId, Object passThough) {

    }
}
