package com.jinqiao.b2c.compent.base;

import android.os.Bundle;
import android.view.View;

import com.jinqiao.b2c.common.task.IGroup;


/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public interface IView extends IGroup, IAct {

    void beforeViewBind(View rootView);

    void afterViewBind(Bundle saveInstanceState);

    View findViewId(int id);

    void bindView(View view);

    void unBindView();

    void savePresenter(BasePresenter presenter);
}
