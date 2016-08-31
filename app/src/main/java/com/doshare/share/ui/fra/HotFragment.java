package com.doshare.share.ui.fra;

import android.view.View;

import com.doshare.share.MyApp;
import com.doshare.share.R;
import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerMainActivityComponent;
import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.presenter.HotViewPresenter;
import com.doshare.share.mvp.views.HotView;
import com.doshare.share.ui.fra.base.BaseFragment;
import com.doshare.share.utils.ToolUI;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public class HotFragment extends BaseFragment implements HotView {

    @Inject
    HotViewPresenter presenter;

    @Override
    protected View initView() {
        return View.inflate(mContext, R.layout.fragment_hot, null);
    }

    @Override
    protected void initData() {
        super.initData();
        ButterKnife.bind(this, rootView);
        setComponent(((MyApp) ToolUI.getContext()).getAppComponent());
    }

    private void setComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder().appComponent(appComponent).mainActivityModule(new MainActivityModule(this)).build().inject(this);
    }

    @Override
    public void errorLoad(Throwable t) {

    }
}
