package com.jinqiao.b2c.compent.base;


import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.common.utils.lang.Maps;
import com.jinqiao.b2c.compent.helper.HttpHelper;
import com.jinqiao.b2c.compent.http.Api;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/4/20.
 * 邮箱：649444395@qq.com
 */

public abstract class BaseManager {
    protected <T> IResult<T> execute(Api api) {
        return HttpHelper.execute(api, Maps.mapNull);
    }

    protected <T> IResult<T> execute(Api api, Object object) {
        return HttpHelper.execute(api, object);
    }

    protected Map<String, Object> getHashMap() {
        return new HashMap<>();
    }
}
