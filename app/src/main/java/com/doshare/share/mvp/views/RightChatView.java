package com.doshare.share.mvp.views;

import com.doshare.share.mvp.models.Friends;

import java.util.List;

/**
 * Created by vaitt on 16/8/25.<br/>
 * To: vaitt_joy@163.com
 */
public interface RightChatView {
    void errorLoad(Throwable t);
    void onLoadFriendInfoSucceed(List<Friends> friendses);
    void onLoadFriendInfoError(String errStr);
    void parseFriendInfo(List<Friends> tourInfos);
}
