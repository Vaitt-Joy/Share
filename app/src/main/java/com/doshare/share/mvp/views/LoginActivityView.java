package com.doshare.share.mvp.views;

import com.doshare.share.mvp.models.User;

/**
 * Created by vaitt on 16/8/22.<br/>
 * To: vaitt_joy@163.com
 */
public interface LoginActivityView {
    void loginSuccess(User user);
    void loginFailed(String str);
}
