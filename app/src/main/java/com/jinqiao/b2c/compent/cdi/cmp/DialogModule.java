package com.jinqiao.b2c.compent.cdi.cmp;

import android.app.Activity;
import android.content.Context;

import com.jinqiao.b2c.common.task.IGroup;
import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.base.BaseDialog;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.cdi.annotation.DialogScope;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@Module
public class DialogModule {
    private BaseDialog mDialog;

    public DialogModule(BaseDialog dialog) {
        mDialog = dialog;
    }

    @Provides
    @DialogScope
    Context provideContext() {
        return mDialog.getContext();
    }

    @Provides
    @DialogScope
    Activity provideActivity() {
        return mDialog.getActivity();
    }

    @Provides
    @DialogScope
    BaseActivity provideBaseActivity() {
        return mDialog.getBaseActivity();
    }

    @Provides
    @DialogScope
    IGroup provideGroup() {
        final String groupName = mDialog.groupName();
        return new IGroup() {
            @Override
            public String groupName() {
                return groupName;
            }
        };
    }

    @Provides
    @DialogScope
    IView provideIView() {
        return mDialog;
    }
}
