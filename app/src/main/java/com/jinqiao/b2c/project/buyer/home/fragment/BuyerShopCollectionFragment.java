package com.jinqiao.b2c.project.buyer.home.fragment;

import com.jinqiao.b2c.compent.base.BaseAdapter;
import com.jinqiao.b2c.compent.base.TempleRefreshFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteShop;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/9.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerShopCollectionFragment extends TempleRefreshFragment<FavoriteShop>{
    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected void successResult(FavoriteShop data) {

    }

    @Override
    public BaseAdapter getAdapter() {
        return null;
    }

    @Override
    public Api getApi() {
        return Apis.buyerShopCollection;
    }

    @Override
    public Map<String, Object> getParams(int page) {
        Map<String,Object> params=new HashMap<>();
        params.put("pageNum",page+"");

        return params;
    }
}
