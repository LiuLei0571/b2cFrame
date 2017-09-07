package com.jinqiao.b2c.project.buyer.user;

import java.io.Serializable;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class UserInfo implements Serializable {
    /**
     * lastName :
     * sex : 0
     * email : 649444395@qq.com
     * tel :
     * userId : 10258
     * birthDate :
     * headPic : upload/headPhoto/20170828/1503907960653.jpg
     * firstName :
     * mobile : 09123456735435
     * loginName : lenny
     */

    private String lastName;
    private int sex;
    private String email;
    private String tel;
    private int userId;
    private String birthDate;
    private String headPic;
    private String firstName;
    private String mobile;
    private String loginName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
