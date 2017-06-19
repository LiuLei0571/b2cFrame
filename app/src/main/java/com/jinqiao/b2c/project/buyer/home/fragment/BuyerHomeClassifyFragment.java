package com.jinqiao.b2c.project.buyer.home.fragment;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.http.IResult;
import com.jinqiao.b2c.compent.base.SimplePresenter;
import com.jinqiao.b2c.compent.base.TempleFragment;
import com.jinqiao.b2c.compent.cdi.cmp.FragmentComponent;
import com.jinqiao.b2c.compent.constants.Apis;
import com.jinqiao.b2c.compent.thread.ApiCallback;
import com.jinqiao.b2c.project.buyer.home.adapter.ClassifyExpandListAdapterNew;
import com.jinqiao.b2c.project.buyer.home.manager.bean.CategoryFirstListResult;
import com.jinqiao.b2c.project.buyer.home.manager.bean.FirstCategoryDetail;
import com.jinqiao.b2c.project.buyer.home.manager.bean.TransCategory;
import com.jinqiao.b2c.project.buyer.home.manager.bean.TransFirstCategory;
import com.jinqiao.b2c.project.buyer.home.manager.bean.TransSecondCategory;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

import static com.jinqiao.b2c.R.id.elv_classify;

/**
 * 用途：
 * 作者：Created by liulei on 17/5/11.
 * 邮箱：liulei2@aixuedai.com
 */


public class BuyerHomeClassifyFragment extends TempleFragment {
    @Bind(elv_classify)
    ExpandableListView mElvClassify;
    private List<FirstCategoryDetail> categoryList;
    @Inject
    SimplePresenter mPresenter;
    ClassifyExpandListAdapterNew adapter;

    @Override
    public void doInject(FragmentComponent component) {
        component.plus(this);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_buyer_classify;
    }

    @Override
    public void afterViewBind(Bundle saveInstanceState) {
        super.afterViewBind(saveInstanceState);
        setTitle(mTranslatesString.getCommon_sampleclassify());
        setBackVisible(false);
        mPresenter.apiCall(Apis.homeClassifty, new ApiCallback<CategoryFirstListResult>() {
            @Override
            public void onSuccess(IResult<CategoryFirstListResult> result) {
                super.onSuccess(result);
                if (result.data() != null) {
                    categoryList = result.data().getFirstCategory();
                    adapter.addAll(getData());
                }
            }

            @Override
            public void onFailure(IResult<String> result) {
            }
        });
        adapter = new ClassifyExpandListAdapterNew(getContext());
        mElvClassify.setAdapter(adapter);

    }

    public List<TransFirstCategory> getData() {// 由于分类使用的是二级扩展目录，而传回的是三级目录，所以将三级目录转换为二级目录进行显示，同时将目录的值也做复制
        TransCategory transCategory = new TransCategory();
        for (int i = 0; i < categoryList.size(); i++) {
            TransFirstCategory tempFirstData = new TransFirstCategory();
            tempFirstData.setId(categoryList.get(i).getId());
            tempFirstData.setName(categoryList.get(i).getName());
            tempFirstData.setIdPath(categoryList.get(i).getIdPath());
            tempFirstData.setCategoryLevel(categoryList.get(i).getCategoryLevel());
            for (int j = 0; j < categoryList.get(i).getSecondCategoryList()
                    .size(); j++) {
                TransSecondCategory tempSecondData = new TransSecondCategory();
                tempSecondData.setId(categoryList.get(i).getSecondCategoryList()
                        .get(j).getId());
                tempSecondData.setName(categoryList.get(i)
                        .getSecondCategoryList().get(j).getName());
                tempSecondData.setCategoryLevel(categoryList.get(i)
                        .getSecondCategoryList().get(j).getCategoryLevel());
                tempFirstData.getSecondCategoryList().add(tempSecondData);
                for (int k = 0; k < categoryList.get(i)
                        .getSecondCategoryList().get(j).getThirdCategoryList()
                        .size(); k++) {
                    TransSecondCategory tempThridData = new TransSecondCategory();
                    tempThridData.setId(categoryList.get(i)
                            .getSecondCategoryList().get(j)
                            .getThirdCategoryList().get(k).getId());
                    tempThridData.setName(categoryList.get(i)
                            .getSecondCategoryList().get(j)
                            .getThirdCategoryList().get(k).getName());
                    tempThridData.setCategoryLevel(categoryList.get(i)
                            .getSecondCategoryList().get(j)
                            .getThirdCategoryList().get(k).getCategoryLevel());
                    tempFirstData.getSecondCategoryList().add(tempThridData);
                }
            }
            transCategory.getFirstCategoryList().add(tempFirstData);
        }
        return transCategory.getFirstCategoryList();
    }

}
