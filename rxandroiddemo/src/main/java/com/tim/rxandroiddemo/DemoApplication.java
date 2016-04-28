package com.tim.rxandroiddemo;

import android.app.Application;

/**
 * Created by gensun on 16/4/28.
 */
public class DemoApplication extends Application {
    private static DemoApplication app;
    private static DemoGraph demoGraph;

    public static DemoGraph component() {
        return demoGraph;
    }

    public static void buildAndInject() {

        demoGraph = DemoComponent.Initializer.init(app);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        buildAndInject();

    }
}
