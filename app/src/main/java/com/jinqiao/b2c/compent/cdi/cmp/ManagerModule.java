package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.project.buyer.collection.module.MyCollectionManager;
import com.jinqiao.b2c.project.buyer.login.module.manager.UserManager;
import com.jinqiao.b2c.project.buyer.orders.module.OrderManager;

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
    protected MyCollectionManager provideManager() {
        return new MyCollectionManager();
    }

    @Provides
    @Singleton
    protected UserManager provideUserManager() {
        return new UserManager();
    }

    @Provides
    @Singleton
    protected OrderManager provideOrderManager() {
        return new OrderManager();
    }
}
