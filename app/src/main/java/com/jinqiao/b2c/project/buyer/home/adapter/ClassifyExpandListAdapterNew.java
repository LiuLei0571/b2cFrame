package com.jinqiao.b2c.project.buyer.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseExpandableAdapter;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.project.buyer.goods.GoodsListActivity;
import com.jinqiao.b2c.project.buyer.home.manager.bean.TransFirstCategory;
import com.jinqiao.b2c.project.buyer.home.manager.bean.TransSecondCategory;

import java.util.List;

public class ClassifyExpandListAdapterNew extends BaseExpandableAdapter<TransFirstCategory, TransSecondCategory> {
    private List<TransFirstCategory> firstCategoryList;
    private String type;
    String categoryName = "";
    TransFirstCategory mFirstCategory;
    TransSecondCategory mSecondCategory;

    public ClassifyExpandListAdapterNew(Context context) {
        super(context, R.layout.classify_gourp_item, R.layout.classify_second_item);
    }

    @Override
    protected void renderGroupView(GroupViewHoldFactory viewHolder, boolean isExpanded, int groupPosition) {
        TransFirstCategory mFirstCategory = getGroup(groupPosition);

        TextView mTvGroup = viewHolder.findViewById(R.id.tv_classify_group);
        ImageView mIvIndicator = viewHolder.findViewById(R.id.iv_indicator);
        if (isExpanded) {
            mIvIndicator.setBackgroundResource(R.drawable.classify_indicator_unexpand);
        } else {
            mIvIndicator.setBackgroundResource(R.drawable.classify_indicator_expand);
        }
        mTvGroup.setText(mFirstCategory.getName());
    }

    @Override
    protected void renderChildView(ChildViewHoldFactory viewHolder, int childPosition, TransFirstCategory item) {
        if (item.getSecondCategoryList().size() > 0) {
            mSecondCategory = item.getSecondCategoryList().get(childPosition);
            if (mSecondCategory != null) {
                TextView mTvItem = viewHolder.findViewById(R.id.tv_classify_item);
                if (mSecondCategory.getCategoryLevel() == 2) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mTvItem.getLayoutParams();
                    layoutParams.setMarginStart(UIHelper.dip2px(getContext(), 15));
                }
                mTvItem.setText(mSecondCategory.getName());
                mTvItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), GoodsListActivity.class);
                        intent.putExtra("categoryId", mSecondCategory.getId() + "");
                        getContext().startActivity(intent);
                    }
                });
            }
        }

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        mFirstCategory = getGroup(groupPosition);
        return mFirstCategory.getSecondCategoryList().size();
    }

    @Override
    public TransSecondCategory getChild(int groupPosition, int childPosition) {
        mFirstCategory = getGroup(groupPosition);

        return mFirstCategory.getSecondCategoryList().get(childPosition);
    }

}
