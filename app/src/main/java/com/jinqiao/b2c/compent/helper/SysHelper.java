package com.jinqiao.b2c.compent.helper;

import android.content.Intent;

import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.constants.Extras;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.buyer.home.manager.bean.HomeCommand;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/7.
 * 邮箱：liulei2@aixuedai.com
 */


public class SysHelper {
    public static void goBuyerHome(IAct iAct, int index) {
        Intent intent = new Intent(iAct.getActivity(), BuyerHomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Extras.HOME.COMMAND, HomeCommand.page(index));
    }
}
