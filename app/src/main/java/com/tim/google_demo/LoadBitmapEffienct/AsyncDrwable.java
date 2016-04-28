package com.tim.google_demo.LoadBitmapEffienct;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * Created by gensun on 16/4/22.
 */
public class AsyncDrwable extends BitmapDrawable {

    private final WeakReference<BitmapWorkTask> taskWeakReference;

    public AsyncDrwable(Resources res, Bitmap bitmap, WeakReference<BitmapWorkTask> taskWeakReference) {
        super(res, bitmap);
        this.taskWeakReference = taskWeakReference;
    }


}
