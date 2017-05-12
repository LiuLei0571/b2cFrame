package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.paramBuilder.NewBuilder;
import com.jinqiao.b2c.compent.http.paramBuilder.NormalBuilder;

/**
 * 用途：
 * Created by milk on 17/4/24.
 * 邮箱：649444395@qq.com
 */

public interface ParamBuilders {
    NewBuilder news = new NewBuilder();
    NormalBuilder normal = new NormalBuilder();
}
