package com.jinqiao.b2c.compent.ui.bubbleview;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.jinqiao.b2c.compent.helper.UIHelper;


/**
 * Created by lgp on 2015/3/24.
 * https://github.com/lguipeng/BubbleView
 */
public class BubbleAnimViewGroup extends FrameLayout {

    private Context mContext;
    private WindowManager windowManager;

    public BubbleAnimViewGroup(Context context) {
        this(context, null);
    }

    public BubbleAnimViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleAnimViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setPadding(0, 0, 0, 0);
        addFloatView();
    }

    public void addFloatView() {
        //获取LayoutParams对象
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.format = PixelFormat.TRANSLUCENT;// 不设置这个弹出框的透明遮罩显示为黑色
        // 设置Window flag
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        // 调整悬浮窗口至右下角，便于调整坐标
        params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // 以屏幕右下角为原点，设置x、y初始值
        params.x = UIHelper.dip2px(mContext, 16);
        params.y = UIHelper.dip2px(mContext, 42.5f);
        params.horizontalMargin = 0;
        params.verticalMargin = 0;
        // 设置悬浮窗口长宽数据
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 显示View
        if (mContext instanceof Activity) {
            windowManager = ((Activity) mContext).getWindowManager();
            windowManager.addView(this, params);
        }
    }

    public void removeFloatView() {
        if (windowManager != null) {
            try {
                windowManager.removeView(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
