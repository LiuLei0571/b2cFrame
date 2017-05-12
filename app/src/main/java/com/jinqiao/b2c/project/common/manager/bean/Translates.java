package com.jinqiao.b2c.project.common.manager.bean;


import java.io.Serializable;

public class Translates  implements Serializable{
    private MobileStaticTextCode mobileStaticTextCode;
    private OptionList optionList;

    public MobileStaticTextCode getMobileStaticTextCode() {
        return mobileStaticTextCode;
    }

    public void setMobileStaticTextCode(MobileStaticTextCode mobileStaticTextCode) {
        this.mobileStaticTextCode = mobileStaticTextCode;
    }

    public OptionList getOptionList() {
        return optionList;
    }

    public void setOptionList(OptionList optionList) {
        this.optionList = optionList;
    }
}
