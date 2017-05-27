package com.jinqiao.b2c.project.buyer.home.manager.bean;

import java.util.ArrayList;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/27.
 * 邮箱：liulei2@aixuedai.com
 */


public class TransCategory {
    private ArrayList<TransFirstCategory> firstCategoryList = new ArrayList<TransFirstCategory>();

    public ArrayList<TransFirstCategory> getFirstCategoryList() {
        return firstCategoryList;
    }

    public void setFirstCategoryList(
            ArrayList<TransFirstCategory> firstCategoryList) {
        this.firstCategoryList = firstCategoryList;
    }
}
