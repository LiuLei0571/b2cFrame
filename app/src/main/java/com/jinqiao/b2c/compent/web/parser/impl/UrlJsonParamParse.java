package com.jinqiao.b2c.compent.web.parser.impl;

import android.text.TextUtils;
import android.util.Log;

import com.jinqiao.b2c.common.helper.JsonHelper;
import com.jinqiao.b2c.common.utils.lang.Strings;
import com.jinqiao.b2c.compent.web.parser.IParamParser;

import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * Created by milk on 17/1/18.
 * 邮箱：649444395@qq.com
 */

public class UrlJsonParamParse implements IParamParser {
    private static UrlJsonParamParse instacne;

    public UrlJsonParamParse() {
    }

    public static UrlJsonParamParse getInstacne() {
        if (instacne != null) {
            instacne = new UrlJsonParamParse();
        }
        return instacne;
    }

    @Override
    public <T> T getParam(Type type, String paramStr) {
        if (TextUtils.isEmpty(paramStr)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        String[] pairArr = paramStr.split(Strings.AND);
        if (pairArr != null) {
            String key = Strings.EMPTY;
            String value = Strings.EMPTY;
            for (String pair : pairArr) {
                String[] kvs = pair.split(Strings.EQUAL);
                if (kvs.length > 2) {
                    key = kvs[0];
                    value = kvs[1];
                    try {
                        value = URLDecoder.decode(value, "UTF-8");
                    } catch (Exception e) {
                        Log.d("h5", "getParam: " + e);

                    }
                    params.put(key, value);
                }
            }
        }
        String result = JsonHelper.toJSONString(params);
        return JsonHelper.fromJson(result, type);    }
}
