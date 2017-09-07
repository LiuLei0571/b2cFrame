package com.jinqiao.b2c.compent.helper;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;

import com.jinqiao.b2c.compent.base.IAct;
import com.jinqiao.b2c.compent.base.LoginControl;
import com.jinqiao.b2c.compent.constants.Extras;
import com.jinqiao.b2c.project.buyer.login.activity.LoginActivity;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/2.
 * 邮箱：liulei2@aixuedai.com
 */


public class LoginHelper {
    public static final int EMPTY_ACT = 0;
    public static final int REQUEST_CODE = 900;

    private static SparseArray<Object> passThoughMap = new SparseArray<>();

    private static void setPassThough(int actionId, Object passThough) {
        passThoughMap.put(actionId, passThough);
    }

    private static <T> T readPassThough(int actionId) {
        T result = null;
        try {
            result = (T) passThoughMap.get(actionId);
        } catch (Exception e) {
        }
        passThoughMap.remove(actionId);
        return result;
    }

    public static void startLogin(IAct iAct, LoginControl loginControl, int actId, Object passThough) {
        Intent intent = new Intent(iAct.getContext(), LoginActivity.class);
        if (loginControl != null) {
            intent.putExtra(Extras.LOGIN.key.CONTROL, loginControl);
        }
        if (actId != EMPTY_ACT) {
            intent.putExtra(Extras.ACTION_ID, actId);
        }
        iAct.startActivityForResult(intent, REQUEST_CODE);
        setPassThough(actId, passThough);
    }

    public static void startLogin(IAct iAct, LoginControl loginControl, LoginListener loginListener) {
        startLogin(iAct, loginControl, EMPTY_ACT, loginListener);
    }

    public static void startLogin(IAct iAct) {
        startLogin(iAct, null, EMPTY_ACT, null);
    }

    public static void startLogin(IAct iAct, LoginListener loginListener) {
        startLogin(iAct, null, EMPTY_ACT, loginListener);
    }

    public static <T> boolean doResult(int requestCode, int resultCode, Intent data,
                                       LoginListener<T> loginListener) {
        if (requestCode == REQUEST_CODE) {
            int actId = data != null ? data.getIntExtra(Extras.ACTION_ID, EMPTY_ACT) : EMPTY_ACT;
            T passThough = readPassThough(actId);
            if (loginListener == null) {
                if (passThough != null && passThough instanceof LoginListener) {
                    loginListener = (LoginListener<T>) passThough;
                }
            }
            if (loginListener != null) {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    loginListener.onLoginSuccess(actId, passThough);
                    return true;
                }
                loginListener.onLoginFail(actId, passThough);
            }
            return true;
        }
        return false;
    }

    public interface LoginListener<T> {
        void onLoginSuccess(int actionId, T passThough);

        void onLoginFail(int actionId, Object passThough);
    }
}
