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

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdPath() {
		return idPath;
	}

	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public ArrayList<SecondCategoryDetail> getSecondCategoryList() {
		return secondCategoryList;
	}

	public void setSecondCategoryList(ArrayList<SecondCategoryDetail> secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}
}
