package com.tim.daggerdemo;

import com.tim.daggerdemo.module.ActivityModule;

import dagger.Component;

/**
 * Created by gensun on 16/4/29.
 */
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
