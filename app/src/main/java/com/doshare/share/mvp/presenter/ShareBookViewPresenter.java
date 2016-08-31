package com.doshare.share.mvp.presenter;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public interface ShareBookViewPresenter {
    public static final String TAG = "ShareBookViewPresenter";
    void load(String appKey,String cityName);
    public void loadBannerDate(Context context, List<ImageView> imageViews);
    public void loadShareBookInfo();
    public void parseShareBookData(Context context);
}
