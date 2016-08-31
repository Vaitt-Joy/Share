package com.doshare.share.di.modules;


import com.doshare.share.di.scope.UserScope;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.mvp.presenter.HomeViewPresenterImpl;
import com.doshare.share.mvp.presenter.HotViewPresenter;
import com.doshare.share.mvp.presenter.HotViewPresenterImpl;
import com.doshare.share.mvp.presenter.RightChatViewPresenter;
import com.doshare.share.mvp.presenter.RightChatViewPresenterImpl;
import com.doshare.share.mvp.presenter.ShareBookViewPresenter;
import com.doshare.share.mvp.presenter.ShareBookViewPresenterImpl;
import com.doshare.share.mvp.views.HomeView;
import com.doshare.share.mvp.views.HotView;
import com.doshare.share.mvp.views.RightChatView;
import com.doshare.share.mvp.views.ShareBookView;

import dagger.Module;
import dagger.Provides;


@UserScope
@Module
public class MainActivityModule {
    private HomeView view;
    private ShareBookView shareBookView;
    private RightChatView rightChatView;
    private HotView hotView;

    public MainActivityModule(HomeView view) {
        this.view = view;
    }
    public MainActivityModule(ShareBookView shareBookView) {
        this.shareBookView = shareBookView;
    }

    public MainActivityModule(RightChatView rightChatView){
        this.rightChatView = rightChatView;
    }
    public MainActivityModule(HotView hotView){
        this.hotView = hotView;
    }

    @Provides
    public RightChatView privideRightChatView(){
        return rightChatView;
    }

    @Provides
    public HomeView provideHomeView() {
        return view;
    }

    @Provides
    public ShareBookView provideShareBookView() {
        return shareBookView;
    }
    @Provides
    public HotView provideHotView() {
        return hotView;
    }


    @Provides
    public HomeViewPresenter providePresenter(HomeView homeView) {
        return new HomeViewPresenterImpl(homeView);
    }

    @Provides
    public ShareBookViewPresenter provideShareBookPresenter(ShareBookView shareBookView) {
        return new ShareBookViewPresenterImpl(shareBookView);
    }
    @Provides
    public HotViewPresenter provideHotPresenter(HotView hotView) {
        return new HotViewPresenterImpl(hotView);
    }

    @Provides
    public RightChatViewPresenter privideRightChatPresenter(RightChatView rightChatView){
        return new RightChatViewPresenterImpl(rightChatView);
    }
}
