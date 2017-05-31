package com.jinqiao.b2c.project.buyer.home.manager.bean;


public class ThirdCategoryDetail {
	private int id;
	private String name;
	private int parentId;
	private int categoryLevel;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getParentId() {
		return parentId;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
}
