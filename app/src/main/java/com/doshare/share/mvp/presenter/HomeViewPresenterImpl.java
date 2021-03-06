package com.doshare.share.mvp.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.doshare.share.mvp.views.HomeView;

import java.util.List;

/**
 * Created by vaitt on 16/8/26.<br/>
 * To: vaitt_joy@163.com
 * 首页的数据展示 业务类
 */
public class HomeViewPresenterImpl implements HomeViewPresenter {
    private final HomeView homeView;

    public HomeViewPresenterImpl(HomeView homeView) {
        this.homeView = homeView;
    }


    @Override
    public void load(String appKey, String cityName) {

    }

    @Override
    public void loadBannerDate(Context context, List<ImageView> imageViews) {

    }

    @Override
    public void loadTourInfo() {

    }

    @Override
    public void parseData(Context context) {

    }
}
