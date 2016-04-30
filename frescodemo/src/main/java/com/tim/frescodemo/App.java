package com.tim.frescodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by gensun on 16/4/30.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
