package com.doshare.share.mvp.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.doshare.share.mvp.views.ShareBookView;

import java.util.List;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public class ShareBookViewPresenterImpl implements ShareBookViewPresenter {

    private final ShareBookView shareBookView;

    public ShareBookViewPresenterImpl(ShareBookView shareBookView) {
        this.shareBookView = shareBookView;
    }

    @Override
    public void load(String appKey, String cityName) {

    }

    @Override
    public void loadBannerDate(Context context, List<ImageView> imageViews) {

    }

    @Override
    public void loadShareBookInfo() {

    }

    @Override
    public void parseShareBookData(Context context) {

    }
}
