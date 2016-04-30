package com.tim.frescodemo;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;

import com.tim.timutil.debugtool.D;

/**
 * Created by gensun on 16/4/30.
 */
public class MySwipRefreshLayout extends SwipeRefreshLayout {
    public MySwipRefreshLayout(Context context) {
        super(context);
    }


    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        D.d(MySwipRefreshLayout.class, "onInterceptHoverEvent");
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        D.d(MySwipRefreshLayout.class, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        D.d(MySwipRefreshLayout.class, "onTouchEvent");
        return super.onTouchEvent(ev);
    }
}
