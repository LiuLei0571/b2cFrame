package com.jinqiao.b2c.compent.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.StatusBarHelper;
import com.jinqiao.b2c.common.statusBar.StatusBarState;
import com.jinqiao.b2c.compent.cdi.CDI;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.event.EmptyEvent;
import com.jinqiao.b2c.compent.helper.ActivityHelper;
import com.jinqiao.b2c.compent.helper.EventHelper;
import com.jinqiao.b2c.compent.helper.HttpHelper;
import com.jinqiao.b2c.compent.helper.LoadingHelper;
import com.jinqiao.b2c.compent.helper.LoginHelper;
import com.jinqiao.b2c.compent.helper.TaskHelper;
import com.jinqiao.b2c.compent.ui.HeadBar;

import butterknife.ButterKnife;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity implements IView, ILoading {
    protected PresenterConnector mPresenterConnector;
    protected ActivityComponent mActivityComponent;
    private boolean isAnimation = true;
    protected Toolbar mToolBar;
    protected HeadBar mHeadBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelper.create(this);
        EventHelper.register(this);
        if (mPresenterConnector == null) {
            mPresenterConnector = new PresenterConnector();
        }
        if (mActivityComponent == null) {
            mActivityComponent = CDI.createActivityComponent(this);
        }
        doInject(mActivityComponent);
        initParams(getIntent().getExtras());
        View view = getLayoutInflater().inflate(getRootViewId(), null, false);
        beforeViewBind(view);
        setContentView(view);
        bindView(view);
        afterViewBind(savedInstanceState);
        mPresenterConnector.bindPresenter(savedInstanceState, getIntent().getExtras());
        intStatusBar();

    }

    public void intStatusBar() {

        StatusBarHelper.initStatusBar(this, StatusBarState.TOOLBAR_VIEW, R.id.b2c_tool_bar);
    }

    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overrideOpenAnim();
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        overrideOpenAnim();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overrideOpenAnim();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenterConnector != null) {
            mPresenterConnector.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenterConnector != null) {
            mPresenterConnector.onPause();
        }
    }

    public void setAnimation(boolean animation) {
        isAnimation = animation;
    }

    protected FragmentManager getSupportsFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    public void beforeViewBind(View rootView) {
        mToolBar = (Toolbar) rootView.findViewById(R.id.b2c_tool_bar);
        if (mToolBar != null) {
            mHeadBar = new HeadBar(this, mToolBar);

        }
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View findViewId(int id) {
        return null;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParams(intent.getExtras());
    }

    @Override
    protected void onStart() {
        super.onStart();
        overrideOpenAnim();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overrideOpenAnim();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventHelper.unRegister(this);
        ActivityHelper.destroy(this);
        HttpHelper.cancelGroup(groupName());
        if (mPresenterConnector != null) {
            mPresenterConnector.destory();
            mPresenterConnector = null;
        }
        TaskHelper.cancelGroup(groupName());

    }

    @Override
    public void unBindView() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenterConnector != null) {
            mPresenterConnector.onSaveInstanceState_(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LoginHelper.LoginListener listener = null;

        if (this instanceof LoginHelper.LoginListener) {
            listener= (LoginHelper.LoginListener) this;
        }
      boolean isAct=  LoginHelper.doResult(requestCode,resultCode,data,listener);
        if (!isAct) {
            if (mPresenterConnector != null) {
                mPresenterConnector.onActivityForResult(requestCode, resultCode, data);
            }
        }

    }

    @Override
    public void finish() {
        super.finish();
        ActivityHelper.destroy(this);
        overrideCloseAnim();
    }


    @Override
    public void savePresenter(BasePresenter presenter) {
        if (mPresenterConnector != null) {
            mPresenterConnector.savePresenter(presenter);
        }
    }


    @Override
    public void showLoading() {
        LoadingHelper.showLoading(getBaseActivity());
    }

    @Override
    public void showLoading(String content) {
        LoadingHelper.showLoading(getBaseActivity(), content);

    }

    @Override
    public void dismissLoading() {
        LoadingHelper.dismiss();
    }

    public void onEvent(EmptyEvent event) {
    }

    protected abstract int getRootViewId();

    /**
     * 初始化传参
     *
     * @param extras
     */
    protected void initParams(Bundle extras) {
    }

    protected abstract void doInject(ActivityComponent activityComponent);

    @Override
    public String groupName() {
        return getLocalClassName() + this.toString();
    }

    protected void overrideOpenAnim() {
        if (isAnimation) {
            overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    protected void overrideCloseAnim() {
        if (isAnimation) {
            overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }


}
