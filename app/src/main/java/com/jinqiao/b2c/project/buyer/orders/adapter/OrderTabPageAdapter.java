package com.jinqiao.b2c.project.buyer.orders.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jinqiao.b2c.project.buyer.orders.fragment.OrderTempleRefreshFragment;

import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderTabPageAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<String> mFragmengString;
    private List<OrderTempleRefreshFragment> mFragmentsList;

    public OrderTabPageAdapter(FragmentManager fm, Context context, List<String> fragmengString, List<OrderTempleRefreshFragment> fragmentsList) {
        super(fm);
        mContext = context;
        mFragmengString = fragmengString;
        mFragmentsList = fragmentsList;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmengString.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmengString.get(position);
    }

}
