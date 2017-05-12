package com.jinqiao.b2c.project.buyer.home.temple.impl;

import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.utils.lang.Strings;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.project.buyer.home.adapter.CategoryAdapter;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPageItem;
import com.jinqiao.b2c.project.buyer.home.temple.BaseTemplate;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateBaseHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by milk on 2016/10/28.
 */

public class CategoryInfoTemplate extends BaseTemplate<ModelPage, CategoryInfoTemplate.CategoryInfoHolder> {
    public CategoryInfoTemplate(IAct act) {
        super(act);
    }

    @Override
    public CategoryInfoHolder createCustomViewHolder(ViewGroup parent) {
        return new CategoryInfoHolder(parent);
    }

    @Override
    public void bindCustomViewHolder(CategoryInfoHolder holder, ModelPage model) {
        List<ModelPageItem> categories = model.getItems();
        List<ModelPageItem> newCategories = new ArrayList<>();
        if (categories == null) {
            return;
        }

        // 锁定区块只显示两行10个，超过10个剔除多余的
        if (categories.size() > 10) {
            for (int i = 0; i < categories.size() - 1; i++) {
                if (i > 9) {
                    break;
                }
                newCategories.add(categories.get(i));
            }
        } else {
            newCategories = categories;
        }

        //8个及以下4个一列，否则5个一列
        if (newCategories.size() <= 8) {
            holder.container.setNumColumns(4);
        } else {
            holder.container.setNumColumns(5);
        }

        CategoryAdapter categoryAdapter = new CategoryAdapter(getAct().getContext(),
                null);
        categoryAdapter.setData(newCategories);
        categoryAdapter.setListener(getOnClick());
        holder.container.setAdapter(categoryAdapter);
        if (!Strings.EMPTY.equals(model.getBackGroundImage())) {
//            ImageHelper.display(model.getBackGroundImage(), holder.bgImg);
        }
    }


    public static class CategoryInfoHolder extends TemplateBaseHolder {
        ImageView bgImg;
        GridView container;

        public CategoryInfoHolder(ViewGroup parent) {
            super(parent, R.layout.template_area);
            bgImg = (ImageView) itemView.findViewById(R.id.img);
            container = (GridView) itemView.findViewById(R.id.container);
        }

        @Override
        public void onViewRecycled() {
            bgImg.setImageDrawable(null);
        }
    }
}
