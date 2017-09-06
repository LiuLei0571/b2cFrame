package com.jinqiao.b2c.project.buyer.login.presenter;

import android.os.Bundle;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.BasePresenter;
import com.jinqiao.b2c.compent.base.IView;
import com.jinqiao.b2c.compent.helper.SendSmsTimerHelper;
import com.jinqiao.b2c.compent.helper.ToastHelper;
import com.jinqiao.b2c.compent.helper.Util;
import com.jinqiao.b2c.compent.thread.ApiTask;
import com.jinqiao.b2c.project.buyer.login.module.manager.UserManager;

import javax.inject.Inject;

/**
 * 用途：
 * 作者：Created by liulei on 17/9/6.
 * 邮箱：liulei2@aixuedai.com
 */


public class AutoCodePresenter extends BasePresenter<AutoCodePresenter.AuthCodeAct> {
    SendSmsTimerHelper sendSmsTimer;
    @Inject
    UserManager mUserManager;
    /**
     * 是否需要外发短信
     */
    private boolean needOutSms = false;
    private SendSmsTimerHelper.UiUpdateListener listener;

    @Inject
    public AutoCodePresenter(IView iView) {
        super(iView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        listener = new SendSmsTimerHelper.UiUpdateListener() {
            @Override
            public void onUIUpdate(int left) {
                updateOnMain(left);
            }
        };
        sendSmsTimer = SendSmsTimerHelper.getInstance();
        sendSmsTimer.addListener(listener);
    }

    @Override
    public void onDestroy() {
        if (sendSmsTimer != null) {
            sendSmsTimer.removeListener(listener);
            sendSmsTimer = null;
        }
    }

    @Override
    protected void onPause() {
        if (sendSmsTimer != null) {
            sendSmsTimer.reset();//重置定时器
        }
    }

    public void sedMsg(String email, String type) {
        submitTask(new ApiTask<IResult<String>>() {
            @Override
            public IResult<String> onBackGround() throws Exception {
                return mUserManager.getEmail(email, type);

            }

            @Override
            public void onSuccess(IResult<IResult<String>> result) {
                super.onSuccess(result);
                ToastHelper.makeToast("获取成功");
                sendSmsTimer.start();
            }
        });
    }

    public void updateOnMain(int mLeft) {
        if (needOutSms) {
            setText(R.string.common_sms_send_out, true);
            return;
        }
        if (mLeft > 0) {
            setText(getString(R.string.common_sms_send_wait, mLeft), false);
        } else {
            boolean flag = false;
            if (isEmailNumber(getEmail())) {
                flag = true;
            }
            setText(R.string.common_sms_get_code, flag);
        }
    }

    private boolean isEmailNumber(String email) {
        if (Util.isEmail(email)) {
            return true;
        } else {
            return false;
        }
    }

    private String getEmail() {
        String email = getView().getEmail();
        if (email != null) {
            return email.replace(" ", "");
        }
        return email;
    }

    private void setText(int textId, boolean enable) {
        getView().setText(getString(textId), enable);
    }

    private void setText(String text, boolean enable) {
        getView().setText(text, enable);
    }

    public interface AuthCodeAct extends IView {
        /**
         * 设置按钮状态
         *
         * @param text
         * @param enabled
         */
        void setText(String text, boolean enabled);

        /**
         * 是否需要外送短信
         *
         * @param needOutSend
         */
        void setNeedOutSend(boolean needOutSend);

        /**
         * 取得手机号
         *
         * @return
         */
        String getPhone();

        String getEmail();
    }

}
