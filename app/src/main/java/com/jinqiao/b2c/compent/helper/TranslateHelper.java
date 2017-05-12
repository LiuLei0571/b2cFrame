package com.jinqiao.b2c.compent.helper;

import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;
import com.jinqiao.b2c.project.common.manager.bean.OptionList;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class TranslateHelper {
    public static MobileStaticTextCode getMobileText(){
        return SPHelper.getBean("translate", MobileStaticTextCode.class);
    }
    public static OptionList getMobileList(){
        return SPHelper.getBean("options", OptionList.class);

    }
}
