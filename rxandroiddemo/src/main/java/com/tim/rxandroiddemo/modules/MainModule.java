package com.tim.rxandroiddemo.modules;

import android.app.Application;
import android.content.res.Resources;

import com.tim.rxandroiddemo.DemoApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gensun on 16/4/28.
 */
@Module
public class MainModule {

    private final DemoApplication app;


    public MainModule(DemoApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    protected Application provideApplication(){
        return app;
    }
    @Provides
    @Singleton
    protected Resources provideResource(){
        return app.getResources();
    }

}
