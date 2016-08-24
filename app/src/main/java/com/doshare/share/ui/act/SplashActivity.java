package com.doshare.share.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.doshare.share.MainActivity;
import com.doshare.share.R;
import com.doshare.share.constants.MyConstants;
import com.doshare.share.ui.act.base.BaseActivity;
import com.doshare.share.utils.ToolNetwork;
import com.doshare.share.utils.ToolSp;

public class SplashActivity extends BaseActivity {

    private Handler mHandler;

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(bindLayout());
    }

    @Override
    protected void initData() {
        super.initData();
        mHandler = new Handler();
        String password = ToolSp.getString(this, MyConstants.PASSWORD, "");

        if (!TextUtils.isEmpty(password) && !(ToolNetwork.getNetworkState(this) == ToolNetwork.NETWORN_NONE)) {
            mHandler.postDelayed(gotoMainAct, 3000);
        } else {
            mHandler.postDelayed(gotoLoginAct, 3000);
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    Runnable gotoLoginAct = new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }
    };

    Runnable gotoMainAct = new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };
}
