package com.tim.rxandroiddemo;

import com.tim.rxandroiddemo.modules.ApiModule;
import com.tim.rxandroiddemo.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**组件
 * Created by gensun on 16/4/28.
 */
@Singleton
@Component(modules = {MainModule.class, ApiModule.class})
public interface DemoComponent extends DemoGraph{

    final class Initializer{
        private Initializer(){

        }
        // 初始化组件
        public static DemoComponent init(DemoApplication app) {
            return DaggerDemoComponent.builder()
                    .mainModule(new MainModule(app))
                    .build();
        }
    }

}
