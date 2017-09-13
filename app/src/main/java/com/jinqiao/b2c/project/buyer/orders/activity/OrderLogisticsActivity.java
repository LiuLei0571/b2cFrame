package com.jinqiao.b2c.project.buyer.orders.activity;

import android.os.Bundle;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderLogisticsActivity extends TempleActivity {
    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_order_logistcis;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle("物流详情");
    }
}
