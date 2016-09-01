package com.doshare.share.mvp.presenter;

import android.content.Context;

import com.doshare.share.mvp.views.ForumView;

/**
 * Created by vaitt on 16/9/2.<br/>
 * To: vaitt_joy@163.com
 */
public class ForumViewPresenterImpl implements ForumViewPresenter {

    private final ForumView forumView;

    public ForumViewPresenterImpl(ForumView forumView) {
        this.forumView = forumView;
    }

    @Override
    public void load(String appKey, String cityName) {

    }

    @Override
    public void loadForumInfo() {

    }

    @Override
    public void parseData(Context context) {

    }
}
