package com.doshare.share.di.component;

import com.doshare.share.di.modules.LoginActivityModule;
import com.doshare.share.mvp.presenter.LoginActivityPresenter;
import com.doshare.share.ui.act.LoginActivity;

import dagger.Component;

/**
 * Created by vaitt on 16/8/23.<br/>
 * To: vaitt_joy@163.com
 */
@Component(dependencies = AppComponent.class,modules = LoginActivityModule.class)
public interface LoginActivityComponent {
    void inject(LoginActivity activity);
    LoginActivityPresenter getLoginPresenter();
}
