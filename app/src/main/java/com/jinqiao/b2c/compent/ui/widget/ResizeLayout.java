package com.jinqiao.b2c.compent.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.jinqiao.b2c.R;


public class ResizeLayout extends FrameLayout {

    private int mRatioWidth = 1;
    private int mRatioHeight = 1;

    public ResizeLayout(Context context) {
        super(context);
        init(null, 0);
    }

    public ResizeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ResizeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ResizeLayout, defStyle, 0);

        mRatioWidth = a.getInt(
                R.styleable.ResizeLayout_resizewidth, 1);
        mRatioHeight = a.getInt(
                R.styleable.ResizeLayout_resizeheight,
                1);

        a.recycle();

    }


    public void setRatio(int width, int height) {
        if (this.mRatioHeight == height && this.mRatioWidth == width) {
            return;
        }
        this.mRatioHeight = height;
        this.mRatioWidth = width;
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * mRatioHeight / mRatioWidth;
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
    }


}
