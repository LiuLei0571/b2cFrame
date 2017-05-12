package com.jinqiao.b2c.compent.base;

import java.util.Collection;

/**
 * Created by yh on 2016/7/11.
 */
public interface IPageAdapter<T> {
    /**
     * 清空数据
     */
    void clear();

    int getCount();

    void notifyDataSetChanged();

    boolean isEmpty();

    void addAll(Collection<? extends T> list);
}
