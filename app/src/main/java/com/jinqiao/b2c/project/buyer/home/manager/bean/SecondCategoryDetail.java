package com.jinqiao.b2c.project.buyer.home.manager.bean;

import java.util.ArrayList;

public class SecondCategoryDetail {
	private int id;
	private String name;
	private int categoryLevel;
	private ArrayList<ThirdCategoryDetail> thirdCategoryList=new ArrayList<ThirdCategoryDetail>();
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public ArrayList<ThirdCategoryDetail> getThirdCategoryList() {
		return thirdCategoryList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public void setThirdCategoryList(ArrayList<ThirdCategoryDetail> thirdCategoryList) {
		this.thirdCategoryList = thirdCategoryList;
	}
}
