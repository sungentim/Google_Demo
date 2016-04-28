package com.tim.rxandroiddemo.constants;


import com.tim.rxandroiddemo.mylist.MyListAdapter;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by gensun on 16/4/28.
 */
public interface GitHubService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Observable<ArrayList<MyListAdapter.Repo>> getRepoData(@Path("user") String user);
}
