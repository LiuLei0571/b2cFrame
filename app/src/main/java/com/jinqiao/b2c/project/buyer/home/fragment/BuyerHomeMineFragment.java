package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.ui.widget.SettingLayout;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeMineFragment extends BaseFragment {

    @Bind(R.id.iv_head)
    ImageView mIvHead;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.ryt_user)
    RelativeLayout mRytUser;
    @Bind(R.id.lyt_all_order)
    SettingLayout mLytAllOrder;

    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_mine;
    }


    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        mLytAllOrder.setHasArrow(true);
        mLytAllOrder.setItemClick(new SettingLayout.OnItemClick() {
            @Override
            public void onCLick() {

            }
        });
    }

    public SettingLayout.OnItemClick getClick = new SettingLayout.OnItemClick() {
        @Override
        public void onCLick() {

        }
    };
}
