package com.jinqiao.b2c.project.buyer.home.fragment;

import com.jinqiao.b2c.compent.base.BaseAdapter;
import com.jinqiao.b2c.compent.base.TempleRefreshFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.project.buyer.home.adapter.ShopCollectionAdapter;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteShop;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteShopDetail;
import com.jinqiao.b2c.project.buyer.home.presenter.CollectionPresenter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/9.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerShopCollectionFragment extends TempleRefreshFragment<FavoriteShop> {
    @Inject
    CollectionPresenter mPresenter;

    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected void successResult(FavoriteShop data) {
        if (data.getFavoriteShopList() != null) {
            mBaseAdapter.addAll(data.getFavoriteShopList());
        }
        hasNext = data.isHasNext();
    }

    @Override
    public BaseAdapter getAdapter() {
        return mBaseAdapter = new ShopCollectionAdapter(getContext()) {

            @Override
            public void onClicks(FavoriteShopDetail mData) {
                mPresenter.getDeletCollectShop(mData.getTargetId());
            }
        };
    }

    @Override
    public Api getApi() {
        return Apis.buyerShopCollection;
    }

    @Override
    public Map<String, Object> getParams(int page) {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", page + "");

        return params;
    }
}
