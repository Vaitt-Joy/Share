package com.doshare.share.mvp.presenter;

import android.content.Context;

import com.doshare.share.mvp.models.User;
import com.doshare.share.mvp.views.LoginActivityView;
import com.doshare.share.utils.ToolToast;

/**
 * Created by vaitt on 16/8/23.<br/>
 * To: vaitt_joy@163.com
 */
public class LoginActivityPresenterImpl implements LoginActivityPresenter {

    private LoginActivityView loginView;

    public LoginActivityPresenterImpl(LoginActivityView homeView) {
        this.loginView = homeView;
    }

    @Override
    public void login(Context context, String userName, String password) {
        if (userName.equals("")||userName.length()<6){
            ToolToast.showLong("请校验用户名");
            return;
        }if (password.equals("")||password.length()<6){
            ToolToast.showLong("请校验用户名");
            return;
        }
        loginView.loginSuccess(new User());
    }
}
