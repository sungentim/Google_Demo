package com.tim.daggerdemo.module;

import com.tim.daggerdemo.MyApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gensun on 16/4/30.
 */
@Module()
public class AppModule {
    private MyApplication app;

    public AppModule(MyApplication app) {
        this.app = app;
    }

    @Singleton @Provides MyApplication provideApplicationContext(){
        return app;
    }

}
