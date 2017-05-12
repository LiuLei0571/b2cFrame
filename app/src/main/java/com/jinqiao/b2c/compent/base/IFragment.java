package com.jinqiao.b2c.compent.base;


import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public interface IFragment extends IView {

    void doInject(FragmentComponent component);
}
