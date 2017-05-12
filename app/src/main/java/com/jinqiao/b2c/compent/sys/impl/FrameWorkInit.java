package com.jinqiao.b2c.compent.sys.impl;

import android.content.Context;

import com.jinqiao.b2c.common.helper.ContextHelper;
import com.jinqiao.b2c.compent.cdi.CDI;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.sys.IAppinits;

import icepick.Icepick;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public class FrameWorkInit implements IAppinits {
    @Override
    public void init(Context appContext) {
        Icepick.setDebug(Configs.LOG_D);
        ContextHelper.setContext(appContext);
        CDI.init(appContext);
    }
}
