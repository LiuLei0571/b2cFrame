package com.jinqiao.b2c.project.buyer.home.fragment;

import com.jinqiao.b2c.compent.base.BaseAdapter;
import com.jinqiao.b2c.compent.base.TempleRefreshFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.home.adapter.ShopCollectionAdapter;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteGoods;

import java.util.Map;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/9.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerGoodCollectionFragment extends TempleRefreshFragment<FavoriteGoods> {


    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected void successResult(FavoriteGoods data) {
        if (data.getFavoriteSampleList() != null) {
            mBaseAdapter.addAll(data.getFavoriteSampleList());

        }
        hasNext=data.isHasNext();
    }

    @Override
    public BaseAdapter getAdapter() {
        return mBaseAdapter=new ShopCollectionAdapter(getContext()) {
            @Override
            public void onClick(int position) {

            }
        };
    }

    @Override
    public Api getApi() {
        return Apis.buyerGoodCollection;
    }

    @Override
    public Map<String, Object> getParams() {
        return null;
    }
}
