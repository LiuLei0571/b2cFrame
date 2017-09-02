package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

    Toolbar mToolbar;

    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_mine;
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mToolbar = (Toolbar) rootView.findViewById(R.id.mine_b2c_tool_bar);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        super.initImmersionBar();
        mImmersionBar.titleBar(mToolbar).init();
    }

    public SettingLayout.OnItemClick getClick = new SettingLayout.OnItemClick() {
        @Override
        public void onCLick() {

        }
    };
}
