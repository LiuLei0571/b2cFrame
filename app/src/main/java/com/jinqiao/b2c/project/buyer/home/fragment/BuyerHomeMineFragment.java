package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.ui.HeadBar;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeMineFragment extends BaseFragment {
    @Nullable
    @Bind(R.id.header_)
    HeadBar mHeadBar;

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
        mHeadBar.setTitle("我的");
        mHeadBar.setBackVisable(false);
        mHeadBar.addText("设置", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
