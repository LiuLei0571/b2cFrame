package com.jinqiao.b2c.compent.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.UIHelper;
import com.jinqiao.b2c.compent.helper.Util;


/**
 * @author Created by yh on 2016/5/18.
 */
public class SendSmsSimpleButton extends Button {

    private Paint paint;
    private boolean hasLine = true;

    public SendSmsSimpleButton(Context context) {
        this(context, null);
    }

    public SendSmsSimpleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SendSmsSimpleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SendSmsSimpleButton);
        hasLine = mTypedArray.getBoolean(R.styleable.SendSmsSimpleButton_hasLine, true);
        mTypedArray.recycle();
        setGravity(Gravity.CENTER);
        init();
    }

    private void init() {
        if (hasLine) {
            paint = new Paint();
        }
        setPhone("");
    }

    public void setPhone(String phone) {
        boolean enable = !TextUtils.isEmpty(phone) && phone.length() == 11;
        setState(enable);
    }

    public void setEmail(String email){
        boolean enable= Util.isEmail(email);
        setState(enable);
    }
    /**
     * 更新按钮状态
     */
    private void setState(boolean enable) {
        if (enable) {
            setTextColor(UIHelper.getColor(R.color.color_btn_major));
        } else {
            setTextColor(UIHelper.getColor(R.color.white));
        }
        setEnabled(enable);
    }

    /**
     * 状态改变重新设置属性
     */
    public void setState(String text, boolean enabled) {
        setText(text);
        setState(enabled);
    }

    public void setState(String text, int textNormalColor, int selectedColor, boolean enabled) {
        setText(text);
        if (enabled) {
            setTextColor(textNormalColor);
        } else {
            setTextColor(selectedColor);
        }
        setEnabled(enabled);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (paint == null) {
            return;
        }
        paint.setAntiAlias(true);                 //消除锯齿
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.LTGRAY);             //设置画笔颜色
        paint.setStrokeWidth((float) 1.0);        //设置线宽
        canvas.drawLine(0, 10, 0, getMeasuredHeight() - 10, paint);     //绘制直线
    }


}
