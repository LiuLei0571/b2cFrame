package com.jinqiao.b2c.compent.helper;


import com.jinqiao.b2c.common.event.IEvent;
import com.jinqiao.b2c.common.http.HttpScheduler;
import com.jinqiao.b2c.common.http.impl.okhttp3.CookiesManager;
import com.jinqiao.b2c.common.image.ImageDisplayLoader;
import com.jinqiao.b2c.common.parse.IParse;
import com.jinqiao.b2c.common.task.TaskScheduler;
import com.jinqiao.b2c.compent.cdi.CDI;
import com.jinqiao.b2c.compent.ui.AppToast;

import javax.inject.Inject;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public final class CDIHelper {
    @Inject
    public IParse mIParse;
    @Inject
    public IEvent mIEvent;
    @Inject
    public AppToast mAppToast;
    @Inject
    public ImageDisplayLoader mImageDisplayLoader;
    @Inject
    public TaskScheduler mTaskScheduler;
    @Inject
    public CookiesManager mCookiesManager;
    @Inject
    public HttpScheduler mHttpScheduler;
    private static CDIHelper instance = null;

    public CDIHelper() {
        CDI.getAppComponent().plus(this);
    }

    public static synchronized CDIHelper getInstance() {
        if (instance == null) {
            instance = new CDIHelper();
        }
        return instance;
    }
}
