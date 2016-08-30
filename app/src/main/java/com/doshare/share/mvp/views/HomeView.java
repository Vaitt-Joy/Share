package com.doshare.share.mvp.views;

import android.widget.ImageView;

import com.doshare.share.mvp.models.ShareTourInfo;

import java.util.List;

/**
 * Created by vaitt on 16/8/25.<br/>
 * To: vaitt_joy@163.com
 */
public interface HomeView {
    //void showWeatherInfo(WeatherResultBean weatherResultBean);
    void errorLoad(Throwable t);
    void showBannerView(List<ImageView> imageViews);
    void onLoadTourInfoSucceed(List<ShareTourInfo> tourInfos);
    void onLoadTourInfoError(String errStr);
    void parseTourInfo(List<ShareTourInfo> tourInfos);
}
