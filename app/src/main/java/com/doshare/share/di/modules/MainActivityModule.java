package com.doshare.share.di.modules;


import com.doshare.share.di.scope.UserScope;

import dagger.Module;


@UserScope
@Module
public class MainActivityModule {
//    private HomeView view;
//    private PersonCenterView personCenterView;
//    private NearByView nearByView;
//    private KindSortView kindSortView;
//
//    public MainActivityModule(HomeView view) {
//        this.view = view;
//    }
//
//    public MainActivityModule(PersonCenterView personCenterView){
//        this.personCenterView = personCenterView;
//    }
//
//    public MainActivityModule(NearByView nearByView){
//        this.nearByView = nearByView;
//    }
//
//    public MainActivityModule(KindSortView kindSortView){
//        this.kindSortView = kindSortView;
//    }
//
//    @Provides
//    public KindSortView provideKindSortView(){
//        return kindSortView;
//    }
//
//    @Provides
//    public PersonCenterView prividePersonCenterView(){
//        return personCenterView;
//    }
//
//    @Provides
//    public HomeView provideView() {
//        return view;
//    }
//
//    @Provides
//    public NearByView provideNearByView(){
//        return nearByView;
//    }
//
//    @Provides
//    public Retrofit provideRestAdapter() {
//        return RestApiAdapter.getInstance();
//    }
//
//    @Provides
//    public WeatherApiService provideHomeApi(Retrofit restAdapter) {
//        return restAdapter.create(WeatherApiService.class);
//    }
//
//    @Provides
//    public HomeViewPresenter providePresenter(HomeView homeView, WeatherApiService weatherApiService) {
//        return new HomeViewPresenterImpl(homeView,weatherApiService);
//    }
//
//    @Provides
//    public PersonCenterFragmentPresenter prividePersonCenterPresenter(PersonCenterView personCenterView1){
//        return new PersonCenterFragmentPresenterImpl(personCenterView1);
//    }
//
//    @Provides
//    public NearByPresenter provideNearByPresenter(NearByView nearByView){
//        return new NearByPresenterImpl(nearByView);
//    }
//
//    @Provides
//    public KindSortPresenter provideKindSortPresenter(KindSortView kindSortView){
//        return new KindSortPresenterImpl(kindSortView);
//    }
}
