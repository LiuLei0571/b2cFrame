package com.jinqiao.b2c.compent.ui.popup;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.compent.helper.Util;

import java.util.List;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/5.
 * 邮箱：liulei2@aixuedai.com
 */

public class PopupWindowsUtil {

    public interface CallBack {
        void onClick(int position, Object... objects);
    }


    public static PopupWindow showListPopupWindows(Context context, List<String> list, List<Integer> icons, final CallBack callBack, View downView) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_list, null, false);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);

        popupWindow.setAnimationStyle(R.style.PopupNoAnim);
        ListView listView = (ListView) view.findViewById(R.id.popup_list_view);
        listView.setAdapter(new PopupListAdapter(context, list, icons, Gravity.CENTER));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                callBack.onClick(position);
                popupWindow.dismiss();
            }
        });
        popupWindow.showAsDropDown(downView);
        return popupWindow;
    }


    public static class PopupListAdapter extends BaseAdapter {
        Context context;
        List<String> lists;
        int gravity;
        List<Integer> icons;

        public PopupListAdapter(Context context, List<String> lists, List<Integer> icons, int gravity) {
            this.context = context;
            this.lists = Util.cutNull(lists);
            this.gravity = gravity;
            this.icons = Util.cutNull(icons);
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public String getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.popup_list_item, parent, false);
                holder.textView = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(getItem(position));
            if (!icons.isEmpty() && icons.get(position) != null) {
                Drawable drawable = UIHelper.getDrawable(icons.get(position));
                assert drawable != null;
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                holder.textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            }
            return convertView;
        }

        class ViewHolder {
            public TextView textView;
        }

    }

    public static Animation getTranAnimation(Context mContext) {
        Animation trantAnimation = AnimationUtils.loadAnimation(mContext, R.anim.popup_bottom_enter);
        return trantAnimation;
    }
}
