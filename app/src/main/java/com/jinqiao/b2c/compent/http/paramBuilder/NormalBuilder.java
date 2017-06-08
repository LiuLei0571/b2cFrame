package com.jinqiao.b2c.compent.http.paramBuilder;


import com.jinqiao.b2c.compent.http.IParamBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/4/24.
 * 邮箱：649444395@qq.com
 */

public class NormalBuilder implements IParamBuilder {
    @Override
    public Map<String, Object> buildParams(Map<String, Object> authHeader, Object params) {
        Map<String, Object> allParams = new LinkedHashMap<>();
        if (allParams != null) {
            allParams.putAll(authHeader);
        }
        if (params != null) {
            allParams.putAll(toMap(params));
        }

        return allParams;
    }

    private Map<String, Object> toMap(Object object) {
        Map<String, Object> result =null;
        try {
            if (object instanceof Map) {
                result = (Map<String, Object>) object;
            }
        } catch (Exception e) {

        }
        return result;
    }
}
