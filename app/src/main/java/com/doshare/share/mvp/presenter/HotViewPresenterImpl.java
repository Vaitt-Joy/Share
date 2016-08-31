package com.doshare.share.mvp.presenter;

import com.doshare.share.mvp.views.HotView;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public class HotViewPresenterImpl implements HotViewPresenter {

    private final HotView hotView;
    public HotViewPresenterImpl(HotView hotView) {
        this.hotView = hotView;
    }

    @Override
    public void load() {

    }
}
