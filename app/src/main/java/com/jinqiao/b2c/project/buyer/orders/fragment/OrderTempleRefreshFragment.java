package com.jinqiao.b2c.project.buyer.orders.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.base.TempleFragment;
import com.jinqiao.b2c.compent.ui.widget.RefreshLayout;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderDetailActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderEvaluateActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderLogisticsActivity;
import com.jinqiao.b2c.project.buyer.orders.activity.OrderReturnActivity;
import com.jinqiao.b2c.project.buyer.orders.adapter.AllOrderAdapter;
import com.jinqiao.b2c.project.buyer.orders.module.BuyerOrderList;
import com.jinqiao.b2c.project.buyer.orders.module.MyOrderResult;
import com.jinqiao.b2c.project.buyer.orders.presenter.OrderPresenter;

import javax.inject.Inject;

import butterknife.Bind;

import static com.jinqiao.b2c.R.id.refresh;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/12.
 * 邮箱：liulei2@aixuedai.com
 */


public abstract class OrderTempleRefreshFragment<T> extends TempleFragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.courier_list)
    ListView mCourierList;
    @Bind(refresh)
    RefreshLayout mRefresh;
    @Bind(R.id.tv_nodata)
    TextView mTvNoData;
    @Bind(R.id.empty)
    RelativeLayout mEmpty;
    protected boolean hasNext;
    protected AllOrderAdapter mBaseAdapter;
    Intent mIntent = null;
    private int mPage;
    @Inject
    OrderPresenter mOrderPresenter;

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
                    initData(null, false);
                    mOrderPresenter.getOrderList(0, getType(), true);
                }
            }

            @Override
            public void onRefresh() {
                mOrderPresenter.getOrderList(mPage, getType(), false);
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
        mOrderPresenter.getOrderList(0, getType(), true);
    }


    public void initData(MyOrderResult data, final Boolean refresh) {

        if (!refresh) {
            if (!hasNext) {
                mRefresh.setLoading(false);
                return;
            }
            mPage = mBaseAdapter.getCount();
        } else {
            mBaseAdapter.clear();
        }
        if (mBaseAdapter.getCount() == 0) {
            mEmpty.setVisibility(View.VISIBLE);
        } else {
            mEmpty.setVisibility(View.GONE);
        }
        hasNext=data.isHasNext();
        mBaseAdapter.setData(data.getRows());


    }

    public void refreshData(boolean refresh) {
        if (refresh) {
            mRefresh.setRefreshing(false);
        }
        mRefresh.setLoading(false);
    }


    public abstract String getType();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BuyerOrderList orderList = (BuyerOrderList) (parent.getItemAtPosition(position));
        Intent intent = new Intent(getBaseActivity(), OrderDetailActivity.class);
        intent.putExtra("orderId", orderList.getOrderId());
        startActivity(intent);
    }
}
