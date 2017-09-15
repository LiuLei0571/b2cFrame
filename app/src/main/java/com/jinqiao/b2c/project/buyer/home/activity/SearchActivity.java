package com.jinqiao.b2c.project.buyer.home.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.StatusBarHelper;
import com.jinqiao.b2c.common.statusBar.StatusBarState;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/12.
 * 邮箱：liulei2@aixuedai.com
 */


public class SearchActivity extends TempleActivity {
    @Bind(R.id.tv_category)
    TextView mTvCategory;
    @Bind(R.id.tv_close)
    TextView mTvClose;
    @Bind(R.id.lyt_top)
    RelativeLayout mLytTop;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_serach_home;
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
    public void intStatusBar() {
        StatusBarHelper.initStatusBar(this, StatusBarState.TOOLBAR_VIEW, R.id.lyt_top);

    }
}
