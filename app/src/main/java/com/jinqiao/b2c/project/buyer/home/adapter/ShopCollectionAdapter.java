package com.jinqiao.b2c.project.buyer.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        final FavoriteShopDetail mData = getItem(position);
        if (mData != null) {
            ImageView mIvShop = viewHolderFactory.findViewById(R.id.iv_shop_pic);
            TextView mTvName = viewHolderFactory.findViewById(R.id.tv_shop_name);
            TextView mTvCancel = viewHolderFactory.findViewById(R.id.tv_cancel_shop_collection);
            TextView mTvPrice = viewHolderFactory.findViewById(R.id.tv_price);
            mTvCancel.setText(mTranslatesString.getNotice_cancelfavorite());
            ImageHelper.display(mIvShop, Configs.BASE_PIC_URL + mData.getPicPath());
            mTvName.setText(mData.getTargetName());
            if (mData.getSamplePrice() > 0.0) {
                mTvPrice.setText(mData.getSamplePrice() + "");
            }
            mTvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClicks(mData);
                }
            });

            mIvShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i_to_shop = new Intent(getContext(), ShopHomesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("shopId", mData.getTargetId());
                    i_to_shop.putExtras(bundle);
                    getContext().startActivity(i_to_shop);
                }
            });
        }


    }

    public abstract void onClicks(FavoriteShopDetail mData);

}
