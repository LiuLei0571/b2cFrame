package com.jinqiao.b2c.compent.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.http.Api;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.compent.ui.widget.RefreshLayout;

import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/12.
 * 邮箱：liulei2@aixuedai.com
 */


public abstract class TempleRefreshFragment<T> extends TempleFragment {

    @Bind(R.id.courier_list)
    ListView mCourierList;
    @Bind(R.id.refresh)
    RefreshLayout mRefresh;
    @Bind(R.id.tv_nodata)
    TextView mTvNoData;
    @Bind(R.id.empty)
    RelativeLayout mEmpty;
    protected boolean hasNext;
    protected BaseAdapter mBaseAdapter;
    @Inject
    SimplePresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_base_refresh;
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        mRefresh.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onLoadMore() {
                if (hasNext) {
                    initData(false);
                }
            }

            @Override
            public void onRefresh() {
                initData(true);
            }
        });
        mRefresh.setColorSchemeResources(R.color.red, R.color.orange, R.color.blue);
        mBaseAdapter = getAdapter();
        mCourierList.setAdapter(mBaseAdapter);
        initData(true);
    }


    private void initData(final Boolean refresh) {
        int mPage = 0;


        if (!refresh) {
            if (!hasNext) {
                mRefresh.setLoading(false);
                return;
            }
            mPage = mBaseAdapter.getCount();
        }
        mPresenter.apiCall(getApi(), getParams(1), new ApiTask<T>() {
            @Override
            public void onSuccess(IResult<T> result) {
                super.onSuccess(result);
                if (mBaseAdapter.isEmpty()) {
                    mEmpty.setVisibility(View.VISIBLE);
                } else {
                    mEmpty.setVisibility(View.GONE);
                }
                successResult(result.data());

            }

            @Override
            public void onAfterCall() {
                super.onAfterCall();
                if (refresh) {
                    mRefresh.setRefreshing(false);
                }
                mRefresh.setLoading(false);
            }
        });
    }

    protected abstract void successResult(T data);

    public abstract BaseAdapter getAdapter();

    public abstract Api getApi();

    public abstract Map<String, Object> getParams(int page);
}
