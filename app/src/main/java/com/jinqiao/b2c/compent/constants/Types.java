package com.jinqiao.b2c.compent.constants;

import com.alibaba.fastjson.TypeReference;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public interface Types {
    Type home = new TypeReference<List<ModelPage>>() {
    }.getType();
}
