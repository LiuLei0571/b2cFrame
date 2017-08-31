package com.jinqiao.b2c.project.buyer.home.fragment;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeCarFragment extends BaseFragment {
    Toolbar mToolbar;
    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_car;
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mToolbar = (Toolbar) rootView.findViewById(R.id.mine_b2c_tool_bar);

    }

    @Override
    public void onResume() {
        super.onResume();
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).statusBarDarkFont(true,0.2f).init();
    }
}
