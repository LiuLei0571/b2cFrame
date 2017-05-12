package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.ViewGroup;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateBaseHolder;
import com.jinqiao.b2c.project.buyer.home.widget.BannerLayout;


/**
 * 广告
 * Created by milk on 2016/10/27.
 */

public class BannerTemplate extends BaseTemplate<ModelPage, BannerTemplate.BannerTempHolder> {
    public BannerTemplate(IAct act) {
        super(act);
    }

    @Override
    public BannerTempHolder createCustomViewHolder(ViewGroup parent) {
        return new BannerTempHolder(parent);
    }

    @Override
    public void bindCustomViewHolder(BannerTempHolder holder, final ModelPage model) {
        holder.banner.setBanners(model.getItems(), getOnClick());
    }


    public static class BannerTempHolder extends TemplateBaseHolder {
        BannerLayout banner;

        public BannerTempHolder(ViewGroup parent) {
            super(parent, R.layout.template_banner);
            banner = (BannerLayout) itemView;
        }
    }
}
