package com.doshare.share.ui.fra;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doshare.share.MyApp;
import com.doshare.share.R;
import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerMainActivityComponent;
import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.models.ShareTourInfo;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.mvp.views.HomeView;
import com.doshare.share.utils.ToolUI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 *
 */
public class HomeFragment extends Fragment implements HomeView {


    private View rootView;//
    public Context mContext;// 上下文
    @Inject
    HomeViewPresenter presenter;
    private List<ImageView> imageViews;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = initView();
            ButterKnife.bind(this, rootView);
            setupCpmponent(((MyApp) ToolUI.getContext()).getAppComponent());
            initData();
            initEvent();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }


        return rootView;
    }

    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        return view;
    }


    protected void initData() {

        imageViews = new ArrayList<ImageView>();
        presenter.loadBannerDate(mContext, imageViews);
        presenter.loadTourInfo();
    }


    protected void initEvent() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void setupCpmponent(AppComponent appCpmponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appCpmponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

//    @Override
//    public void showWeatherInfo(WeatherResultBean weatherResultBean) {
//
//    }

    @Override
    public void errorLoad(Throwable t) {

    }

    @Override
    public void showBannerView(List<ImageView> imageViews) {

    }

    @Override
    public void onLoadTourInfoSucceed(List<ShareTourInfo> tourInfos) {

    }

    @Override
    public void onLoadTourInfoError(String errStr) {

    }

    @Override
    public void parseTourInfo(List<ShareTourInfo> tourInfos) {

    }
}
