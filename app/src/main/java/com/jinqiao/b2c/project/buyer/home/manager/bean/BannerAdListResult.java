package com.jinqiao.b2c.project.buyer.home.manager.bean;

import java.util.ArrayList;

public class BannerAdListResult {
    private ArrayList<BannerAdDetail> bannerAdvertisingList = new ArrayList<BannerAdDetail>();


    public ArrayList<BannerAdDetail> getBannerAdvertisingList() {
        return bannerAdvertisingList;
    }

    public void setBannerAdvertisingList(
            ArrayList<BannerAdDetail> bannerAdvertisingList) {
        this.bannerAdvertisingList = bannerAdvertisingList;
    }
}
