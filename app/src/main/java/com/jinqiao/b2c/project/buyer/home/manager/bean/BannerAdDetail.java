package com.jinqiao.b2c.project.buyer.home.manager.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BannerAdDetail implements Parcelable {
	private int status;
	private String picPath;
	private int ranking;
	private int id;
	private String picLink;
	private String createTime;
	private String modifyTime;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicLink() {
		return picLink;
	}
	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.status);
		dest.writeString(this.picPath);
		dest.writeInt(this.ranking);
		dest.writeInt(this.id);
		dest.writeString(this.picLink);
		dest.writeString(this.createTime);
		dest.writeString(this.modifyTime);
	}

	public BannerAdDetail() {
	}

	protected BannerAdDetail(Parcel in) {
		this.status = in.readInt();
		this.picPath = in.readString();
		this.ranking = in.readInt();
		this.id = in.readInt();
		this.picLink = in.readString();
		this.createTime = in.readString();
		this.modifyTime = in.readString();
	}

	public static final Parcelable.Creator<BannerAdDetail> CREATOR = new Parcelable.Creator<BannerAdDetail>() {
		@Override
		public BannerAdDetail createFromParcel(Parcel source) {
			return new BannerAdDetail(source);
		}

		@Override
		public BannerAdDetail[] newArray(int size) {
			return new BannerAdDetail[size];
		}
	};
}
