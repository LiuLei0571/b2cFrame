package com.jinqiao.b2c.project.buyer.home.temple;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.project.buyer.goods.GoodsDetailActivity;
import com.jinqiao.b2c.project.buyer.goods.GoodsListActivity;
import com.jinqiao.b2c.project.buyer.goods.ShopHomesActivity;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPageItem;
import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;


/**
 * Created by milk on 2016/10/27.
 */

public abstract class BaseTemplate<M extends ITemplateModel, VH extends TemplateBaseHolder>
        implements ITemplate<M, VH> {
    private IAct act;
    private View.OnClickListener mOnClick;
    private ModelPageItem data;
    protected MobileStaticTextCode mTranslatesString;
    protected Intent intent;
    protected Bundle bundle;

    public View.OnClickListener getOnClick() {
        if (mOnClick == null) {
            mOnClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object item = v.getTag(R.id.item);
                    String type = "";
                    if (item != null && item instanceof ModelPageItem) {
                        type = ((ModelPageItem) item).getItemType();
                        data = ((ModelPageItem) item);
                    }
                    if (!TextUtils.isEmpty(type) && data != null) {
                        switch (type) {
                            case "goodsList":
                                intent = new Intent(act.getActivity(), GoodsListActivity.class);
                                bundle = new Bundle();
                                bundle.putString("categoryId", data.getItemGoodsList() + "");
                                intent.putExtras(bundle);
                                break;
                            case "goodsDetail":
                                intent = new Intent(act.getActivity(), GoodsDetailActivity.class);
                                bundle = new Bundle();
                                bundle.putInt("sampleId", data.getItemGoodsDetailId());
                                intent.putExtras(bundle);
                                break;
                            case "shopHome":
                                intent = new Intent(act.getActivity(), ShopHomesActivity.class);
                                bundle = new Bundle();
                                bundle.putInt("shopId", data.getItemStoreId());
                                intent.putExtras(bundle);
                                break;
                        }
                        act.getActivity().startActivity(intent);
                    }
                }
            };
        }
        return mOnClick;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.mOnClick = listener;
    }

    public BaseTemplate(IAct act) {
        this.act = act;
        mTranslatesString = SPHelper.getBean("translate", MobileStaticTextCode.class);
    }

    @Override
    public void onResume(IAct act) {

    }

    @Override
    public void onPause(IAct act) {

    }

    public IAct getAct() {
        return act;
    }

    @Override
    public void bindCustomViewHolder(VH holder, M model) {

    }

}
