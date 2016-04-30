package com.tim.daggerdemo;

import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuguangqiang.support.utils.IntentUtils;
import com.liuguangqiang.support.utils.image.BlurUtils;
import com.tim.daggerdemo.databinding.ActivityMainBinding;
import com.tim.daggerdemo.module.ActivityModule;
import com.tim.daggerdemo.module.ShoppingCartModel;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.text)
    TextView mText;
    @Bind(R.id.rootView)
    ImageView mRootView;
    private ActivityComponent component;
    private ContainerComponent containerComponent;
    @Inject
    ShoppingCartModel shoppingCartModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);
        component = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        containerComponent = DaggerContainerComponent.builder().activityComponent(component).build();
        containerComponent.inject(this);

        binding.setCartModel(shoppingCartModel);
        mRootView.setImageBitmap(BlurUtils.blur(this, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));

    }

    @OnClick(R.id.changeBtn)
    public void onClick() {
        shoppingCartModel.setName("after changer");
    }
}
