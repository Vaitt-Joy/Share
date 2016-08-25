package com.doshare.share.di.modules;


import com.doshare.share.di.scope.UserScope;
import com.doshare.share.domain.WeatherApiService;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.mvp.presenter.HomeViewPresenterImpl;
import com.doshare.share.mvp.presenter.RightChatViewPresenter;
import com.doshare.share.mvp.presenter.RightChatViewPresenterImpl;
import com.doshare.share.mvp.views.HomeView;
import com.doshare.share.mvp.views.RightChatView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@UserScope
@Module
public class MainActivityModule {
    private HomeView view;
    private RightChatView rightChatView;

    public MainActivityModule(HomeView view) {
        this.view = view;//%B9%E3%D6%DD%
    }

    public MainActivityModule(RightChatView rightChatView){
        this.rightChatView = rightChatView;
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
    public WeatherApiService provideHomeApi(Retrofit restAdapter) {
        return restAdapter.create(WeatherApiService.class);
    }

    @Provides
    public HomeViewPresenter providePresenter(HomeView homeView, WeatherApiService weatherApiService) {
        return new HomeViewPresenterImpl(homeView,weatherApiService);
    }

    @Provides
    public RightChatViewPresenter prividePersonCenterPresenter(RightChatView rightChatView){
        return new RightChatViewPresenterImpl(rightChatView);
    }
}
