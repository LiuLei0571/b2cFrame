package com.jinqiao.b2c.project.common.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.ThreadHelper;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.SimplePresenter;
import com.jinqiao.b2c.compent.base.TempleActivity;
import com.jinqiao.b2c.compent.cdi.cmp.ActivityComponent;
import com.jinqiao.b2c.compent.helper.DeviceHelper;
import com.jinqiao.b2c.compent.helper.SPHelper;
import com.jinqiao.b2c.compent.thread.ApiCallback;
import com.jinqiao.b2c.project.common.manager.bean.Translates;
import com.jinqiao.b2c.project.common.manager.bean.TranslatesResult;

import javax.inject.Inject;

import butterknife.Bind;

import static com.jinqiao.b2c.compent.constants.Apis.translates;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class SplashActivity extends TempleActivity {
    @Bind(R.id.iamge_splash)
    ImageView mImageSplash;
    @Inject
    SimplePresenter mPresenter;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_common_splash;
    }

    @Override
    protected void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        setAnimation(false);
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        AnimationSet set = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scale.setDuration(2000);// 动画时间
        scale.setFillAfter(true);// 保持动画状态

        // 渐变动画
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(2000);// 动画时间
        alpha.setFillAfter(true);// 保持动画状态

        set.addAnimation(scale);
        set.addAnimation(alpha);
        mImageSplash.setAnimation(set);
        ThreadHelper.postMainDelay(new Runnable() {
            @Override
            public void run() {
                if (!DeviceHelper.getNetworkState() && mTranslatesString != null && mTranslatesList != null) {
                    doMainMethod();
                    finish();
                } else {
                    initData();

                }
            }
        }, 2000);
    }

    private void initData() {
        mPresenter.apiCall(translates, new ApiCallback<TranslatesResult>() {
            @Override
            public void onSuccess(IResult<TranslatesResult> result) {
                super.onSuccess(result);
                if (result.data().getTranslates() != null) {
                    Translates translates = result.data().getTranslates();
                    if (translates.getMobileStaticTextCode() != null) {
                        SPHelper.putBean("translate", translates.getMobileStaticTextCode());
                    }
                    if (translates.getOptionList() != null) {
                        SPHelper.putBean("options", translates.getOptionList());
                    }
                    doMainMethod();
                }
            }

            @Override
            public void onAfterCall() {
                super.onAfterCall();
                finish();
            }
        });
    }


}
