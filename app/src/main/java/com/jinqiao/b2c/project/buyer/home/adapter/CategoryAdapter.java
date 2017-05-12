package com.jinqiao.b2c.project.buyer.home.adapter;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseAdapter;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.ImageHelper;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPageItem;


/**
 * @author Created by zhangzh on 2016/05/25.
 */
public class CategoryAdapter extends BaseAdapter<ModelPageItem> {
    private View.OnClickListener listener;

    public CategoryAdapter(Context context, View.OnClickListener mOnClick) {
        super(context, R.layout.template_category_item);
        this.listener = mOnClick;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void renderView(ViewHolderFactory viewHolderFactory, int position) {
        ModelPageItem category = getItem(position);
        TextView text = viewHolderFactory.findViewById(R.id.text);
        ImageView icon = viewHolderFactory.findViewById(R.id.icon);
        ImageHelper.display(icon, category == null ? "" : Configs.IMAGE_URL + category.getItemImage());

        if (category != null) {
            UIHelper.showHtmlContent(text, category.getItemTitle());
            viewHolderFactory.getConvertView().setTag(R.id.item, category);
            viewHolderFactory.getConvertView().setOnClickListener(listener);
        }
    }
}
