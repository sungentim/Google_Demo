package com.tim.google_demo.LoadBitmapEffienct;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.tim.google_demo.R;
import com.tim.timutil.image.BitmapTool;

import java.lang.ref.WeakReference;

public class BitmapWorkTask extends AsyncTask<String, Void, Bitmap> {

    private WeakReference<ImageView> imageViewWeakReference;
    public String data;
    private Context context;

    public BitmapWorkTask(WeakReference<ImageView> imageViewWeakReference) {
        this.imageViewWeakReference = imageViewWeakReference;
    }

    public BitmapWorkTask(String data, WeakReference<ImageView> imageViewWeakReference, Context context) {
        this.data = data;
        this.imageViewWeakReference = imageViewWeakReference;
        this.context = context;
    }

    public BitmapWorkTask(ImageView imageView) {
        this.imageViewWeakReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageViewWeakReference.get().setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return BitmapTool.decodeBitmapFromResce(context.getResources(), R.mipmap.girl, 500, 500);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (imageViewWeakReference != null && imageViewWeakReference.get() != null && bitmap != null) {
            imageViewWeakReference.get().setImageBitmap(bitmap);
        }
    }
}