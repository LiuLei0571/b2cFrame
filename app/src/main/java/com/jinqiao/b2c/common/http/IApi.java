package com.jinqiao.b2c.common.http;


import com.jinqiao.b2c.compent.http.IHost;

import java.lang.reflect.Type;

/**
 * 用途：
 * Created by milk on 17/4/21.
 * 邮箱：649444395@qq.com
 */

public interface IApi {
    String getUrl();

    RequestMethod getMethod();

    Type getResultType();

    ContentType getContentType();

    ParamType getParamType();

    String getDefaultParams();

    IHost getHost();

    /**
     * 是否需要缓存
     *
     * @return
     */
    boolean enableCache();
}
