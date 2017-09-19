package com.jinqiao.b2c.project.buyer.home.adapter;

import android.content.Context;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseAdapter;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/19.
 * 邮箱：liulei2@aixuedai.com
 */


public class SearchAdapter extends BaseAdapter<String> {
    public SearchAdapter(Context context) {
        super(context, R.layout.item_search);
    }

    @Override
    public void renderView(ViewHolderFactory viewHolderFactory, int position) {
        TextView mTv = viewHolderFactory.findViewById(R.id.tv_name);
        mTv.setText(getData().get(position));
    }
}
