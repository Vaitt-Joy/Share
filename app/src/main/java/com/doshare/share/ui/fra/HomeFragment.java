package com.doshare.share.ui.fra;


import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.doshare.share.MyApp;
import com.doshare.share.R;
import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerMainActivityComponent;
import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.models.ShareTourInfo;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.mvp.views.HomeView;
import com.doshare.share.ui.fra.base.BaseFragment;
import com.doshare.share.utils.ToolUI;
import com.doshare.share.widget.WaveSwipeRefreshLayout.WaveSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class HomeFragment extends BaseFragment implements HomeView, WaveSwipeRefreshLayout.OnRefreshListener {

    @Inject
    HomeViewPresenter presenter;
    private List<ImageView> imageViews;

    @Bind(R.id.main_wave)
    WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        setupCpmponent(((MyApp) ToolUI.getContext()).getAppComponent());
        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.GRAY);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
        mWaveSwipeRefreshLayout.setShadowRadius(0);
        /**************************/
        return view;
    }

    @Override
    protected void initData() {

        imageViews = new ArrayList<ImageView>();
        presenter.loadBannerDate(mContext, imageViews);
        presenter.loadTourInfo();
    }

    @Override
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);
    }
}
