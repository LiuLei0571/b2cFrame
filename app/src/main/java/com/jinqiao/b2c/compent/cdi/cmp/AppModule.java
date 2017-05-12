package com.jinqiao.b2c.compent.cdi.cmp;

import android.content.Context;

import com.jinqiao.b2c.common.event.IEvent;
import com.jinqiao.b2c.common.event.impl.EventBusImpl;
import com.jinqiao.b2c.common.http.HttpResultParse;
import com.jinqiao.b2c.common.http.HttpScheduler;
import com.jinqiao.b2c.common.http.IRequestListener;
import com.jinqiao.b2c.common.http.impl.okhttp3.CookiesManager;
import com.jinqiao.b2c.common.http.impl.okhttp3.ICookieStore;
import com.jinqiao.b2c.common.http.impl.okhttp3.OkHttpSchedule;
import com.jinqiao.b2c.common.image.ImageDisplayLoader;
import com.jinqiao.b2c.common.image.glide.GlideImageLoader;
import com.jinqiao.b2c.common.parse.IParse;
import com.jinqiao.b2c.common.parse.impl.FastJsonParse;
import com.jinqiao.b2c.common.task.TaskScheduler;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.http.DemoHttpResultParse;
import com.jinqiao.b2c.compent.http.OkHttpRequestListener;
import com.jinqiao.b2c.compent.http.PersistentCookieStoreNew;
import com.jinqiao.b2c.compent.ui.AppToast;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */
@Module
public class AppModule {
    private final Context mContext;

//    @Provides
//    @Singleton
//    protected

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    protected IEvent provideEvenBus() {
        return new EventBusImpl(EventBus.getDefault());
    }

    @Provides
    @Singleton
    protected IParse provideFastJson() {
        return new FastJsonParse();
    }

    @Provides
    @Singleton
    protected ImageDisplayLoader provideImageLoader() {
        GlideImageLoader imageLoader = new GlideImageLoader(mContext);
        return imageLoader;
    }

    @Provides
    @Singleton
    protected AppToast provideToast() {
        return new AppToast(mContext);
    }

    @Provides
    @Singleton
    protected ICookieStore provideICookieStore() {
        PersistentCookieStoreNew cookieStoreNew = new PersistentCookieStoreNew();
        return cookieStoreNew;
    }

    @Provides
    @Singleton
    protected CookiesManager provideCookiesManager(CookieManager webCookieManager, ICookieStore cookieStore) {
        return new CookiesManager(cookieStore, webCookieManager);
    }

    @Provides
    @Singleton
    protected CookieManager provideCookieManager() {
        CookieSyncManager.createInstance(mContext);
        CookieManager webCookieManager = CookieManager.getInstance();
        webCookieManager.setAcceptCookie(true);
        return webCookieManager;
    }

    @Provides
    @Singleton
    protected HttpScheduler provideHttpSchuduler3(OkHttpClient okHttpClient, IRequestListener iRequestListener, HttpResultParse resultParse) {
        OkHttpSchedule schedule = new OkHttpSchedule(okHttpClient, resultParse);
        if (!Configs.RELEASE) {
            schedule.setIRequestListener(iRequestListener);
        }
        return schedule;
    }

    @Provides
    @Singleton
    protected IRequestListener provideIRequestListener() {
        return new OkHttpRequestListener();
    }

    @Provides
    @Singleton
    protected HttpResultParse provideHttpResultParse() {
        return new DemoHttpResultParse();

    }

    @Provides
    @Singleton
    protected OkHttpClient provideOkHttpClient3(CookiesManager cookiesManager) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .cookieJar(cookiesManager);
        return builder.build();
    }

    @Provides
    @Singleton
    protected TaskScheduler provideTaskScheduler() {
        TaskScheduler taskScheduler = TaskScheduler.instance();
        return taskScheduler;
    }
}
