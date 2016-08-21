package com.doshare.share.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.doshare.share.MyApp;

import java.lang.reflect.Field;

/**
 * @author: Vaitt_joy <br/> Email:vaitt_joy@163.com
 * @packageName:org.vjoy.vmusic.tools
 * @createTime:2016/1/13 9:42
 * @Des:UI 工具集
 */
public class ToolUI {
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return MyApp.getContext();
    }

    /**
     * 得到Resouce对象
     */
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**
     * 得到String.xml中的字符串
     */
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    /**
     * 得到String.xml中的字符串数组
     */
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    /**
     * 得到colors.xml中的颜色
     */
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    /**
     * 得到应用程序的包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * 得到主线程id
     */
    public static long getMainThreadid() {
        return MyApp.getMainTreadId();
    }

    /**
     * 得到主线程Handler
     */
    public static Handler getMainThreadHandler() {
        return MyApp.getHandler();
    }

    /**
     * 把任务跑在UI线程中
     */
    public static void runInMainUI(Runnable task) {
        int curThreadId = android.os.Process.myTid();

        if (curThreadId == getMainThreadid()) {// 如果当前线程是主线程
            task.run();
        } else {// 如果当前线程不是主线程
            getMainThreadHandler().post(task);
        }
    }

    /**
     * 延迟执行任务
     */
    public static void postTaskDelay(Runnable task, int delayMillis) {
        getMainThreadHandler().postDelayed(task, delayMillis);
    }

    /**
     * 移除任务
     */
    public static void removeTask(Runnable task) {
        getMainThreadHandler().removeCallbacks(task);
    }

    /**
     * dip-->px
     */
    public static int dip2Px(float dip) {
        // px/dip = density;
        float density = getResource().getDisplayMetrics().density;
        int px = (int) (dip * density + .5f);
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2Dip(float px) {
        // px/dip = density;
        float density = getResource().getDisplayMetrics().density;
        int dip = (int) (px / density + .5f);
        return dip;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        final float fontScale = getResource().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = getResource().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /*
     * 屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 屏幕高度
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int temp = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }
}
