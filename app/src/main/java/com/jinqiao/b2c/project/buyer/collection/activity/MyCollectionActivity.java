package com.jinqiao.b2c.project.buyer.collection.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.ui.widget.Tab;
import com.jinqiao.b2c.project.buyer.collection.presenter.MyCollectionPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class MyCollectionActivity extends TempleActivity {
    @Bind(android.R.id.tabcontent)
    FrameLayout mTabcontent;
    @Bind(R.id.tab_shop)
    Tab mTabShop;
    @Bind(R.id.tab_good)
    Tab mTabGood;
    @Inject
    MyCollectionPresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_my_collection;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }


    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle("我的收藏");
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
