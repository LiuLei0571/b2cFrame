package com.jinqiao.b2c.compent.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/8.
 * 邮箱：liulei2@aixuedai.com
 */


public class HeadBar   {
    private Toolbar mToolbar;

    ImageButton mToolbarBack;
    TextView mToolbarTitle;
    TextView mToolbarRightText;
    LinearLayout mRight;
    RelativeLayout mRlytToolbar;
    @Bind(R.id.line)
    View mLine;
    private OnBackClick mOnBackClick;

    public void setOnBackClick(OnBackClick onBackClick) {
        mOnBackClick = onBackClick;
    }


    public interface OnBackClick {
        void onBackClick();
    }

    public HeadBar(AppCompatActivity appCompatActivity, Toolbar toolbar) {
        appCompatActivity.setSupportActionBar(toolbar);

        ActionBar actionBar=appCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar=toolbar;
        init();
    }

    @OnClick(R.id.toolbar_back)
    public void onViewClicked() {
        if (mOnBackClick != null) {
            mOnBackClick.onBackClick();

        }
    }
    private void init(){
        mToolbarBack= (ImageButton) mToolbar.findViewById(R.id.toolbar_back);
        mToolbarTitle= (TextView) mToolbar.findViewById(R.id.toolbar_title);
        mToolbarRightText= (TextView) mToolbar.findViewById(R.id.toolbar_right_text);
        mRight= (LinearLayout) mToolbar.findViewById(R.id.toolbar_right);
        mRlytToolbar= (RelativeLayout) mToolbar.findViewById(R.id.rlyt_toolbar);
        mLine=mToolbar.findViewById(R.id.line);
    }

    public void setTitle(String name) {
        mToolbarTitle.setText(name);
    }

    public void setTitle(int stringId) {
        mToolbarTitle.setText(stringId);
    }

    public void setBackVisable(boolean showBack) {
        if (showBack) {
            mToolbarBack.setVisibility(VISIBLE);
        } else {
            mToolbarBack.setVisibility(GONE);
        }
    }

    public ImageButton addImage(int drawable, View.OnClickListener listener) {
        ImageButton imageView = null;
        if (mRight != null) {
            imageView = new ImageButton(mToolbar.getContext());
            imageView.setImageResource(drawable);
            imageView.setOnClickListener(listener);
            imageView.setBackgroundResource(R.drawable.item_selector);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setPadding(getPx(10), 0, getPx(10), 0);
            mRight.addView(imageView);
        }
        return imageView;
    }


    public TextView addText(int text, View.OnClickListener listener) {
        return addText(UIHelper.getString(text), listener);
    }


    private int getPx(int dp) {
        float mDensity =mToolbar. getResources().getDisplayMetrics().density;
        return (int) (mDensity * dp);
    }

    public TextView addText(String text, View.OnClickListener listener) {
        TextView textView = null;
        if (mRight != null) {
            textView = new TextView(mToolbar.getContext());
            textView.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            textView.setMinWidth(getPx(44));
            textView.setPadding(getPx(15), 0, getPx(15), 0);
            textView.setGravity(Gravity.CENTER);
            textView.setText(text);
            textView.setTextColor(mToolbar.getResources().getColor(R.color.color_text_major));
            textView.setOnClickListener(listener);
            textView.setBackgroundResource(R.drawable.item_selector);
            mRight.addView(textView);
        }
        return textView;
    }
}
