package com.jinqiao.b2c.compent.constants;


import com.jinqiao.b2c.compent.http.IHost;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/2.
 * 邮箱：liulei2@aixuedai.com
 */


public interface Hosts {
    IHost defaults = new IHost() {
        @Override
        public String getHost() {
            return Configs.BASE_URL;
        }
    };
    IHost ios = new IHost() {
        @Override
        public String getHost() {
            return Configs.BASE_IOS;
        }
    };
    IHost express = new IHost() {
        @Override
        public String getHost() {
            return Configs.EXPRESS_URL;
        }
    };
    IHost url = new IHost() {
        @Override
        public String getHost() {
            return Configs.IMAGE_URL;
        }
    };
}
