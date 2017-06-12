package com.jinqiao.b2c.project.buyer.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseAdapter;
import com.jinqiao.b2c.compent.constants.Configs;
import com.jinqiao.b2c.compent.helper.ImageHelper;
import com.jinqiao.b2c.project.buyer.goods.ShopHomesActivity;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FavoriteShopDetail;


public abstract class ShopCollectionAdapter extends BaseAdapter<FavoriteShopDetail> {


    public ShopCollectionAdapter(Context context) {
        super(context, R.layout.collection_shop_item);
    }

    @Override
    public void renderView(ViewHolderFactory viewHolderFactory, final int position) {

        final FavoriteShopDetail item_shop = getItem(position);

        ImageView mIvshop = viewHolderFactory.findViewById(R.id.iv_shop_pic);
        TextView mTvName = viewHolderFactory.findViewById(R.id.tv_shop_name);
        TextView mTvCancel = viewHolderFactory.findViewById(R.id.tv_cancel_shop_collection);

        mTvCancel.setText(mTranslatesString.getNotice_cancelfavorite());
        ImageHelper.display(mIvshop, Configs.BASE_PIC_URL);
        mTvName.setText(item_shop.getTargetName());

        mTvCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopCollectionAdapter.this.onClick(position);
            }
        });

        mIvshop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_to_shop = new Intent(getContext(), ShopHomesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("shopId", item_shop.getTargetId());
                i_to_shop.putExtras(bundle);
                getContext().startActivity(i_to_shop);
            }
        });

    }

    public abstract void onClick(int position);

}
