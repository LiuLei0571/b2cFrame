package com.jinqiao.b2c.compent.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jinqiao.b2c.compent.event.EmptyEvent;
import com.jinqiao.b2c.compent.helper.EventHelper;

import java.util.List;

import icepick.Icepick;


/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public class BasePresenter<T extends IView> extends BaseViewPresenter<T> {
    public BasePresenter(IView iView) {
        super(iView);
        iView.savePresenter(this);
    }

    protected final void doCreate_(Bundle saveInstanceState, Bundle params) {
        Icepick.restoreInstanceState(this, saveInstanceState);
        if (params == null) {
            params = new Bundle();
        }
        initParams(params);
        EventHelper.register(this);
        onCreate(saveInstanceState);
        if (mIGroup == null) {
            mIGroup = mBaseActivity;
        }
    }

    protected final void doDestroy() {
        EventHelper.unRegister(this);
        onDestroy();
    }

    protected final void doSaveInstanceState_(Bundle outSate) {
        Icepick.saveInstanceState(this, outSate);
    }

    protected void initParams(Bundle params) {
    }

    protected void onCreate(Bundle saveInstanceState) {
    }

    protected void onNewIntent(Intent intent) {

    }

    protected void onResume() {

    }

    protected void onPause() {

    }

    protected void onDestroy() {
    }

    public void onEvent(EmptyEvent event) {
    }

    protected void startActivityForResult(Intent intent, int requestCode) {
        if (mView != null) {
            if (mView instanceof IFragment) {
                IFragment fragment = (IFragment) mView;
                fragment.startActivityForResult(intent, requestCode);
            } else {
                mBaseActivity.startActivityForResult(intent, requestCode);
            }
        }
    }

    public void onSaveInstanceState(Bundle outSate) {

    }

    public void onActivityForResult(int requestCode, int resultCode, Intent data) {
    }

    protected FragmentManager getSupportsFragmentManager() {
        return mBaseActivity.getSupportFragmentManager();
    }

    public synchronized BaseFragment setCurrentTab(int position, HomePage[] pages) {
        BaseFragment baseFragment = null;

        if (position >= 0 && position < pages.length) {
            HomePage page = pages[position];
            Class<? extends BaseFragment> cls = page.fragmentCls;
            List<Fragment> fragments = getBaseActivity().getSupportFragmentManager().getFragments();
            FragmentTransaction trans = getBaseActivity().getSupportFragmentManager().beginTransaction();
            if (fragments != null && fragments.size() > 0) {
                for (Fragment fragment : fragments) {
                    if (fragment == null) {
                        continue;
                    }
                    if (cls.isInstance(fragment)) {
                        baseFragment = (BaseFragment) fragment;

                        trans.attach(baseFragment);
                    } else {
                        trans.detach(fragment);
                    }
                }
            }
            if (baseFragment == null) {

                try {
                    baseFragment = cls.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (baseFragment != null) {
                    trans.add(android.R.id.tabcontent, baseFragment, page.tag);
                }
            }
            trans.commitAllowingStateLoss();
        }
        return baseFragment;
    }

    public static class HomePage {
        public String tag;
        public Class<? extends BaseFragment> fragmentCls;

        public HomePage(String tag, Class<? extends BaseFragment> fragmentCls) {
            this.tag = tag;
            this.fragmentCls = fragmentCls;
        }
    }

    public synchronized BaseFragment setCurrentChildTab(int position, HomePage[] pages, BaseFragment fatherFragment) {
        BaseFragment baseFragment = null;

        if (position >= 0 && position < pages.length) {
            HomePage page = pages[position];
            Class<? extends BaseFragment> cls = page.fragmentCls;
            List<Fragment> fragments = fatherFragment.getChildFragmentManager().getFragments();
            FragmentTransaction trans = fatherFragment.getChildFragmentManager().beginTransaction();
            if (fragments != null && fragments.size() > 0) {
                for (Fragment fragment : fragments) {
                    if (fragment == null) {
                        continue;
                    }
                    if (cls.isInstance(fragment)) {
                        baseFragment = (BaseFragment) fragment;

                        trans.attach(baseFragment);
                    } else {
                        trans.detach(fragment);
                    }
                }
            }
            if (baseFragment == null) {

                try {
                    baseFragment = cls.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (baseFragment != null) {
                    trans.add(android.R.id.tabcontent, baseFragment, page.tag);
                }
            }
            trans.commitAllowingStateLoss();
        }
        return baseFragment;
    }
}
