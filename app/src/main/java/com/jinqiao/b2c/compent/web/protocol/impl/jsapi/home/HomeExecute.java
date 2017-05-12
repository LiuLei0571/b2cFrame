package com.jinqiao.b2c.compent.web.protocol.impl.jsapi.home;

import android.content.Intent;

import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.web.callback.ICallBack;
import com.jinqiao.b2c.compent.web.protocol.BaseProtocolInstance;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;


/**
 * 用途：
 * Created by milk on 17/3/17.
 * 邮箱：649444395@qq.com
 */

public class HomeExecute extends BaseProtocolInstance {
    @Override
    public void doExecute(IAct iAct, ICallBack iCallBack, Object params) {
        super.doExecute(iAct, iCallBack, params);
        iAct.startActivity(new Intent(iAct.getActivity(),BuyerHomeActivity.class));

    }
}
