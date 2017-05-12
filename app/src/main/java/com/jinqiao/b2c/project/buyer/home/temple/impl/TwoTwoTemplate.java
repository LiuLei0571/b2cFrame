package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.ImageHelper;
import com.jinqiao.b2c.compent.helper.Util;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPageItem;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTitleTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateTitleBaseHolder;


/**
 * Created by milk on 2016/11/1.
 */

public class TwoTwoTemplate extends BaseTitleTemplate<ModelPage, TwoTwoTemplate.TwoTwoHolder> {
    public TwoTwoTemplate(IAct act) {
        super(act);
    }

    @Override
    public TwoTwoHolder createCustomViewHolder(ViewGroup parent) {
        return new TwoTwoHolder(parent);
    }

    @Override
    public void bindCustomViewHolder(TwoTwoHolder holder, ModelPage forum) {
        super.showTitle(holder, forum);
        updateItem(holder.item1, getItem(forum, 0) );
        updateItem(holder.item2, getItem(forum, 1) );
        updateItem(holder.item3, getItem(forum, 2) );
        updateItem(holder.item4, getItem(forum, 3) );
    }

    protected void updateItem(View view, ModelPageItem item ) {
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        TextView tv= (TextView) view.findViewById(R.id.tv_title);
        TextView  mTvMessage = (TextView) view.findViewById(R.id.tv_message);
        ImageView  leftIcon = (ImageView) view.findViewById(R.id.icon_left);
        ImageHelper.display(leftIcon,item == null ? "" : Configs.IMAGE_URL + item.getItemImage());
        ImageHelper.display(icon,item == null ? "" : Configs.IMAGE_URL + item.getItemIcon());
        view.setTag(R.id.item, item);
        view.setOnClickListener(getOnClick());
        if (item != null) {
            Util.showHtmlContent(tv, Util.cutNull(item.getItemTitle()));
            Util.showHtmlContent(mTvMessage, Util.cutNull(item.getItemMessage()));
        }
    }

    public static class TwoTwoHolder extends TemplateTitleBaseHolder {
        View item1, item2, item3, item4;

        public TwoTwoHolder(ViewGroup parent) {
            super(parent, R.layout.template_two_two);
            super.initTitle(itemView);
            item1 = itemView.findViewById(R.id.item1);
            item2 = itemView.findViewById(R.id.item2);
            item3 = itemView.findViewById(R.id.item3);
            item4 = itemView.findViewById(R.id.item4);

        }

        @Override
        public void onViewRecycled() {
            ((ImageView) item1.findViewById(R.id.icon)).setImageDrawable(null);
            ((ImageView) item2.findViewById(R.id.icon)).setImageDrawable(null);
            ((ImageView) item3.findViewById(R.id.icon)).setImageDrawable(null);
            ((ImageView) item4.findViewById(R.id.icon)).setImageDrawable(null);
        }
    }
}
