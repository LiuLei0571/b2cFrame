package com.jinqiao.b2c.project.buyer.orders.module;

import java.util.List;

public class MyOrderResult {
    private List<BuyerOrderList> rows;
    protected boolean hasNext;

    public List<BuyerOrderList> getRows() {
        return rows;
    }

    public void setRows(List<BuyerOrderList> rows) {
        this.rows = rows;
    }


    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
