package com.jinqiao.b2c.compent.cdi.cmp;


import com.jinqiao.b2c.compent.cdi.annotation.DialogScope;
import com.jinqiao.b2c.compent.ui.dialog.CommonDialog;

import dagger.Subcomponent;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

@DialogScope
@Subcomponent(modules = {DialogModule.class})
public interface DialogComponent {

    void plus(CommonDialog commonDialog);
}
