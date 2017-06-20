package com.jinqiao.b2c.project.buyer.home.manager;


import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BaseManager;
import com.jinqiao.b2c.compent.constants.Apis;

import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public class HomeManager extends BaseManager {
    public IResult<Object> home() {
        return super.execute(Apis.home);
    }

    public IResult<Object> deleteGoodCollection(int id) {
        Map<String, Object> params = getHashMap();
        params.put("type", "1");
        params.put("targetId", id + "");
        return super.execute(Apis.buyerDeleteGoodFavorite, params);
    }

    public IResult<Object> deleteShopCollection(int id) {
        Map<String, Object> params = getHashMap();
        params.put("type", "2");
        params.put("targetId", id + "");
        return super.execute(Apis.buyerDeleteShopFavorite, params);
    }
}
