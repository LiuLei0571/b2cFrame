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
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.helper.LoginHelper;
import com.jinqiao.b2c.compent.helper.UserHelper;
import com.jinqiao.b2c.compent.ui.widget.SettingLayout;
import com.jinqiao.b2c.project.buyer.collection.activity.MyCollectionActivity;
import com.jinqiao.b2c.project.buyer.home.presenter.HomeMinePresenter;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderActivity;
import com.jinqiao.b2c.project.buyer.user.UserInfo;

import javax.inject.Inject;

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
    @Bind(R.id.lyt_user)
    LinearLayout mLytUser;
    @Bind(R.id.iv_head)
    ImageView mIvHead;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_left_msg)
    TextView mTvAllOrder;
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

    @Inject
    HomeMinePresenter mHomePresenter;

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
        mHomePresenter.getUserInfo();
    }

    @Override
    public void onResume() {
        super.onResume();
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).init();
    }

    public void initData(UserInfo mData) {
        mTvName.setText(mData.getLoginName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_left_msg, R.id.lyt_user, R.id.toolbar_right, R.id.tv_name, R.id.waite_send, R.id.lyt_waite_receipt, R.id.lyt_, R.id.lyt_refuse, R.id.lyt_return, R.id.lyt_buyer_account_security, R.id.lyt_buyer_account_address, R.id.lyt_buyer_account_coupon, R.id.lyt_buyer_account_pay, R.id.lyt_buyer_account_collection})
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
                case R.id.tv_left_msg:
                    goOrderType(1);
                    break;
                case R.id.lyt_user:
                    break;
                case R.id.waite_send:
                    goOrderType(2);
                    break;
                case R.id.lyt_waite_receipt:
                    goOrderType(3);
                    break;
                case R.id.lyt_:
                    goOrderType(4);
                    break;
                case R.id.lyt_refuse:
                    goOrderType(5);
                    break;
                case R.id.lyt_return:
                    goOrderType(6);
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
    public void onLoginSuccess(int actionId, Object passThough) {
        doClick(actionId);
    }

    @Override
    public void onLoginFail(int actionId, Object passThough) {

    }
    private void goOrderType(int type){
        Intent intent=new Intent(getBaseActivity(), OrderActivity.class);
        intent.putExtra("type",type);
        getBaseActivity().startActivity(intent);
    }
}
