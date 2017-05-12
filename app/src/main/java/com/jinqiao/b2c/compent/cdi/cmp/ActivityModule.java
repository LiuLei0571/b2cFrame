package com.jinqiao.b2c.compent.cdi.cmp;

import android.content.Context;

import com.jinqiao.b2c.common.task.IGroup;
import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.cdi.annotation.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@Module
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity baseActivity) {
        activity = baseActivity;
    }

    @Provides
    @ActivityScope
    BaseActivity provideBaseActivity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    IGroup provideGroup() {
        final String groupName = activity.groupName();

        return new IGroup() {
            @Override
            public String groupName() {
                return groupName;
            }
        };
    }

    @Provides
    @ActivityScope
    IView provideIView() {
        return activity;
    }
}
