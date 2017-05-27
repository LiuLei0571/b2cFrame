package com.jinqiao.b2c.project.buyer.home.manager.bean;


import java.util.ArrayList;

public class FirstCategoryDetail {
	private int id;
	private String name;
	private String idPath;
	private int categoryLevel;
	private ArrayList<SecondCategoryDetail> secondCategoryList=new ArrayList<SecondCategoryDetail>();
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getIdPath() {
		return idPath;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public ArrayList<SecondCategoryDetail> getSecondCategoryList() {
		return secondCategoryList;
	}
	
}
