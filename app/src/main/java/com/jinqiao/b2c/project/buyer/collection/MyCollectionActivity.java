package com.jinqiao.b2c.project.buyer.collection;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class MyCollectionActivity extends TempleActivity {
    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_my_collection;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
