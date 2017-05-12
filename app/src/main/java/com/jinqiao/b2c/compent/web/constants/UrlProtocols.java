package com.jinqiao.b2c.compent.web.constants;


import com.jinqiao.b2c.compent.web.bean.ProtocolBean;
import com.jinqiao.b2c.compent.web.protocol.impl.jsapi.home.HomeExecute;

/**
 * 用途：
 * Created by milk on 17/3/10.
 * 邮箱：649444395@qq.com
 */

public interface UrlProtocols {
    ProtocolBean homes= ProtocolBean.buildProtocol(HomeExecute.class,"go").module("home");
}
