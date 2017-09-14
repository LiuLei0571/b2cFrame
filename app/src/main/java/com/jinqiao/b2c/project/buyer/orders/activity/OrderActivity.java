package com.jinqiao.b2c.project.buyer.orders.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.project.buyer.orders.adapter.OrderTabPageAdapter;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderAllFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderReceivedFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderRejectFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderReturnFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderTempleRefreshFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderWaitReceiptFragment;
import com.jinqiao.b2c.project.buyer.orders.fragment.OrderWaitSendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderActivity extends TempleActivity {
    @Bind(R.id.tab_bar)
    TabLayout mTabBar;
    @Bind(R.id.view_page)
    ViewPager mViewPage;
    private int type;
    private OrderTabPageAdapter mAdapter;
    List<OrderTempleRefreshFragment> mFragments = new ArrayList<>();
    List<String> mPageListString = new ArrayList<>();

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_order;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mFragments.add(new OrderAllFragment());
        mFragments.add(new OrderWaitSendFragment());
        mFragments.add(new OrderWaitReceiptFragment());
        mFragments.add(new OrderReceivedFragment());
        mFragments.add(new OrderRejectFragment());
        mFragments.add(new OrderReturnFragment());
        mPageListString.add("全部");
        mPageListString.add("待发货");
        mPageListString.add("待收货");
        mPageListString.add("已签收");
        mPageListString.add("拒收");
        mPageListString.add("退货");
    }

    @Override
    protected void initParams(Bundle extras) {
        super.initParams(extras);
        type = extras.getInt("type", 1);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle("订单");
        mAdapter = new OrderTabPageAdapter(getSupportsFragmentManager(), this, mPageListString, mFragments);
        mViewPage.setAdapter(mAdapter);
        mTabBar.setTabMode(TabLayout.MODE_FIXED);
        mTabBar.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabBar.setupWithViewPager(mViewPage);
        refreshTabItem(type);
        mTabBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                refreshTabItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 刷新TabLayout的customView
     */
    private void refreshTabItem(int selectedPosition) {
        for (int i = 0; i < mPageListString.size(); i++) {
            TabLayout.Tab tab = mTabBar.getTabAt(i);
            if (tab != null) {
                View customView = tab.getCustomView();
                if (customView == null) {
                    tab.setCustomView(mAdapter.getTabItemView(i, selectedPosition, mPageListString.get(i)));
                } else {
                    mAdapter.refreshView(customView, i, selectedPosition, mPageListString.get(i));
                }
            }
        }
    }

}

