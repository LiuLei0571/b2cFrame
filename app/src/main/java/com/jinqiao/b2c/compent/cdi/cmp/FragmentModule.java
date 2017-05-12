package com.jinqiao.b2c.compent.cdi.cmp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.jinqiao.b2c.common.task.IGroup;
import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.base.IFragment;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.cdi.annotation.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@Module
public class FragmentModule {
    private IFragment mIFragment;

    public FragmentModule(IFragment IFragment) {
        mIFragment = IFragment;
    }

    @Provides
    @FragmentScope
    Fragment provideFragment() {
        return (Fragment) mIFragment;
    }

    @Provides
    @FragmentScope
    BaseActivity provideBaseActivity() {
        return mIFragment.getBaseActivity();
    }

    @Provides
    @FragmentScope
    Context provideContext() {
        return mIFragment.getContext();
    }

    @Provides
    @FragmentScope
    Activity provideActivity() {
        return mIFragment.getActivity();
    }

    @Provides
    @FragmentScope
    IGroup provideGroup() {
        final String groupName = mIFragment.groupName();
        return new IGroup() {
            @Override
            public String groupName() {
                return groupName;
            }
        };
    }

    @Provides
    @FragmentScope
    IView provideIView() {
        return mIFragment;
    }
}
