package com.jinqiao.b2c.project.buyer.home.manager.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.jinqiao.b2c.compent.constants.Extras;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class HomeCommond implements Parcelable {
    private String action;
    private int index;
    private boolean enable;

    public HomeCommond(String page, int index) {
        this.action = page;
        this.index = index;
    }


    public static HomeCommond buyerhome() {
        return page(0);
    }

    public static HomeCommond buyerclassify() {
        return page(1);
    }

    public static HomeCommond buyercar() {
        return page(2);
    }

    public static HomeCommond buyercollection() {
        return page(3);
    }

    public static HomeCommond mine() {
        return page(4);
    }

    /**
     * 跳转首页某个tab
     */
    public static HomeCommond page(int index) {
        return new HomeCommond(Extras.HOME.ACTION.PAGE, index);
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.action);
        dest.writeInt(this.index);
        dest.writeByte(this.enable ? (byte) 1 : (byte) 0);
    }

    public HomeCommond() {
    }

    protected HomeCommond(Parcel in) {
        this.action = in.readString();
        this.index = in.readInt();
        this.enable = in.readByte() != 0;
    }

    public static final Parcelable.Creator<HomeCommond> CREATOR = new Parcelable.Creator<HomeCommond>() {
        @Override
        public HomeCommond createFromParcel(Parcel source) {
            return new HomeCommond(source);
        }

        @Override
        public HomeCommond[] newArray(int size) {
            return new HomeCommond[size];
        }
    };
}
