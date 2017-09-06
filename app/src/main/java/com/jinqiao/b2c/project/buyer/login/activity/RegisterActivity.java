package com.jinqiao.b2c.project.buyer.login.activity;

import android.os.Bundle;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class RegisterActivity extends TempleActivity {
    private int type;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_register;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
    }

    @Override
    protected void initParams(Bundle extras) {
        super.initParams(extras);
        type = extras.getInt("roleType", 0);
        if (type == 0) {
            setTitle("买家注册");
        } else {
            setTitle("卖家注册");
        }
    }
}
