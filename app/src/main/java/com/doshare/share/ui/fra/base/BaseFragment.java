package com.doshare.share.ui.fra.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 所有fragment的父类
 *
 * @author Vaitt_joy
 */
public abstract class BaseFragment extends Fragment {

    public View rootView;//
    public Context mContext;// 上下文
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = initView();
            initData();
            initEvent();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 初始的view
     *
     * @return
     */
    protected abstract View initView();

    /**
     * 初始数据
     */
    protected void initData() {

    }

    /**
     * 初始事件
     */
    protected void initEvent() {

    }
}
