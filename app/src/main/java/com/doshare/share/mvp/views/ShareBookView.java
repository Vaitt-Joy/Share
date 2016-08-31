package com.doshare.share.mvp.views;

import android.widget.ImageView;

import com.doshare.share.mvp.models.ShareBookInfo;

import java.util.List;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public interface ShareBookView {
    void errorLoad(Throwable t);
    void showBannerView(List<ImageView> imageViews);
    void onLoadShareBookInfoSucceed(List<ShareBookInfo> tourInfos);
    void onLoadShareBookInfoError(String errStr);
    void parseShareBookInfo(List<ShareBookInfo> bookInfos);
}
