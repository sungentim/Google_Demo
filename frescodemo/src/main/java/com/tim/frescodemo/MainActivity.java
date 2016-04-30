package com.tim.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.img)
    SimpleDraweeView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Uri uri = Uri.parse("http://sungentim.github.io/Blog/assets/head.jpg");
        mImg.setImageURI(uri);
    }
}
