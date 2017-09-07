package com.jinqiao.b2c.project.buyer.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.constants.Extras;
import com.jinqiao.b2c.compent.helper.ToastHelper;
import com.jinqiao.b2c.compent.helper.UserHelper;
import com.jinqiao.b2c.compent.ui.widget.Tab;
import com.jinqiao.b2c.project.buyer.home.manager.bean.HomeCommand;
import com.jinqiao.b2c.project.buyer.home.presenter.HomePresenter;
import com.jinqiao.b2c.project.buyer.login.activity.LoginActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class BuyerHomeActivity extends TempleActivity {
    @Inject
    HomePresenter presenter;
    @Bind(R.id.tab_home)
    Tab mTabHome;
    @Bind(R.id.tab_classify)
    Tab mTabClassify;
    @Bind(R.id.tab_car)
    Tab mTabCar;
    @Bind(R.id.tab_mine)
    Tab mTabMine;

    HomeCommand homeCommand;
    private long mExitTime;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_main;
    }

    @Override
    protected void initParams(Bundle extras) {
        super.initParams(extras);
        if (extras != null) {
            homeCommand = extras.getParcelable(Extras.HOME.COMMAND);
        }

    }
    @Override
    public void intStatusBar() {
//        StatusBarHelper.initStatusBar(this, StatusBarState.NO_VIEW);

    }
    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        if (saveInstanceState == null) {
            presenter.onTabClick(0);
            mTabHome.setTitle(mTranslatesString.getCommon_home());
            mTabClassify.setTitle(mTranslatesString.getCommon_classify());
            mTabCar.setTitle(mTranslatesString.getCommon_shoppingcart());
            mTabMine.setTitle(mTranslatesString.getCommon_mine());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showTab();
    }

    private void showTab() {
        if (homeCommand != null) {
            presenter.onTabClick(homeCommand.getIndex());
        }
    }

    @OnClick({R.id.tab_home, R.id.tab_classify, R.id.tab_car, R.id.tab_mine})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tab_home:
                presenter.onTabClick(0);
                break;
            case R.id.tab_classify:
                presenter.onTabClick(1);
                break;
            case R.id.tab_car:
                if (UserHelper.isUserLogin()) {
                    presenter.onTabClick(2);
                } else {
                    intent = new Intent(this, LoginActivity.class);
                    intent.putExtra(Extras.HOME.KEY,2);
                }
                break;
            case R.id.tab_mine:
                    presenter.onTabClick(3);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    public void setTabItem(int index) {
        mTabHome.setTabItem(index == 0);
        mTabClassify.setTabItem(index == 1);
        mTabCar.setTabItem(index == 2);
        mTabMine.setTabItem(index == 3);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                ToastHelper.makeToast(mTranslatesString.getCommon_againlogput());
                mExitTime = System.currentTimeMillis();
            } else {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
