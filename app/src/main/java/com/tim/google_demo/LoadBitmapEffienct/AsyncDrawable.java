package com.tim.google_demo.LoadBitmapEffienct;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * Created by gensun on 16/4/22.
 */
public class AsyncDrawable extends BitmapDrawable {

    private final WeakReference<BitmapWorkTask> bitmapWorkerTaskReference;

    public AsyncDrawable(Resources res, Bitmap bitmap,
                         BitmapWorkTask bitmapWorkerTask) {
        super(res, bitmap);
        bitmapWorkerTaskReference =
                new WeakReference<BitmapWorkTask>(bitmapWorkerTask);
    }

    public BitmapWorkTask getBitmapWorkerTask() {
        return bitmapWorkerTaskReference.get();
    }
}
