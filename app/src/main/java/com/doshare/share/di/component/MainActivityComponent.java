package com.doshare.share.di.component;


import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.ui.fra.HomeFragment;

import dagger.Component;


@Component(dependencies = AppComponent.class,modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(HomeFragment homeFragment);
//    void inject(PersonCenterFragment personCenterFragment);
//    void inject(NearByFragment nearByFragment);
//    void inject(KindSortFragment kindSortFragment);
//    KindSortPresenter getKindSortPresenter();
    HomeViewPresenter getMainPresenter();
//    PersonCenterFragmentPresenter getPersonCenterPresenter();
//    NearByPresenter getNearByPresenter();
}
