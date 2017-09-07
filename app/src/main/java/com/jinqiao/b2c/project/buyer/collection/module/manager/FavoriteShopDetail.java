package com.jinqiao.b2c.project.buyer.collection.module.manager;


import java.io.Serializable;

public class FavoriteShopDetail implements Serializable {
	private String targetName;
	private int targetId;
	private String picPath;
	private String shopIntro;
	private double samplePrice;
	private String shopAddress;
	private int id;

	public double getSamplePrice() {
		return samplePrice;
	}

	public void setSamplePrice(double samplePrice) {
		this.samplePrice = samplePrice;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getShopIntro() {
		return shopIntro;
	}

	public void setShopIntro(String shopIntro) {
		this.shopIntro = shopIntro;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
