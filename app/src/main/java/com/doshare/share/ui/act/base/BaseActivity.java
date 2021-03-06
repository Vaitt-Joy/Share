package com.doshare.share.ui.act.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.doshare.share.MyApp;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    public static ArrayList<BackPressHandler> mListeners = new ArrayList<BackPressHandler>();
    /***
     * 整个应用Applicaiton
     **/
    private MyApp mApplication = null;
    /**
     * 当前Activity的弱引用，防止内存泄露
     **/
    private WeakReference<Activity> context = null;
    /**
     * 日志输出标志
     **/
    protected final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        //获取应用Application

        initView(savedInstanceState);
        //StatusBarCompat.compat(this);
        mApplication = (MyApp) getApplicationContext();

        //将当前Activity压入栈
        context = new WeakReference<Activity>(this);
        mApplication.pushTask(context);
        initData();
        initEvent();
    }

    public abstract void initView(Bundle savedInstanceState);

    protected void initEvent() {

    }

    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListeners.size() > 0)
            for (BackPressHandler handler : mListeners) {
                handler.activityOnResume();
            }
        resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mListeners.size() > 0)
            for (BackPressHandler handler : mListeners) {
                handler.activityOnPause();
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
        mApplication.removeTask(context);
    }

    public static abstract interface BackPressHandler {

        public abstract void activityOnResume();

        public abstract void activityOnPause();

    }
}
