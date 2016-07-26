package com.doshare.share.di.component;


import com.doshare.share.MyApp;
import com.doshare.share.di.modules.AppModule;

import dagger.Component;

@Component(
        modules = {
                AppModule.class,
        }
)
public interface AppComponent {
    MyApp inject(MyApp rxRetrofitApplication);
}

