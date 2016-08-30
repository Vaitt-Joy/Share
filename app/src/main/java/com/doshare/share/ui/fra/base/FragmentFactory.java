package com.doshare.share.ui.fra.base;

import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Vaitt_joy
 * @Des: fragment的工厂类
 */
public class FragmentFactory {
    private Map<Integer, Class> fraClazzs = new HashMap<Integer, Class>();
    private SparseArrayCompat<Fragment> cachesFragment = new SparseArrayCompat<Fragment>();

    public FragmentFactory(Map<Integer, Class> fraClazzs) {
        this.fraClazzs = fraClazzs;
    }

    public Fragment getFragent(int position) {
        Fragment fragment = null;
        // 如果缓存里面有对应的fragment,就直接取出返回

        Fragment tmpFragment = cachesFragment.get(position);
        if (tmpFragment != null) {
            fragment = tmpFragment;
            return fragment;
        }
        try {
            fragment = (Fragment) fraClazzs.get(position).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        cachesFragment.put(position, fragment);
        return fragment;
    }
}
