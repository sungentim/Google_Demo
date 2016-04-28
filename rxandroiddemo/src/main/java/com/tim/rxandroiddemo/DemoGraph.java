package com.tim.rxandroiddemo;

/**
 * Created by gensun on 16/4/28.
 */
public interface DemoGraph {
    void inject(MainActivity mainActivity);//注入mainactivity

    void inject(RepoListActivity repoListActivity);//repoListActivity
}
