package com.jinqiao.b2c.project.buyer.home.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;

import com.jinqiao.b2c.compent.base.BaseHolder;
import com.jinqiao.b2c.compent.base.BaseRecyclerAdapter;
import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.project.buyer.home.temple.ITemplate;
import com.jinqiao.b2c.project.buyer.home.temple.ITemplateModel;
import com.jinqiao.b2c.project.buyer.home.temple.TemplateBaseHolder;
import com.jinqiao.b2c.project.buyer.home.temple.Templates;


/**
 * @author Created milk yh on 2016/10/26
 */
public class TemplateRecyclerAdapterNew extends BaseRecyclerAdapter<ITemplateModel, TemplateBaseHolder> {
    private SparseArray<ITemplate> makerInstances;
    private IAct act;

    public TemplateRecyclerAdapterNew(IAct act) {
        super(act.getContext());
        this.act = act;
        makerInstances = new SparseArray<>();
    }

    private ITemplate getTemplateMakerByType(int viewType) {
        ITemplate instance = makerInstances.get(viewType);
        if (instance == null) {
            instance = Templates.makeInstance(act, viewType);
            makerInstances.put(viewType, instance);
        }
        return instance;
    }


    @Override
    public TemplateBaseHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        ITemplate makeInstance = getTemplateMakerByType(viewType);
        return makeInstance.createCustomViewHolder(parent);
    }

    @Override
    public int getCustomViewType(int position) {
        ITemplateModel item = getItem(position);
        if (item != null) {
            Templates template = item.getTemplate();
            if (template != null) {
                return template.getLocalViewType();
            }
        }
        return super.getCustomViewType(position);
    }

    @Override
    public void bindCustomViewHolder(TemplateBaseHolder holder, int position) {
        ITemplateModel item = getItem(position);
        int viewType = getItemViewType(position);
        ITemplate makeInstance = getTemplateMakerByType(viewType);
        if (makeInstance != null && item != null) {
            makeInstance.bindCustomViewHolder(holder, item);
        }
    }

    @Override
    public void onViewRecycled(BaseHolder holder) {
        if (holder instanceof TemplateBaseHolder) {
            TemplateBaseHolder templateBaseHolder = (TemplateBaseHolder) holder;
            templateBaseHolder.onViewRecycled();
        } else {
            super.onViewRecycled(holder);
        }
    }
}