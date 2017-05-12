package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.View;
import android.view.ViewGroup;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.project.App;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateBaseHolder;


/**
 * Created by milk on 2016/10/28.
 */

public class LocalDriverTemplate extends BaseTemplate<ModelPage, TemplateBaseHolder> {
    public LocalDriverTemplate(IAct act) {
        super(act);
    }

    @Override
    public TemplateBaseHolder createCustomViewHolder(ViewGroup parent) {
        View view = new View(parent.getContext());
        int height = App.getContext().getResources().getDimensionPixelSize(R.dimen.margin_middle);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                height);
        view.setLayoutParams(lp);
        return new TemplateBaseHolder(view);
    }

}
