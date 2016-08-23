package com.doshare.share.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doshare.share.MyApp;

import java.lang.reflect.Field;
import java.util.Map;

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

    public static void showMsg(Context context, String showContent) {
        Toast.makeText(context, showContent, Toast.LENGTH_SHORT).show();
    }

    public static void showMsgLong(Context context, String showContent) {
        Toast.makeText(context, showContent, Toast.LENGTH_LONG).show();
    }

    public static DisplayMetrics getDisplayMetrics(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    public static void startAnimation(Activity activity, int animationId, ImageView imageView) {
        Animation loading = AnimationUtils.loadAnimation(activity, animationId);
        loading.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loading);
    }

    public static float calcTextSizeByScreenSize(Activity activity, int length, int reducePixes, int maxTextSize) {
        DisplayMetrics dm = getDisplayMetrics(activity);
        float textSize = ((float) ((dm.widthPixels - reducePixes) / length)) / dm.density;
        if (textSize > ((float) maxTextSize)) {
            return (float)px2sp((float) maxTextSize);
        }
        return textSize;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static ProgressDialog loadProgress(Context activity) {
        ProgressDialog mydialog = new ProgressDialog(activity);
        mydialog.setProgressStyle(0);
        mydialog.setTitle("数据加载提示");
        mydialog.setMessage("Loading ...");
        mydialog.setIndeterminate(false);
        mydialog.show();
        return mydialog;
    }

    public static View getViewFromLayout(Context activity, int layoutID) {
        return LayoutInflater.from(activity).inflate(layoutID, null);
    }

    public static void sendMessage2Handler(Handler handler, int what) {
        handler.sendMessage(handler.obtainMessage(what));
    }

    public static void sendMessage2Handler(Handler handler, int what, int arg1) {
        handler.sendMessage(handler.obtainMessage(what, arg1, arg1));
    }

    public static void sendMessage2Handler(Handler handler, int what, int arg1, Object object) {
        handler.sendMessage(handler.obtainMessage(what, arg1, arg1, object));
    }

    public static void sendMessage2Handler(Handler handler, int what, Object object) {
        handler.sendMessage(handler.obtainMessage(what, object));
    }

    public static void setWindowKeepScreenOn(Activity context) {
        context.requestWindowFeature(1);
        context.getWindow().addFlags(128);
    }

    public static void setWindowFullScreen(Activity context) {
        context.requestWindowFeature(1);
        context.getWindow().addFlags(1024);
    }

    public static void nextPage(Context context, Class<? extends Activity> target) {
        Intent intent = new Intent();
        intent.setClass(context, target);
        context.startActivity(intent);
    }

    public static void nextPage(Context context, Class<? extends Activity> target, Map.Entry<String, String> entry) {
        Intent intent = new Intent();
        intent.setClass(context, target);
        intent.putExtra((String) entry.getKey(), (String) entry.getValue());
        context.startActivity(intent);
    }

    public static void nextPage(Context context, Class<? extends Activity> target, Map.Entry<String, String> entry, int flag) {
        Intent intent = new Intent();
        intent.addFlags(flag);
        intent.setClass(context, target);
        intent.putExtra((String) entry.getKey(), (String) entry.getValue());
        context.startActivity(intent);
    }

    public static void nextPage(Context context, Class<? extends Activity> target, Map<String, String> map) {
        Intent intent = new Intent();
        intent.setClass(context, target);
        for (String key : map.keySet()) {
            intent.putExtra(key, (String) map.get(key));
        }
        context.startActivity(intent);
    }

    public static void nextPage(Context context, Class<? extends Activity> target, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, target);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static TextView setTextToTextView(Activity context, int id, String content) {
        TextView textView = (TextView) context.findViewById(id);
        textView.setText(content);
        return textView;
    }

    public static TextView setSizeToTextView(Activity context, int id, float textSize) {
        TextView textView = (TextView) context.findViewById(id);
        textView.setTextSize(textSize);
        return textView;
    }

    public static View hiddenView(Activity context, int id) {
        View view = context.findViewById(id);
        view.setVisibility(View.INVISIBLE);
        return view;
    }
}
