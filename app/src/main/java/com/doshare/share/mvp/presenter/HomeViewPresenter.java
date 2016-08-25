package com.doshare.share.mvp.presenter;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by vaitt on 16/8/26.<br/>
 * To: vaitt_joy@163.com
 * TODO 借口留着 补充
 */
public interface HomeViewPresenter {
    public static final String TAG = "HomeViewPresenter";
    void load(String appKey,String cityName);
    public void loadBannerDate(Context context, List<ImageView> imageViews);
    public void loadTourInfo();
    public void parseData(Context context);
}
