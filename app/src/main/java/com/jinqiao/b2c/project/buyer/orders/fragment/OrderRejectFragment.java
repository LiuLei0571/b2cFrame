package com.jinqiao.b2c.project.buyer.orders.fragment;

import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;

/**
 * 用途：拒绝
 * 作者：Created by liulei on 17/9/12.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderRejectFragment extends OrderTempleRefreshFragment  {
    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    public String getType() {
        return "5";
    }
}
