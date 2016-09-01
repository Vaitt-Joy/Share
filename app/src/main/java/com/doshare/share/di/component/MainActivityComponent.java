package com.doshare.share.di.component;


import com.doshare.share.di.modules.MainActivityModule;
import com.doshare.share.mvp.presenter.ForumViewPresenter;
import com.doshare.share.mvp.presenter.HomeViewPresenter;
import com.doshare.share.mvp.presenter.HotViewPresenter;
import com.doshare.share.mvp.presenter.RightChatViewPresenter;
import com.doshare.share.mvp.presenter.ShareBookViewPresenter;
import com.doshare.share.ui.fra.ForumFragment;
import com.doshare.share.ui.fra.HomeFragment;
import com.doshare.share.ui.fra.HotFragment;
import com.doshare.share.ui.fra.RightChatFragment;
import com.doshare.share.ui.fra.ShareBookFragment;

import dagger.Component;


@Component(dependencies = AppComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(HomeFragment homeFragment);

    void inject(ShareBookFragment shareBookFragment);

    void inject(RightChatFragment righChatFragment);

    void inject(HotFragment hotFragment);

    void inject(ForumFragment forumFragment);

    RightChatViewPresenter getRightChatPresenter();

    HomeViewPresenter getMainPresenter();

    ShareBookViewPresenter getShareBookPresenter();

    HotViewPresenter getHotPresenter();

    ForumViewPresenter getFroumPresenter();
}
