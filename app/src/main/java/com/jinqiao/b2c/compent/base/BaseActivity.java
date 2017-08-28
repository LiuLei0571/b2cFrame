package com.jinqiao.b2c.compent.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;
import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.cdi.CDI;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.event.EmptyEvent;
import com.jinqiao.b2c.compent.helper.ActivityHelper;
import com.jinqiao.b2c.compent.helper.EventHelper;
import com.jinqiao.b2c.compent.helper.HttpHelper;
import com.jinqiao.b2c.compent.helper.LoadingHelper;

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
        StatusBarUtil.setColor(this,R.color.hand_high);
        bindView(view);
        afterViewBind(savedInstanceState);
        mPresenterConnector.bindPresenter(savedInstanceState, getIntent().getExtras());
        setWindowStatusBarColor(this,R.color.btn_background);
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
    public void startActivity(Intent intent, @Nullable Bundle options) {
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
        if (mPresenterConnector != null) {
            mPresenterConnector.onActivityForResult(requestCode, resultCode, data);
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
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
