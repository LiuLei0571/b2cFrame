package com.jinqiao.b2c.compent.web.parser;

import java.lang.reflect.Type;

/**
 * 用途：
 * Created by milk on 17/1/18.
 * 邮箱：649444395@qq.com
 */

public interface IParamParser {
    <T> T getParam(Type type, String paramStr);
}
