package com.jinqiao.b2c.project.buyer.orders.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.SimplePresenter;
import com.jinqiao.b2c.compent.base.TempleFragment;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.compent.ui.widget.RefreshLayout;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderEvaluateActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderLogisticsActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderReturnActivity;
import com.jinqiao.b2c.project.buyer.orders.adapter.AllOrderAdapter;
import com.jinqiao.b2c.project.buyer.orders.module.BuyerOrderList;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/12.
 * 邮箱：liulei2@aixuedai.com
 */


public abstract class OrderTempleRefreshFragment<T> extends TempleFragment {

    @Bind(R.id.courier_list)
    ListView mCourierList;
    @Bind(R.id.refresh)
    RefreshLayout mRefresh;
    @Bind(R.id.tv_nodata)
    TextView mTvNoData;
    @Bind(R.id.empty)
    RelativeLayout mEmpty;
    protected boolean hasNext;
    protected AllOrderAdapter mBaseAdapter;
    @Inject
    SimplePresenter mPresenter;
    Intent mIntent = null;

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
        mBaseAdapter = new AllOrderAdapter(getContext()) {
            /**
             * 提醒发货
             * @param order
             */
            @Override
            public void remind(BuyerOrderList order) {

            }

            /**
             * 取消订单
             * @param order
             */
            @Override
            public void cancel(BuyerOrderList order) {

            }

            /*
             * 查看物流
             */
            @Override
            public void seeExp(BuyerOrderList order) {
                mIntent = new Intent(getBaseActivity(), OrderLogisticsActivity.class);
                mIntent.putExtra("orderId", order.getOrderId());
                getBaseActivity().startActivity(mIntent);
            }

            /*
             * 申请退货
             */
            @Override
            public void returnGood(BuyerOrderList order) {
                mIntent = new Intent(getBaseActivity(), OrderReturnActivity.class);
                mIntent.putExtra("order", order);
                getBaseActivity().startActivity(mIntent);

            }

            /**
             * 订单评价
             * @param order
             */
            @Override
            public void evaluate(BuyerOrderList order) {
                mIntent = new Intent(getBaseActivity(), OrderEvaluateActivity.class);
                mIntent.putExtra("object", order);
                getBaseActivity().startActivity(mIntent);
            }
        };
        mCourierList.setAdapter(mBaseAdapter);
        refreshData();
    }


    private void initData(final Boolean refresh) {
        int mPage = 0;

        if (!refresh) {
            if (!hasNext) {
                mRefresh.setLoading(false);
                return;
            }
            mPage = mBaseAdapter.getCount();
        } else {
            mBaseAdapter.clear();
        }
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("startRow", mPage);
        parameter.put("orderStatus", getType());
        mPresenter.apiCall(Apis.buyerOrder, parameter, new ApiTask<T>() {
            @Override
            public void onSuccess(IResult<T> result) {
                super.onSuccess(result);
                if (mBaseAdapter.getCount() == 0) {
                    mEmpty.setVisibility(View.VISIBLE);
                } else {
                    mEmpty.setVisibility(View.GONE);
                }
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

    public void refreshData() {
        initData(true);
    }


    public abstract String getType();

}
