package com.tim.rxandroiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tim.rxandroiddemo.constants.GitHubService;
import com.tim.rxandroiddemo.mylist.MyListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RepoListActivity extends AppCompatActivity {

    @Bind(R.id.repos_rv_list)
    RecyclerView mReposRvList;

    @Inject
    GitHubService service;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
        DemoApplication.component().inject(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new MyListAdapter();
        mReposRvList.setLayoutManager(manager);
        mReposRvList.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        service.getRepoData("SpikeKing").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::setmRepos);

    }
}
