package com.tim.rxandroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tim.rxandroiddemo.mylist.MyListAdapter;
import com.tim.timutil.EasyToast;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DemoApplication.component().inject(this);


//        rxHello();
//        rxSimple();
//        rxSimplest();
//        rxSimplestWithOperators();
//        rxListDemo();
    }

    public void gotoReposList(View v) {
        startActivity(new Intent(this, RepoListActivity.class));
    }

    private void rxListDemo() {
        Observable<String> stringObservable = Observable.from(new String[]{"this", "is", "a", "sentence"});
        stringObservable.map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s.toUpperCase() + " ";
            }
        }).toList().map(new Func1<List<String>, String>() {
            @Override
            public String call(List<String> strings) {
                Collections.reverse(strings);
                return strings.toString();
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                EasyToast.showShort(MainActivity.this, s);
            }
        });
    }

    private void rxSimplestWithOperators() {
        Observable.just("hello world!").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "TIM";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                EasyToast.showShort(MainActivity.this, s);
            }
        });
    }

    private void rxSimplest() {
        Observable.just("hello world!").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                EasyToast.showShort(MainActivity.this, s);
            }
        });
    }

    private void rxSimple() {
        Observable<String> observable = Observable.just("hello world!");
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                EasyToast.showShort(MainActivity.this, s);
            }
        };
        observable.subscribe(onNextAction);
    }

    private void rxHello() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello wolrd!");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> stringSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                EasyToast.showShort(MainActivity.this, s);

            }
        };
        observable.subscribe(stringSubscriber);

    }
}
