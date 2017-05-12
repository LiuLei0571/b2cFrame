package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseActivity;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.ImageHelper;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPageItem;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTitleTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateTitleBaseHolder;


/**
 * 有待优化
 * Created by milk on 2017/01/1.
 */

public class FourTemplate extends BaseTitleTemplate<ModelPage, FourTemplate.FourHolder> {
    public FourTemplate(IAct act) {
        super(act);
    }

    @Override
    public FourHolder createCustomViewHolder(ViewGroup parent) {
        return new FourHolder(parent);
    }

    @Override
    public void bindCustomViewHolder(FourHolder holder, ModelPage forum) {
        super.showTitle(holder, forum);
        if (forum.getItems() != null && forum.getItems().size() > 0) {
            holder.contentLyt.removeAllViews();
            for (int i = 0; i < forum.getItems().size(); i++) {
                View layout = ((BaseActivity) getAct().getContext()).getLayoutInflater().inflate(
                        R.layout.template_single_with_text, null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
                layout.setLayoutParams(layoutParams);
                updateItem(layout, getItem(forum, i));
                holder.contentLyt.addView(layout);
            }
        }
    }

    protected void updateItem(View view, ModelPageItem item) {
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        ImageHelper.display(icon,item == null ? "" : Configs.BASE_PIC_URL+item.getItemImage());
        view.setTag(R.id.item, item);
        view.setOnClickListener(getOnClick());
    }

    public static class FourHolder extends TemplateTitleBaseHolder {
        LinearLayout contentLyt;

        public FourHolder(ViewGroup parent) {
            super(parent, R.layout.template_four);
            super.initTitle(itemView);
            contentLyt = (LinearLayout) itemView.findViewById(R.id.container);
        }
    }
}
