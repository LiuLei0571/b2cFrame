package com.jinqiao.b2c.project.buyer.home.manager.bean;


import java.util.ArrayList;

public class CategoryFirstListResult {
    private ArrayList<FirstCategoryDetail> firstCategoryList = new ArrayList<FirstCategoryDetail>();


    public ArrayList<FirstCategoryDetail> getFirstCategoryList() {
        return firstCategoryList;
    }

    public void setFirstCategoryList(
            ArrayList<FirstCategoryDetail> firstCategoryList) {
        this.firstCategoryList = firstCategoryList;
    }
}
