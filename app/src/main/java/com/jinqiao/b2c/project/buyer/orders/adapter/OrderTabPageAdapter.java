package com.jinqiao.b2c.project.buyer.orders.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;
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

    public View getTabItemView(int position, int selectedPosition, String tabItem) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_point, null);
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (position == selectedPosition) {
            if (!TextUtils.isEmpty(tabItem)) {
                textView.setText(tabItem);
            }
            textView.setTextColor(UIHelper.getColor("#21704F"));
        } else {
            if (!TextUtils.isEmpty(tabItem)) {
                textView.setText(tabItem);
            }
            textView.setTextColor(UIHelper.getColor("#333333"));
        }
        return view;
    }

    public void refreshView(View customView, int position, int selectedPosition, String tabItem) {
        if (customView == null)
            return;
        TextView textView = (TextView) customView.findViewById(R.id.title);
        if (position == selectedPosition) {
            if (!TextUtils.isEmpty(tabItem)) {
                textView.setText(tabItem);
            }
            textView.setTextColor(UIHelper.getColor("#21704F"));
        } else {
            if (!TextUtils.isEmpty(tabItem)) {
                textView.setText(tabItem);
            }
            textView.setTextColor(UIHelper.getColor("#333333"));
//            ImgHelper.displayImage(target, TabItem.getImage());
        }
    }
}
