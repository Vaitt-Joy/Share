/****************************
文件名:LogUtils.java

创建时间:
所在包:
作者:vaitt
说明:输出日志的通用工具类
 ****************************/

package com.doshare.share.utils;

import android.util.Log;

import org.json.JSONObject;

public class ToolLog {
	// 日志开关，！！！！默认为关闭，开发可以自行打开，但是切记不要提交到svn
	public static boolean LOG_ON = true; // ！！！！默认为关闭，开发可以自行打开，但是切记不要提交到svn

	public static void DebugLog(String src) {
		if (LOG_ON)
			Log.d("dmSmart", src);
	}

	public static void DebugLog(Exception e) {
		if (LOG_ON)
			Log.e("dmSmart", "" + e);

	}

	public static void DebugLog(double double1) {
		if (LOG_ON)
			Log.d("dmSmart", "" + double1);

	}

	public static void DebugLog(JSONObject put) {
		if (LOG_ON)
			Log.d("dmSmart", "" + put);

	}

	public static void DebugLog(Object object) {
		if (LOG_ON)
			Log.d("dmSmart", "" + object);

	}

	public static void DebugLog(String string, String string2) {
		if (LOG_ON)
			Log.d("dmSmart", string + " " + string2);

	}

	public static void DebugLog(String logTag, String string, Exception e) {
		if (LOG_ON)
			Log.d("dmSmart", logTag + " " + string + e.toString());
	}

	public static void d(String string, String string2) {
		if (LOG_ON)
			Log.d(string, string2);
	}

	public static void e(String string, String string2, Exception ex) {
		if (LOG_ON)
			Log.e(string, string2);
	}

	public static void w(String string, String string2) {
		if (LOG_ON)
			Log.w(string, string2);
	}

	public static void PST(Exception e) {
		if (LOG_ON) {
			e.printStackTrace();
		}
	}

	public static void PST(OutOfMemoryError e) {
		if (LOG_ON) {
			e.printStackTrace();
		}
	}

	public static void i(String string, String string2, Throwable ex) {
		if (LOG_ON)
			Log.i(string, string2 + ex.toString());
	}

	public static void i(String string, String string2) {
		if (LOG_ON)
			Log.i(string, string2);
	}

	public static void e(String string, String string2) {
		if (LOG_ON)
			Log.i(string, string2);
	}
}
