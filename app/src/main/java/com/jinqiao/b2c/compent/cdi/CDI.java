package com.jinqiao.b2c.compent.cdi;

import android.content.Context;

import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.base.BaseDialog;
import com.jinqiao.b2c.compent.base.IFragment;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityModule;
import com.jinqiao.b2c.compent.cdi.cmp.AppComponent;
import com.jinqiao.b2c.compent.cdi.cmp.AppModule;
import com.jinqiao.b2c.compent.cdi.cmp.DaggerAppComponent;
import com.jinqiao.b2c.compent.cdi.cmp.DialogComponent;
import com.jinqiao.b2c.compent.cdi.cmp.DialogModule;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentModule;
import com.jinqiao.b2c.compent.cdi.cmp.ManagerModule;


/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public class CDI {
    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static void init(Context context) {
        AppModule appModule = new AppModule(context);
        ManagerModule managerModule = new ManagerModule();
        sAppComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .managerModule(managerModule)
                .build();
    }

    public static ActivityComponent createActivityComponent(BaseActivity activity) {
        ActivityComponent activityComponent = sAppComponent.plus(new ActivityModule(activity));
        return activityComponent;
    }

    public static FragmentComponent createFragmentComponent(IFragment iFragment) {
        FragmentComponent fragmentComponent = sAppComponent.plus(new FragmentModule(iFragment));
        return fragmentComponent;
    }

    public static DialogComponent createDialogComponent(BaseDialog dialog) {
        DialogComponent dialogComponent = sAppComponent.plus(new DialogModule(dialog));
        return dialogComponent;
    }
}
