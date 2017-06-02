package com.jinqiao.b2c.compent.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/31.
 * 邮箱：liulei2@aixuedai.com
 */


public abstract class BaseExpandableAdapter<T, H> extends BaseExpandableListAdapter implements IPageAdapter<T> {
    private int childViewId;
    private int groupViewId;
    private List<T> mGroupData;
    private List<H> mChildData;
    private Context mContext;

    public BaseExpandableAdapter(Context context) {
        mContext = context;
    }

    public BaseExpandableAdapter(Context context, int groupViewId, int childViewId) {
        this(context);
        this.childViewId = childViewId;
        this.groupViewId = groupViewId;
        mContext = context;
        mGroupData = new ArrayList<T>();
        mChildData = new ArrayList<H>();
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public void clear() {
        mGroupData.clear();
        mChildData.clear();
        notifyDataSetInvalidated();
    }

    @Override
    public void addAll(Collection<? extends T> list) {
        mGroupData.addAll(list);
    }

    public void addAll(T[] items) {
        mGroupData.addAll(Arrays.asList(items));
    }

    public int getChildViewId() {
        return childViewId;
    }

    public void setChildViewId(int childViewId) {
        this.childViewId = childViewId;
    }

    public void setGroupViewId(int groupViewId) {
        this.groupViewId = groupViewId;
    }

    public int getGroupViewId() {
        return groupViewId;
    }

    @Override
    public int getCount() {
        return mGroupData.size();
    }

    @Override
    public int getGroupCount() {
        return mGroupData.size();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public T getGroup(int groupPosition) {
        if (groupPosition >= 0 && mGroupData.size() > 0) {
            return mGroupData.get(groupPosition);
        } else {
            return null;
        }
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHoldFactory viewHolder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            int viewId = getGroupViewId();
            convertView = layoutInflater.inflate(viewId, parent, false);
            viewHolder = new GroupViewHoldFactory(convertView, this);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GroupViewHoldFactory) convertView.getTag();
        }
        renderGroupView(viewHolder, isExpanded, groupPosition);
        return convertView;
    }

    protected abstract void renderGroupView(GroupViewHoldFactory viewHolder, boolean isExpanded, int groupPosition);

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        T item = getGroup(groupPosition);

        ChildViewHoldFactory viewHolder = null;
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        int viewId = getChildViewId();
        convertView = layoutInflater.inflate(viewId, parent, false);
        viewHolder = new ChildViewHoldFactory(convertView, this);
        convertView.setTag(viewHolder);
        renderChildView(viewHolder, childPosition,item);
        return convertView;
    }


    protected abstract void renderChildView(ChildViewHoldFactory viewHolder, int childPosition, T item);

    public static class GroupViewHoldFactory {
        private View contentView;
        private BaseExpandableAdapter mBaseExpandableAdapter;
        public SparseArray<View> views;

        public GroupViewHoldFactory(View contentView, BaseExpandableAdapter baseExpandableAdapter) {
            this.contentView = contentView;
            mBaseExpandableAdapter = baseExpandableAdapter;
            views = new SparseArray<>();
        }

        public <T extends View> T findViewById(int viewId) {
            return findViewById(viewId, null);
        }

        public <T extends View> T findViewById(int viewId, InitViewListener listener) {
            T view = (T) views.get(viewId);
            if (view == null) {
                view = (T) contentView.findViewById(viewId);
                views.put(viewId, view);
                if (listener != null) {
                    listener.firstInitView(view);
                }
            }
            return view;
        }

        public View getContentView() {
            return contentView;
        }

        public Context getViewContext() {
            return contentView.getContext();
        }

        public BaseExpandableAdapter getBaseExpandableAdapter() {
            return mBaseExpandableAdapter;
        }
    }

    public static class ChildViewHoldFactory {
        private View contentView;
        private BaseExpandableAdapter mBaseExpandableAdapter;
        public SparseArray<View> views;

        public ChildViewHoldFactory(View contentView, BaseExpandableAdapter baseExpandableAdapter) {
            this.contentView = contentView;
            mBaseExpandableAdapter = baseExpandableAdapter;
            views = new SparseArray<>();

        }

        public <T extends View> T findViewById(int viewId) {
            return findViewById(viewId, null);
        }

        public <T extends View> T findViewById(int viewId, InitViewListener listener) {
            T view = (T) views.get(viewId);
            if (view == null) {
                view = (T) contentView.findViewById(viewId);
                views.put(viewId, view);
                if (listener != null) {
                    listener.firstInitView(view);
                }
            }
            return view;
        }

        public View getContentView() {
            return contentView;
        }

        public Context getViewContext() {
            return contentView.getContext();
        }

        public BaseExpandableAdapter getBaseExpandableAdapter() {
            return mBaseExpandableAdapter;
        }
    }

    public interface InitViewListener {
        void firstInitView(View view);
    }
}
