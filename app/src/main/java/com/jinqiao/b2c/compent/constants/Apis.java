package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.common.manager.bean.TranslatesResult;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public interface Apis {
    Api home = Api.Post("banner/homePage.htm", Types.home).setLogin(false);
    Api translates=Api.Post("common/listTranslates.htm",TranslatesResult.class);
}
