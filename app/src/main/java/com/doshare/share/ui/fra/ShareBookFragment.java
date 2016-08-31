package com.doshare.share.ui.fra;

import android.view.View;
import android.widget.ImageView;

import com.doshare.share.MyApp;
import com.doshare.share.R;
import com.doshare.share.di.component.AppComponent;
import com.doshare.share.di.component.DaggerMainActivityComponent;
import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.models.ShareBookInfo;
import com.doshare.share.mvp.presenter.ShareBookViewPresenter;
import com.doshare.share.mvp.views.ShareBookView;
import com.doshare.share.ui.fra.base.BaseFragment;
import com.doshare.share.utils.ToolUI;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by vaitt on 16/9/1.<br/>
 * To: vaitt_joy@163.com
 */
public class ShareBookFragment extends BaseFragment implements ShareBookView {

    @Inject
    ShareBookViewPresenter presenter;


    @Override
    protected View initView() {
        return View.inflate(mContext, R.layout.fragment_sharebook, null);
    }

    @Override
    protected void initData() {
        super.initData();
        ButterKnife.bind(this, rootView);
        setupCpmponent(((MyApp) ToolUI.getContext()).getAppComponent());
        presenter.loadShareBookInfo();
    }

    private void setupCpmponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder().appComponent(appComponent).mainActivityModule(new MainActivityModule(this)).build().inject(this);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    public void errorLoad(Throwable t) {

    }

    @Override
    public void showBannerView(List<ImageView> imageViews) {

    }

    @Override
    public void onLoadShareBookInfoSucceed(List<ShareBookInfo> tourInfos) {

    }

    @Override
    public void onLoadShareBookInfoError(String errStr) {

    }

    @Override
    public void parseShareBookInfo(List<ShareBookInfo> bookInfos) {

    }
}
