package com.tim.rxandroiddemo.modules;

import com.tim.rxandroiddemo.constants.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 接口模块
 * Created by gensun on 16/4/28.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    protected GitHubService provideGithubService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GitHubService.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()).build();//添加Gson转换器
        return retrofit.create(GitHubService.class);
    }

}
