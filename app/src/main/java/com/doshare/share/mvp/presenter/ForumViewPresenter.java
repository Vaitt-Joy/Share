package com.doshare.share.mvp.presenter;

import android.content.Context;

/**
 * Created by vaitt on 16/9/2.<br/>
 * To: vaitt_joy@163.com
 */
public interface ForumViewPresenter {
    public static final String TAG = "HomeViewPresenter";
    void load(String appKey,String cityName);
    public void loadForumInfo();
    public void parseData(Context context);
}
