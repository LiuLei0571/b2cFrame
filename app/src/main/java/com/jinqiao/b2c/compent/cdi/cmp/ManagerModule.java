package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.project.buyer.home.manager.HomeManager;
import com.jinqiao.b2c.project.buyer.login.module.manager.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@Module
public class ManagerModule {
    @Provides
    @Singleton
    protected HomeManager provideManager() {
        return new HomeManager();
    }
    @Provides
    @Singleton
    protected UserManager provideUserManager(){
        return new UserManager();
    }
}
