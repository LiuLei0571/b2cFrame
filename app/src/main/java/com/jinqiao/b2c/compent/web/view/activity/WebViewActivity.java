package com.jinqiao.b2c.compent.web.view.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.web.presenter.WebViewActivityPresenter;
import com.jinqiao.b2c.compent.web.view.fragment.WebViewFragment;

import javax.inject.Inject;

public class WebViewActivity extends BaseActivity implements WebViewFragment.OnReceivedTitleListener {
    public String url;
    private ImageView mImageView;

    @Inject
    WebViewActivityPresenter presenter;
    @Override
    protected int getRootViewId() {
        return R.layout.activity_web;
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
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        presenter.backPress();
    }

    private void close() {
        finish();
    }

    @Override
    public void setTitle(String title) {

    }
}
