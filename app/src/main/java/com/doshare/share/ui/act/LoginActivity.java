package com.doshare.share.ui.act;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.doshare.share.MainActivity;
import com.doshare.share.MyApp;
import com.doshare.share.R;
import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerLoginActivityComponent;
import com.doshare.share.di.modules.LoginActivityModule;
import com.doshare.share.mvp.models.User;
import com.doshare.share.mvp.presenter.LoginActivityPresenter;
import com.doshare.share.mvp.views.LoginActivityView;
import com.doshare.share.ui.act.base.BaseActivity;
import com.doshare.share.utils.ToolToast;
import com.doshare.share.utils.ToolUI;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via phome/password.
 */
public class LoginActivity extends BaseActivity implements LoginActivityView {

    @Inject
    LoginActivityPresenter presenter;
    @Bind(R.id.login_progress)
    ProgressBar loginProgress;
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.sign_in_button)
    Button signInButton;
    @Bind(R.id.login_error)
    TextView loginError;
    @Bind(R.id.register_now)
    TextView registerNow;
    @Bind(R.id.qq_login)
    ImageView qqLogin;
    @Bind(R.id.weixin_login)
    ImageView weixinLogin;
    @Bind(R.id.weibo_login)
    ImageView weiboLogin;
    @Bind(R.id.cancel_login)
    ImageView cancleLogin;


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupComponent(((MyApp) getApplicationContext()).getAppComponent());
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {
        ButterKnife.unbind(this);
    }


    @Override
    public void loginSuccess(User user) {//成功的回调
        ToolUI.nextPage(this, MainActivity.class);
        finish();
    }

    private void setupComponent(AppComponent appComponent) {
        DaggerLoginActivityComponent
                .builder()
                .appComponent(appComponent)
                .loginActivityModule(new LoginActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void loginFailed(String str) {//登陆失败
        ToolToast.showShort(getBaseContext(), str);
    }

    /**
     * 微博登陆
     */
    private void weiBoLogin() {
        ToolToast.showLong("weiBoLogin");
    }

    /**
     * 微信登陆
     */
    private void weiXinLogin() {
        ToolToast.showLong("weiXinLogin");
    }

    /**
     * qq登陆
     */
    private void qqLogin() {
        ToolToast.showLong("qqLogin");
    }

    @OnClick({R.id.sign_in_button, R.id.login_error, R.id.register_now, R.id.qq_login, R.id.weixin_login, R.id.weibo_login, R.id.cancel_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qq_login:
                qqLogin();
                break;
            case R.id.weixin_login:
                weiXinLogin();
                break;
            case R.id.weibo_login:
                weiBoLogin();
                break;
            case R.id.sign_in_button:
                presenter.login(this, username.getText().toString(), password.getText().toString());
                break;
            case R.id.login_error:
                break;
            case R.id.register_now:
                break;
            case R.id.cancel_login:
                ToolUI.nextPage(this, MainActivity.class);
                finish();
                break;
        }
    }
}

