package com.tim.daggerdemo;

import com.tim.daggerdemo.module.ContainerModule;

import dagger.Component;

/**
 * Created by gensun on 16/4/29.
 */
@Component(dependencies = ActivityComponent.class, modules = ContainerModule.class)
public interface ContainerComponent {
    void inject(MainActivity mainActivity);
}
