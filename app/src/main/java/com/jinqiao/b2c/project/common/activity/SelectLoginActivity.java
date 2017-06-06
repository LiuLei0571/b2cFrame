package com.jinqiao.b2c.project.common.activity;

import android.os.Bundle;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class SelectLoginActivity extends TempleActivity {
    @Override
    protected int getRootViewId() {
        return R.layout.activity_common_select_login;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        setTitle(mTranslatesString.getCommon_selectjuese());

        findViewById(R.id.btn_buyer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
