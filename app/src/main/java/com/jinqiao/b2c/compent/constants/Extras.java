package com.jinqiao.b2c.compent.constants;

import com.jinqiao.b2c.project.buyer.home.manager.bean.HomeCommand;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public interface Extras {

    /**
     * 商家信息提交步揍
     */
    int SELLERSTEPNULL = 0;//没有提交任何商家信息
    int SELLERSTEPFIRST = 10;//商家信息提交
    int SELLERSTEPSECOND = 20;//公司负责人信息提交
    int SELLERSTEPTHIRD = 40;//结算账号信息提交

    /**
     * 操作类型
     * 注册，登录，修改
     */
    int LAUNCH = 1;
    int REGISTER = 1;
    int LOGIN = 2;
    int UPDATE = 3;
    /**
     * 卖家类型：
     * 0： 个人
     * 1： 企业（绿色字段为个人；蓝色为企业字段）
     */
    int PERSONAL = 0;
    int COMPANY = 1;
    interface HOME{
       interface ACTION{
          String PAGE="home_page";
       }
       String KEY="home_key";
        String COMMAND="command";
    }
    interface HOMECOMMOND{
        HomeCommand INDEX= HomeCommand.buyerhome();
        HomeCommand CLASSIFY= HomeCommand.buyerclassify();
        HomeCommand CAR= HomeCommand.buyercar();
        HomeCommand COLLECTION= HomeCommand.buyercollection();
        HomeCommand MINE= HomeCommand.mine();
    }
}
