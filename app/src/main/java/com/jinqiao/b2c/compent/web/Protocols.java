package com.jinqiao.b2c.compent.web;


import com.jinqiao.b2c.compent.web.bean.ProtocolBean;

import static com.jinqiao.b2c.compent.web.constants.JsApiProtocols.uploadPickImage;
import static com.jinqiao.b2c.compent.web.constants.JsApiProtocols.uploadWithTakePhoto;
import static com.jinqiao.b2c.compent.web.constants.UrlProtocols.homes;

/**
 * 用途：
 * Created by milk on 17/1/20.
 * 邮箱：649444395@qq.com
 */

public interface Protocols {
    ProtocolBean[] jsProtocols = new ProtocolBean[]{
             uploadPickImage,uploadWithTakePhoto
    };
    ProtocolBean[] urlIntercepter = new ProtocolBean[]{

    };
    ProtocolBean[] actionProtocols=new ProtocolBean[]{
            homes
    };
}
