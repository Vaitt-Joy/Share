package com.doshare.share.di.modules;

import com.doshare.share.di.scope.UserScope;
import com.doshare.share.mvp.presenter.LoginActivityPresenter;
import com.doshare.share.mvp.presenter.LoginActivityPresenterImpl;
import com.doshare.share.mvp.views.LoginActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vaitt on 16/8/23.<br/>
 * To: vaitt_joy@163.com
 */
@UserScope
@Module
public class LoginActivityModule {
    private LoginActivityView view;

    public LoginActivityModule(LoginActivityView view) {
        this.view = view;
    }

    @Provides
    public LoginActivityView provideView() {
        return view;
    }

    @Provides
    public LoginActivityPresenter providePresenter(LoginActivityView homeView) {
        return new LoginActivityPresenterImpl(homeView);
    }
}
