package com.tim.daggerdemo.module;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by gensun on 16/4/29.
 */
public class ShoppingCartModel extends BaseObservable{
    private String name = "tim";


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
