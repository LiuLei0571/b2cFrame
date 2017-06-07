package com.jinqiao.b2c.compent.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/5.
 * 邮箱：liulei2@aixuedai.com
 */


public class CustomButton extends AppCompatTextView {
    //默认的颜色
    private int defaultColor;
    //可点击高亮的颜色
    private int pressColor;
    //不可点击的颜色
    private int dismisColor;

    //文字颜色
    private int textColor;
    //不可点击的颜色
    private int dismisTextColor;

    //是否点击水波纹
    private boolean isRipple;
    //颜色计算比例
    private float parameter;

    private Context mContext;
    //边宽的宽度
    private int strokeWidth;
    //边宽的颜色
    private int strokeColor;
    //边宽的选择色
    private int selectStrokeColor;

    private float radius;

    private float topLeftRadius;

    private float topRightRadius;

    private float bottomLeftRadius;

    private float bottomRightRadius;

    public CustomButton(Context context) {
        this(context, null);

    }

    public CustomButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        setGravity(Gravity.CENTER);
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.BtnButton);
        isRipple = typedArray.getBoolean(R.styleable.BtnButton_ripple, true);
        parameter = typedArray.getFloat(R.styleable.BtnButton_parameter, 0.2f);
        radius = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_radius, 0);
        topLeftRadius = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_TopLeftRadius, 0);
        topRightRadius = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_TopRightRadius, 0);
        bottomLeftRadius = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_BottomLeftRadius, 0);
        bottomRightRadius = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_BottomLeftRadius, 0);

        defaultColor = typedArray.getColor(R.styleable.BtnButton_defaultColor, UIHelper.getColor("#44B0A0"));
        pressColor = typedArray.getColor(R.styleable.BtnButton_pressColor, UIHelper.getColor("#3A9F90"));
        textColor = typedArray.getColor(R.styleable.BtnButton_defaultColor, UIHelper.getColor("#ffffff"));
        dismisTextColor = typedArray.getColor(R.styleable.BtnButton_dismissTextColor, UIHelper.getColor("#60E7E9"));

        strokeColor = typedArray.getColor(R.styleable.BtnButton_strokeColor, 0);
        selectStrokeColor = typedArray.getColor(R.styleable.BtnButton_selectStrokeColor, 0);
        strokeWidth = typedArray.getDimensionPixelOffset(R.styleable.BtnButton_strokeWidth, 0);
        typedArray.recycle();
        if (dismisTextColor != 0) {
            setTextColor(dismisColor);
        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setTextColor(defaultColor);
        } else {
            if (dismisTextColor != 0) {
                setTextColor(dismisColor);
            }
        }
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshDrawable();
    }

    private void refreshDrawable() {
        Drawable colorDrawable = getColorDrawable();
        if (colorDrawable != null) {
            this.setBackgroundDrawable(colorDrawable);
        }
    }

    @Override
    public void postInvalidate() {
        refreshDrawable();
        super.postInvalidate();
    }


    private Drawable getColorDrawable() {
        if (!isEnabled()) {
            return getGradientDrawable(dismisColor, 0.2D);
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP && isRipple) {
            ColorStateList pressedColorDw = ColorStateList.valueOf(pressColor);
            return new RippleDrawable(pressedColorDw, getGradientDrawable(0, 0), getShape());
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, getGradientDrawable(pressColor, parameter));
            stateListDrawable.addState(new int[]{android.R.attr.state_focused}, getGradientDrawable(pressColor, parameter * 2));
            stateListDrawable.addState(new int[]{}, getGradientDrawable(0, 0));
            return stateListDrawable;
        }
    }

    private Drawable getGradientDrawable(int color, double parameter) {
        GradientDrawable dw = new GradientDrawable();
        if (parameter == 0) {
            if (strokeWidth != 0) {
                dw.setStroke(strokeWidth, strokeColor == 0 ? Color.TRANSPARENT : strokeColor);
            }
            if (defaultColor != 0) {
                dw.setColor(defaultColor);
            }
        } else {
            if (strokeWidth != 0) {
                dw.setStroke(strokeWidth, selectStrokeColor == 0 ? strokeColor == 0 ? Color.TRANSPARENT : strokeColor : selectStrokeColor);
            }
            if (color == 0) {
                dw.setColor(getLightOrDarken(defaultColor, parameter));
            } else {
                dw.setColor(color);
            }
        }
        if (radius != 0) {
            dw.setCornerRadius(radius);
        } else if (topLeftRadius != 0 || topRightRadius != 0 || bottomRightRadius != 0 || bottomLeftRadius != 0) {
            dw.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
        }
        return dw;
    }

    private Drawable getShape() {
        ShapeDrawable mask = new ShapeDrawable(new RectShape() {
            @Override
            public void draw(Canvas canvas, Paint paint) {
                final float width = this.getWidth();
                final float height = this.getHeight();
                RectF rectF = new RectF(0, 0, width, height);
                if (radius != 0) {
                    canvas.drawRoundRect(rectF, radius, radius, paint);
                } else if (topLeftRadius != 0 || topRightRadius != 0 || bottomRightRadius != 0 || bottomLeftRadius != 0) {
                    Path path = new Path();
                    path.addRoundRect(rectF, new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius}, Path.Direction.CW);
                    canvas.drawPath(path, paint);
                } else {
                    canvas.drawRect(rectF, paint);
                }
            }
        });
        return mask;
    }

    /**
     * 单色变暗
     */
    private int darkenColor(int color, double parameter) {
        return (int) Math.max(color - color * parameter, 0);
    }

    /**
     * 颜色变暗
     */
    private int darkenColors(int color, double parameter) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = darkenColor(red, parameter);
        green = darkenColor(green, parameter);
        blue = darkenColor(blue, parameter);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * 单色变亮
     */
    private int lightColor(int color, double parameter) {
        return (int) Math.min(color + color * parameter, 255);
    }

    /**
     * 颜色变亮
     */
    private int lightColors(int color, double parameter) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = lightColor(red, parameter);
        green = lightColor(green, parameter);
        blue = lightColor(blue, parameter);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * 判断颜色 变亮或变暗
     */
    private boolean isLightOrDarken(int color, double parameter) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return red + (red * parameter) < 255 && green + (green * parameter) < 255 && blue + (blue * parameter) < 255;
    }

    /**
     * 获取变亮或变暗颜色
     */
    private int getLightOrDarken(int color, double parameter) {
        parameter = parameter < 0 ? 0 : parameter > 1 ? 1 : parameter;
        if (isLightOrDarken(color, parameter)) {
            return lightColors(color, parameter);
        } else {
            return darkenColors(color, parameter);
        }
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
        postInvalidate();
    }

    public void setPressColor(int pressColor) {
        this.pressColor = pressColor;
        postInvalidate();

    }

    @Override
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        postInvalidate();

    }

    public void setDismisTextColor(int dismisTextColor) {
        this.dismisTextColor = dismisTextColor;
        postInvalidate();

    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        postInvalidate();

    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        postInvalidate();

    }

    public void setSelectStrokeColor(int selectStrokeColor) {
        this.selectStrokeColor = selectStrokeColor;
        postInvalidate();

    }

    public void setRadius(float radius) {
        this.radius = radius;
        postInvalidate();

    }
}
