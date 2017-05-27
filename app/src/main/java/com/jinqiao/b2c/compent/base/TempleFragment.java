package com.jinqiao.b2c.compent.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.helper.TranslateHelper;
import com.jinqiao.b2c.compent.ui.HeadBar;
import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;
import com.jinqiao.b2c.project.common.manager.bean.OptionList;

import java.util.List;

import butterknife.Bind;

/**
 * 用途：
 * Created by milk on 17/4/19.
 * 邮箱：649444395@qq.com
 */

public abstract class TempleFragment extends BaseFragment {
    @Nullable
    @Bind(R.id.header_)
    HeadBar mHeadBar;
    protected MobileStaticTextCode mTranslatesString;
    protected OptionList mTranslatesList;

    @Override
    public void beforeViewBind(View rootView) {
        super.beforeViewBind(rootView);
        mTranslatesString =  TranslateHelper.getMobileText();
        mTranslatesList =  TranslateHelper.getMobileList();
    }

    @Override
    public void bindView(View view) {
        super.bindView(view);
        if (mHeadBar != null) {
            mHeadBar.setTitle("...");
            mHeadBar.setOnBackClick(new HeadBar.OnBackClick() {
                @Override
                public void onBackClick() {
                    onToolbarBackPress();
                }
            });
        }
    }

    public void setTitle(String title) {
        if (mHeadBar != null) {
            mHeadBar.setTitle(title);

        }
    }

    public void setTitle(int titleId) {
        if (mHeadBar != null) {
            mHeadBar.setTitle(titleId);

        }
    }

    public void setBackVisible(boolean show) {
        if (mHeadBar != null) {
            mHeadBar.setBackVisable(show);
        }

    }

    public void addText(String title, View.OnClickListener mListener) {
        if (mHeadBar != null) {
            mHeadBar.addText(title, mListener);
        }
    }

    public void addImage(int drawableId, View.OnClickListener mListenter) {
        if (mHeadBar != null) {
            mHeadBar.addImage(drawableId, mListenter);
        }
    }


    protected void onToolbarBackPress() {
        onBackPressed();
    }

    public synchronized BaseFragment setCurrentTab(int position, HomePage[] fragmentPage) {
        BaseFragment baseFragment = null;

        if (position >= 0 && position < fragmentPage.length) {
            HomePage page = fragmentPage[position];
            Class<? extends BaseFragment> cls = page.fragmentCls;
            List<Fragment> fragments = getChildFragmentManager().getFragments();
            FragmentTransaction trans = getChildFragmentManager().beginTransaction();
            if (fragments != null && fragments.size() > 0) {
                for (Fragment fragment : fragments) {
                    if (fragment == null) {
                        continue;
                    }
                    if (cls.isInstance(fragment)) {
                        baseFragment = (BaseFragment) fragment;

                        trans.attach(baseFragment);
                    } else {
                        trans.detach(fragment);
                    }
                }
            }
            if (baseFragment == null) {

                try {
                    baseFragment = cls.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (baseFragment != null) {
                    trans.add(android.R.id.tabcontent, baseFragment, page.tag);
                }
            }
            trans.commitAllowingStateLoss();
        }
        return baseFragment;
    }

    public class HomePage {
        public String tag;
        public Class<? extends BaseFragment> fragmentCls;

        public HomePage(String tag, Class<? extends BaseFragment> fragmentCls) {
            this.tag = tag;
            this.fragmentCls = fragmentCls;
        }
    }
}
