package com.jinqiao.b2c.project.buyer.collection.module.manager;

import com.jinqiao.b2c.compent.base.BaseRefeshManager;

import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/12.
 * 邮箱：liulei2@aixuedai.com
 */


public class FavoriteShop  extends BaseRefeshManager{
    private List<FavoriteShopDetail> favoriteShopList;

    public List<FavoriteShopDetail> getFavoriteShopList() {
        return favoriteShopList;
    }

    public void setFavoriteShopList(List<FavoriteShopDetail> favoriteShopList) {
        this.favoriteShopList = favoriteShopList;
    }
}
