package com.jinqiao.b2c.common.http;

import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/4/21.
 * 邮箱：649444395@qq.com
 */

public interface IRequest {
    Map<String, Object> getParams();

    IApi getAPi();

    String getDefaultParams();
    Map<String, String> getHeaders();

    boolean enableCache();
}
