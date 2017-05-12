package com.jinqiao.b2c.compent.web.presenter;


import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.web.view.fragment.WebViewFragment;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class WebViewFragmentPresenter extends BasePresenter<WebViewFragment> {
    @Inject
    public WebViewFragmentPresenter(IView iView) {
        super(iView);
    }
}
