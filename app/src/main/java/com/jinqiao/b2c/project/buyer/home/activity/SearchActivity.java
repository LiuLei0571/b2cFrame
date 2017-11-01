package com.jinqiao.b2c.project.buyer.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.StatusBarHelper;
import com.jinqiao.b2c.common.statusBar.StatusBarState;
import com.jinqiao.b2c.compent.base.BasePopupWindow;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.ui.popup.PopupFactory;
import com.jinqiao.b2c.project.buyer.home.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/12.
 * 邮箱：liulei2@aixuedai.com
 */


public class SearchActivity extends TempleActivity {
    @Bind(R.id.tv_category)
    TextView mTvCategory;
    @Bind(R.id.btn_search)
    TextView mTvClose;
    @Bind(R.id.lyt_top)
    RelativeLayout mLytTop;
    List<String> mData = new ArrayList<>();
    SearchAdapter mAdapter;
    BasePopupWindow mBasePopupWindow;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_buyer_serach_home;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void intStatusBar() {
        StatusBarHelper.initStatusBar(this, StatusBarState.TOOLBAR_VIEW, R.id.lyt_top);

    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        mData.add("商品");
        mData.add("店铺");
    }

    @OnClick({R.id.tv_category, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_category:
                PopupFactory.builder(this, "showAs", mData, mTvCategory, new PopupFactory.OnItemClick() {
                    @Override
                    public void getItem(int position) {
                        mTvCategory.setText(mData.get(position));
                    }
                });
                break;
            case R.id.btn_search:

                finish();
                break;
        }
    }
}
