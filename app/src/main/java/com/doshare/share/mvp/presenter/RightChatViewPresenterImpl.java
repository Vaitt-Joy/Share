package com.doshare.share.mvp.presenter;

import com.doshare.share.mvp.views.RightChatView;

/**
 * Created by vaitt on 16/8/26.<br/>
 * To: vaitt_joy@163.com
 * TODO 借口留着 补充
 */
public class RightChatViewPresenterImpl implements RightChatViewPresenter {

    private RightChatView rightChatView;
    public RightChatViewPresenterImpl(RightChatView rightChatView) {
        this.rightChatView = rightChatView;
    }

    @Override
    public void loadFriends() {

    }
}
