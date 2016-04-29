package com.tim.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tim.daggerdemo.module.ActivityModule;
import com.tim.daggerdemo.module.UserModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.text)
    TextView mText;
    private ActivityComponent component;
    @Inject
    UserModule userModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        component = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        component.inject(this);
        mText.setText(userModule.getName());
    }
}
