package com.jinqiao.b2c.project.buyer.collection.module.manager;

import com.jinqiao.b2c.compent.base.BaseRefeshManager;

import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/12.
 * 邮箱：liulei2@aixuedai.com
 */


public class FavoriteGoods extends BaseRefeshManager {
    private List<FavoriteShopDetail> favoriteSampleList;

    public List<FavoriteShopDetail> getFavoriteSampleList() {
        return favoriteSampleList;
    }

    public void setFavoriteSampleList(List<FavoriteShopDetail> favoriteSampleList) {
        this.favoriteSampleList = favoriteSampleList;
    }
}
