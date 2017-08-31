package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.ui.widget.Tab;
import com.jinqiao.b2c.project.buyer.home.presenter.HomeCollectionPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeCollectionFragment extends BaseFragment {
    @Bind(android.R.id.tabcontent)
    FrameLayout mTabcontent;
    @Bind(R.id.tab_shop)
    Tab mTabShop;
    @Bind(R.id.tab_good)
    Tab mTabGood;
    @Inject
    HomeCollectionPresenter mPresenter;
    @Nullable


    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_collection;
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        mPresenter.onTabClick(0);
    }

    @OnClick({R.id.tab_shop, R.id.tab_good})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_shop:
                mPresenter.onTabClick(0);
                break;
            case R.id.tab_good:
                mPresenter.onTabClick(1);
                break;
        }
    }

    public void setTabItem(int index) {
        mTabShop.setTabItem(index == 0);
        mTabGood.setTabItem(index == 1);
    }
}
