package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeClassifyFragment extends TempleFragment{
    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_index;
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle(mTranslatesString.getCommon_sampleclassify());
    }
}
