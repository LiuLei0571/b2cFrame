package com.jinqiao.b2c.project.express.home.activity;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class ExpressHomeActivity extends TempleActivity {
    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_main;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
