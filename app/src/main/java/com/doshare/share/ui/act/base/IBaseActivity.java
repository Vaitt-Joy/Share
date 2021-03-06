package com.doshare.share.ui.act.base;

import android.os.Bundle;

/**
 * Activity接口
 */
public interface IBaseActivity {

//	/**
//	 * 绑定渲染视图的布局文件
//	 * @return 布局文件资源id
//	 */
//	public int bindLayout();
	
	/**
	 * 初始化控件
	 */
	public void initView(Bundle savedInstanceState);
	
	/**
	 * 暂停恢复刷新相关操作（onResume方法中调用）
	 */
	public void resume();
	
	/**
	 * 销毁、释放资源相关操作（onDestroy方法中调用）
	 */
	public void destroy();
	
}
