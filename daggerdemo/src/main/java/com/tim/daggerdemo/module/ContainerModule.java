package com.tim.daggerdemo.module;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gensun on 16/4/29.
 */
@Module
public class ContainerModule {
    @Provides ShoppingCartModel provideCartModel(){
        return new ShoppingCartModel();
    }
}
