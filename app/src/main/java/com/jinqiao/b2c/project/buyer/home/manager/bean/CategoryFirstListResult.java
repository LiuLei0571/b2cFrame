package com.jinqiao.b2c.project.buyer.home.manager.bean;


import com.jinqiao.b2c.project.buyer.collection.module.manager.FirstCategoryDetail;

import java.util.ArrayList;

public class CategoryFirstListResult {
    private ArrayList<FirstCategoryDetail> subCategoryList = new ArrayList<FirstCategoryDetail>();

    public ArrayList<FirstCategoryDetail> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(ArrayList<FirstCategoryDetail> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
