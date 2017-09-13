package com.jinqiao.b2c.project.buyer.orders.module;

import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BaseManager;
import com.jinqiao.b2c.compent.constants.Apis;

import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/13.
 * 邮箱：liulei2@aixuedai.com
 */


public class OrderManager extends BaseManager {
    public IResult<MyOrderResult> getOrderList(int mPage,String type) {
        Map<String, Object> parameter = getHashMap();
        parameter.put("startRow", mPage);
        parameter.put("orderStatus", type);
        return execute(Apis.buyerOrder, parameter);
    }
}
