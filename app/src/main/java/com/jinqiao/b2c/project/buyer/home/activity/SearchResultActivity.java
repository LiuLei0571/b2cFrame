package com.jinqiao.b2c.project.buyer.home.activity;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 2017/10/31.
 * 邮箱：liulei2@aixuedai.com
 */


public class SearchResultActivity extends TempleActivity {

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_serach_result;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
