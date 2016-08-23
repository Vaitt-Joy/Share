package com.doshare.share.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.doshare.share.constants.MyConstants;

/**
 * Created by vaitt on 16/8/24.<br/>
 * To: vaitt_joy@163.com
 * SharedPreferences 工具
 */
public class ToolSp {
    /**
     * @param key   关键字
     * @param value 对应的值
     */
    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();// 提交保存键值对

    }

    /**
     * @param context
     * @param key      关键字
     * @param defValue 设置的默认值
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    /**
     * @param key   关键字
     * @param value 对应的值
     */
    public static void setInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();// 提交保存键值对

    }

    /**
     * @param context
     * @param key      关键字
     * @param defValue 设置的默认值
     * @return
     */
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    /**
     * @param key   关键字
     * @param value 对应的值
     */
    public static void setString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();// 提交保存键值对
    }

    /**
     * @param context
     * @param key      关键字
     * @param defValue 设置的默认值
     * @return
     */
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * 删除某个值
     *
     * @param context
     * @param key     关键字
     */
    public static void clearValueByKey(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(MyConstants.CONFIGFILE, Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }
}