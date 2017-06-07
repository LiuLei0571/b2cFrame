package com.jinqiao.b2c.project.buyer.user.manager.module;


public class BuyerUser {
    private String loginName;
    private int userType;
    private int userId;
    /**
     * 10：商家信息提交
     * 20：公司负责人信息提交
     * 40：结算账号信息提交
     */
    private int step;
    private String token;
    private int deliveryCompanyId;

    public int getDeliveryCompanyId() {
        return deliveryCompanyId;
    }

    public void setDeliveryCompanyId(int deliveryCompanyId) {
        this.deliveryCompanyId = deliveryCompanyId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
