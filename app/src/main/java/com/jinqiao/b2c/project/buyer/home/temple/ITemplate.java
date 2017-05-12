package com.jinqiao.b2c.project.buyer.home.temple;

import android.view.ViewGroup;

import com.jinqiao.b2c.compent.base.IAct;


/**
 * Created by yh on 2016/10/26.
 */

public interface ITemplate<M extends ITemplateModel, VH extends TemplateBaseHolder> {
    /**
     * 创建holder
     *
     * @param parent
     * @return
     */
    VH createCustomViewHolder(ViewGroup parent);

    /**
     * 视图绑定
     *
     * @param holder
     * @param model
     */
    void bindCustomViewHolder(VH holder, M model);

    /**
     * 页面恢复
     */
    void onResume(IAct act);

    void onPause(IAct act);

}
