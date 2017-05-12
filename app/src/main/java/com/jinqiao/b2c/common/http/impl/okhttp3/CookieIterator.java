package com.jinqiao.b2c.common.http.impl.okhttp3;

/**
 * Created by milk on 2016/12/22.
 */

public interface CookieIterator {
    void iterator(String urlHost, String cookieStr);
}
