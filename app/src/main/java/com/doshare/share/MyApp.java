package com.doshare.share;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerAppComponent;
import com.doshare.share.di.modules.AppModule;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 *
 */
public class MyApp extends Application {

    public static final String TAG = "MyApp";
    private AppComponent mAppComponent;

    private final Stack<WeakReference<Activity>> activitys = new Stack<WeakReference<Activity>>();

    @Override
    public void onCreate() {
        super.onCreate();
        initBmob();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
        initBaiDuMap();
        initShare();
    }

    public void initShare(){
//        PlatformConfig.setSinaWeibo("3400588978","c685e5d1ba7e8b6dddf82b9e5aea0a44");
//        //新浪微博 appkey appsecret
//        PlatformConfig.setWeixin("wx5a714face5a6640d", "03ac8c788f750d68a73c4742da77bb23");
//        //微信 appid appsecret
    }

    public void initBmob(){
//        Bmob.initialize(this, GlobalDefineValues.BmobApplicationID);
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public static MyApp getApplication(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public void initBaiDuMap(){
        //SDKInitializer.initialize(getApplicationContext());
    }


    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    public void pushTask(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除
     *
     * @param task
     */
    public void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    public void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex)
            activitys.remove(taskIndex);
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    public void removeToTop() {
        int end = activitys.size();
        int start = 1;
        for (int i = end - 1; i >= start; i--) {
            if (!activitys.get(i).get().isFinishing()) {
                activitys.get(i).get().finish();
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    public void removeAll() {
        //finish所有的Activity
        for (WeakReference<Activity> task : activitys) {
            if (!task.get().isFinishing()) {
                task.get().finish();
            }
        }
    }
}
