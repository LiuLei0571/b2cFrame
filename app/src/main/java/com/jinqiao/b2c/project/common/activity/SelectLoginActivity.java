package com.jinqiao.b2c.project.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.constants.Extras;
import com.jinqiao.b2c.compent.ui.widget.CustomButton;
import com.jinqiao.b2c.project.buyer.user.activity.BuyerLoginActivity;
import com.jinqiao.b2c.project.logistics.user.CompanyLoginActivity;
import com.jinqiao.b2c.project.seller.user.SellerLoginActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class SelectLoginActivity extends TempleActivity {

    @Bind(R.id.tv_subject)
    TextView mTvSubject;
    @Bind(R.id.btn_buyer)
    CustomButton mBtnBuyer;
    @Bind(R.id.btn_seller)
    CustomButton mBtnSeller;
    @Bind(R.id.btn_company)
    CustomButton mBtnCompany;
    private int index;

    @Override
    protected void initParams(Bundle extras) {
        super.initParams(extras);
        if (extras != null) {
            index = extras.getInt(Extras.HOME.KEY, 0);

        }
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_common_select_login;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        setTitle(mTranslatesString.getCommon_selectjuese());
        mTvSubject.setText(mTranslatesString.getPoint_identity());
        mBtnSeller.setText(mTranslatesString.getBg_sellertitle());
        mBtnCompany.setText(mTranslatesString.getBg_expresstitle());
        mBtnBuyer.setText(mTranslatesString.getCommon_mymaijia());
    }

    @OnClick({R.id.btn_buyer, R.id.btn_seller, R.id.btn_company})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_buyer:
                intent = new Intent(getActivity(), BuyerLoginActivity.class);
                intent.putExtra(Extras.HOME.KEY, index);
                break;
            case R.id.btn_seller:
                intent = new Intent(getActivity(), SellerLoginActivity.class);
                intent.putExtra(Extras.HOME.KEY, index);
                break;
            case R.id.btn_company:
                intent = new Intent(getActivity(), CompanyLoginActivity.class);
                intent.putExtra(Extras.HOME.KEY, index);
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
