package com.jinqiao.b2c.compent.ui.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;

import com.jinqiao.b2c.R;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/19.
 * 邮箱：liulei2@aixuedai.com
 */


public class BubbleList extends ListView {
    private Context mContext;
    private BubbleDrawable bubbleDrawable;
    private float mArrowWidth;
    private float mAngle;
    private float mArrowHeight;
    private float mArrowPosition;
    private int bubbleColor;
    private boolean mArrowCenter;
    private BubbleDrawable.ArrowLocation mArrowLocation;

    public BubbleList(Context context) {
        this(context, null);
    }

    public BubbleList(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setUp();
    }


    public void initView(Context context, AttributeSet attrs) {
        mContext=context;
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.BubbleView);
            mArrowWidth = array.getDimension(R.styleable.BubbleView_arrowWidth,
                    BubbleDrawable.Builder.DEFAULT_ARROW_WITH);
            mArrowHeight = array.getDimension(R.styleable.BubbleView_arrowHeight,
                    BubbleDrawable.Builder.DEFAULT_ARROW_HEIGHT);
            mAngle = array.getDimension(R.styleable.BubbleView_bubbleRadius,
                    BubbleDrawable.Builder.DEFAULT_ANGLE);
            mArrowPosition = array.getDimension(R.styleable.BubbleView_arrowPosition,
                    BubbleDrawable.Builder.DEFAULT_ARROW_POSITION);
            bubbleColor = array.getColor(R.styleable.BubbleView_bubbleColor,
                    BubbleDrawable.Builder.DEFAULT_BUBBLE_COLOR);
            int location = array.getInt(R.styleable.BubbleView_arrowLocation, 0);
            mArrowLocation = BubbleDrawable.ArrowLocation.mapIntToValue(location);
            mArrowCenter = array.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            array.recycle();
        }
        setUpPadding();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            setUp(w, h);
        }
    }
    private void setUp(int width, int height) {
        setUp(0, width, 0, height);
    }

    private void setUp() {
        setUp(getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    private void setUp(int left, int right, int top, int bottom) {
        RectF rectF = new RectF(left, top, right, bottom);
        bubbleDrawable = new BubbleDrawable.Builder()
                .rect(rectF)
                .arrowLocation(mArrowLocation)
                .bubbleType(BubbleDrawable.BubbleType.COLOR)
                .angle(mAngle)
                .arrowHeight(mArrowHeight)
                .arrowWidth(mArrowWidth)
                .bubbleColor(bubbleColor)
                .arrowPosition(mArrowPosition)
                .arrowCenter(mArrowCenter)
                .build();
    }
    private void setUpPadding() {
        int left = getPaddingLeft();
        int right = getPaddingRight();
        int top = getPaddingTop();
        int bottom = getPaddingBottom();
        switch (mArrowLocation) {
            case LEFT:
                left += mArrowWidth;
                break;
            case RIGHT:
                right += mArrowWidth;
                break;
            case TOP:
                top += mArrowHeight;
                break;
            case BOTTOM:
                bottom += mArrowHeight;
                break;
        }
        setPadding(left, top, right, bottom);
    }
}
