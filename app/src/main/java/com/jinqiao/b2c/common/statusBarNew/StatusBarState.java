package com.jinqiao.b2c.common.statusBarNew;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by LuckyCrystal on 2017/8/2.
 *
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        StatusBarState.NO_INIT, StatusBarState.TOOLBAR_VIEW, StatusBarState.NORMAL_VIEW,
        StatusBarState.NO_VIEW,  StatusBarState.NO_VIEW_COLOR_STATUS, StatusBarState.FULLSCREEN,
       StatusBarState.NORMAL_COLOR_VIEW
})
public @interface StatusBarState {
    int NO_INIT = -1;
    int TOOLBAR_VIEW = 0;
    int NORMAL_VIEW = 1;
    int NO_VIEW = 2;
    int NO_VIEW_COLOR_STATUS = 3;
    int FULLSCREEN = 4;
    int NORMAL_COLOR_VIEW = 5;
}