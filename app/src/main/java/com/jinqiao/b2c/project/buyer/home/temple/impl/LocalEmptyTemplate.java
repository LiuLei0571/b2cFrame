package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.View;
import android.view.ViewGroup;

import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.ITemplateModel;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateBaseHolder;


/**
 * Created by milk on 2016/10/27.
 */

public class LocalEmptyTemplate extends BaseTemplate<ITemplateModel, TemplateBaseHolder> {

    public LocalEmptyTemplate(IAct act) {
        super(act);
    }

    @Override
    public TemplateBaseHolder createCustomViewHolder(ViewGroup parent) {
        View emptyView = new View(parent.getContext());
        return new TemplateBaseHolder(emptyView);
    }
}
