package com.jinqiao.b2c.compent.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinqiao.b2c.common.statusBarNew.ImmersionBar;
import com.jinqiao.b2c.compent.cdi.CDI;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.event.EmptyEvent;
import com.jinqiao.b2c.compent.helper.EventHelper;
import com.jinqiao.b2c.compent.helper.HttpHelper;
import com.jinqiao.b2c.compent.helper.LoadingHelper;
import com.jinqiao.b2c.compent.helper.TranslateHelper;
import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;
import com.jinqiao.b2c.project.common.manager.bean.OptionList;

import butterknife.ButterKnife;

/**
 * 用途：
 * Created by milk on 17/4/17.
 * 邮箱：649444395@qq.com
 */

public abstract class BaseFragment extends Fragment implements IFragment, ILoading {
    private BaseActivity mActivity;
    private PresenterConnector mPresenterConnector;
    private FragmentComponent mFragmentComponent;
    private View mView;
    protected MobileStaticTextCode mTranslatesString;
    protected OptionList mTranslatesList;
    protected ImmersionBar mImmersionBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mFragmentComponent == null) {
            mFragmentComponent = CDI.createFragmentComponent(this);
        }
        doInject(mFragmentComponent);
        if (mPresenterConnector == null) {
            mPresenterConnector = new PresenterConnector();
        }
        EventHelper.register(this);
    }
   public void initImmersionBar(){
       mImmersionBar=ImmersionBar.with(this);
       mImmersionBar.keyboardEnable(true).init();
   }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView != null) {
            return mView;
        }
        mView = inflater.inflate(getRootViewId(), container, false);

        beforeViewBind(mView);
        bindView(mView);
        afterViewBind(savedInstanceState);
        mPresenterConnector.bindPresenter(savedInstanceState, getArguments());
        return mView;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mView != null) {
            mView.setFocusableInTouchMode(true);
            mView.requestFocus();
            mView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (initBackPress() && keyCode == KeyEvent.KEYCODE_BACK &&
                            event.getAction() == KeyEvent.ACTION_UP) {
                        onBackPressed();
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    protected void onBackPressed() {
    }

    protected boolean initBackPress() {
        return false;
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        HttpHelper.cancelGroup(groupName());
        if (mPresenterConnector != null) {
            mPresenterConnector.destory();
            mPresenterConnector = null;
        }
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
        unBindView();
        if (mView != null) {
            ViewGroup viewGroup = (ViewGroup) mView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mView);
            }
            mView = null;
        }
        EventHelper.unRegister(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenterConnector != null) {
            mPresenterConnector.onSaveInstanceState_(outState);
        }
    }

    @Override
    public void beforeViewBind(View rootView) {
        mTranslatesString = TranslateHelper.getMobileText();
        mTranslatesList = TranslateHelper.getMobileList();
    }

    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public View findViewId(int id) {
        if (mView != null) {
            return mView.findViewById(id);
        }
        return null;
    }

    @Override
    public void savePresenter(BasePresenter presenter) {
        if (mPresenterConnector != null) {
            mPresenterConnector.savePresenter(presenter);
        }
    }


    @Override
    public void afterViewBind(Bundle saveInstanceState) {

    }

    @Override
    public void unBindView() {
        ButterKnife.unbind(this);
    }

    @Override
    public String groupName() {
        return getClass().getSimpleName() + this.toString();
    }

    @Override
    public BaseActivity getBaseActivity() {
        if (mActivity == null) {
            mActivity = (BaseActivity) getActivity();
        }
        return mActivity;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void showLoading() {
        LoadingHelper.showLoading(getBaseActivity());
    }

    @Override
    public void showLoading(String content) {
        LoadingHelper.showLoading(getBaseActivity(), content);

    }

    @Override
    public void dismissLoading() {
        LoadingHelper.dismiss();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mPresenterConnector != null) {
            mPresenterConnector.onActivityForResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVistiAble();
        } else {
            onGone();
        }
    }

    private void onVistiAble() {
    }

    protected void onGone() {

    }

    public void onEvent(EmptyEvent event) {
    }

    protected abstract int getRootViewId();

}

