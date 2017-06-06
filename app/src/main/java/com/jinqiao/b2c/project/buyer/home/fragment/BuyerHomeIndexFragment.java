package com.jinqiao.b2c.project.buyer.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.common.utils.lang.Strings;
import com.jinqiao.b2c.compent.base.BaseFragment;
import com.jinqiao.b2c.compent.base.SimplePresenter;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.compent.thread.ApiCallback;
import com.jinqiao.b2c.project.buyer.home.activity.SearchActivity;
import com.jinqiao.b2c.project.buyer.home.adapter.TemplateRecyclerAdapterNew;
import com.jinqiao.b2c.project.buyer.home.manager.bean.ModelPage;
import com.jinqiao.b2c.project.buyer.home.temple.ITemplateModel;
import com.jinqiao.b2c.project.buyer.home.temple.SimpleTemplateModel;
import com.jinqiao.b2c.project.buyer.home.temple.Templates;
import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;
import com.jinqiao.b2c.project.logistics.LivesCommuntiyHomeActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeIndexFragment extends BaseFragment {
    @Bind(R.id.search)
    TextView mSearch;
    @Bind(R.id.title_bar)
    LinearLayout mTitleBar;
    @Bind(R.id.tv_data)
    RecyclerView mRecyclerView;
    @Bind(R.id.tv_home_setting)
    TextView tv_home_setting;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ModelPage> mModelPageList = new ArrayList<>();
    private TemplateRecyclerAdapterNew mAdapter;
    final List<ITemplateModel> list = new ArrayList<>();
    @Inject
    SimplePresenter mPresenter;

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
        tv_home_setting.setText(mTranslatesString.getConmon_yuyanqiehuan());
        mAdapter = new TemplateRecyclerAdapterNew(this);
        mSearch.setText(mTranslatesString.getCommon_searchsampleshop());
        mRecyclerView.setAdapter(mAdapter);
        final int allColunms = 2;
        mLayoutManager = new GridLayoutManager(getActivity(), allColunms);
        ((GridLayoutManager) mLayoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int column = allColunms;
                ITemplateModel iTemplateModel = mAdapter.getItem(position);
                String templateType = Strings.EMPTY;
                if (iTemplateModel != null) {
                    Templates templates = iTemplateModel.getTemplate();
                    boolean isOneRow = templates.isInOneRow();

                    if (!isOneRow) {
                        column = 1;
                    }
                    templateType = templates.name();
                }
                return column;
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void formatData(List<ModelPage> data) {
        if (data != null) {
            for (ModelPage modelPage : data) {
                if (modelPage == null) {
                    continue;
                }
                list.add(modelPage);
                if (Strings.TRUE.equals(modelPage.getSeparatorVisible())) {
                    list.add(new SimpleTemplateModel(Templates.LOCAL_DRIVER));
                }
            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAdapter.setDataWithNotify(list);
                    mAdapter.notifyDataSetChanged();
                }
            });

        }
    }

    @OnClick(R.id.title_bar)
    public void onClick() {
        getBaseActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @OnClick(R.id.iv_lanuage)
    public void onClicks() {
        getBaseActivity().startActivity(new Intent(getActivity(), LivesCommuntiyHomeActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        mTranslatesString = SPHelper.getBean("translate", MobileStaticTextCode.class);
        mSearch.setText(mTranslatesString.getCommon_searchsampleshop());
        tv_home_setting.setText(mTranslatesString.getConmon_yuyanqiehuan());
        initData();
    }

    private void initData() {
        mPresenter.apiCall(Apis.home, new ApiCallback<List<ModelPage>>() {
            @Override
            public void onSuccess(IResult result) {
                super.onSuccess(result);
                if (result.data() != null) {
                    List<ModelPage> results = (List<ModelPage>) result.data();
                    formatData(results);
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
        mModelPageList.clear();
    }

}
