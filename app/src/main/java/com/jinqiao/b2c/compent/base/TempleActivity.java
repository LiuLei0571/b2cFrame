package com.jinqiao.b2c.compent.base;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.compent.constants.Extras;
import com.jinqiao.b2c.compent.helper.TranslateHelper;
import com.jinqiao.b2c.compent.helper.UserHelper;
import com.jinqiao.b2c.compent.ui.HeadBar;
import com.jinqiao.b2c.project.buyer.home.activity.BuyerHomeActivity;
import com.jinqiao.b2c.project.common.manager.bean.MobileStaticTextCode;
import com.jinqiao.b2c.project.common.manager.bean.OptionList;
import com.jinqiao.b2c.project.express.home.activity.ExpressHomeActivity;
import com.jinqiao.b2c.project.logistics.home.activity.LogisticsHomeActivity;
import com.jinqiao.b2c.project.seller.home.activity.SellerHomeActivity;

import java.util.List;

import butterknife.Bind;

/**
 * 用途：
 * Created by milk on 17/4/19.
 * 邮箱：649444395@qq.com
 */

public abstract class TempleActivity extends BaseActivity {
    @Nullable

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

    protected void doMainMethod() {
        if (UserHelper.getType()==1 ) {
            /**
             * 获取卖家商家信息的注册步揍，没有注册完，就重新填写
             */
            if (UserHelper.getUserFromLocal().getStep() != Extras.SELLERSTEPTHIRD ) {
                Intent intent = new Intent(this,SellerHomeActivity.class);
                intent.putExtra("type", Extras.LAUNCH);
                startActivity(intent);
            } else {
                //卖家首页
                startActivity(new Intent(getApplication(), SellerHomeActivity.class));
            }
        } else if (UserHelper.getType() == 2) {
            //物流首页
            startActivity(new Intent(getApplication(), LogisticsHomeActivity.class));
        } else if (UserHelper.getType() == 3) {
            //快递小哥首页
            startActivity(new Intent(getApplicationContext(), ExpressHomeActivity.class));
        } else {
            //买家首页
            startActivity(new Intent(getApplication(), BuyerHomeActivity.class));
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
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
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
