package com.tim.google_demo.recycledemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.tim.google_demo.LoadBitmapEffienct.TestActivity;
import com.tim.google_demo.R;
import com.tim.timutil.base.BaseActivity;
import com.tim.timutil.debugtool.D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gensun on 16/4/22.
 */
public class RecycleDemoActivity extends BaseActivity{
    @InjectView(R.id.recycView)
    RecyclerView mRecycView;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void initEvents() {
        datas.addAll(Arrays.asList(new String[]{"C", "OC", "JAVA", "RUBY", "PYTHON"}));
        mRecycView.setItemAnimator(new DefaultItemAnimator());
        mRecycView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecycView.setAdapter(new CommenAdapter<String>(this, datas, R.layout.recycle_demo_recycleview_item) {
            @Override
            protected void bindData(ViewHolder holder, String item) {
                TextView programeLaguage = holder.getView(R.id.card);
                programeLaguage.setText(item);

            }

        });

    }

    @Override
    protected void initViews() {
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024 / 1024);
        int freememory = (int) (Runtime.getRuntime().freeMemory() / 1024 / 1024);
        int totalMemory = (int) (Runtime.getRuntime().totalMemory() / 1024 / 1024);
        D.d(RecycleDemoActivity.class, maxMemory + "," + freememory + "," + totalMemory);

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

}
