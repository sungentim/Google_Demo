package com.tim.google_demo.LoadBitmapEffienct;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.tim.google_demo.R;
import com.tim.google_demo.recycledemo.CommenAdapter;
import com.tim.google_demo.recycledemo.ViewHolder;
import com.tim.timutil.base.BaseActivity;
import com.tim.timutil.image.BitmapTool;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TestActivity extends BaseActivity {


    @InjectView(R.id.recycView)
    RecyclerView mRecycView;
    @InjectView(R.id.swipLayout)
    SwipeRefreshLayout mSwipLayout;

    List<String> allImagePaths = new ArrayList<>();


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bindData();
        }
    };

    private void bindData() {
        mRecycView.setItemAnimator(new DefaultItemAnimator());
        mRecycView.setLayoutManager(new LinearLayoutManager(this));
        mRecycView.setAdapter(new CommenAdapter<String>(this, allImagePaths, R.layout.oadbitmap_list_item) {
            @Override
            protected void bindData(ViewHolder holder, String item) {
                ImageView img = holder.getView(R.id.phoneImg);
                loadBitmap(item,img);
            }
        });

    }

    @Override
    protected void initEvents() {
        ButterKnife.inject(this);
        getImages();


    }

    /**
     * get the phone images path
     */
    private void getImages() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                ContentResolver contentResolver = getContentResolver();
                Uri imagUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor cursor = contentResolver.query(imagUri, null, MediaStore.Images.Media.SIZE +
                        ">30720", null, MediaStore.Images.Media._ID + " desc");
                while (cursor != null && cursor.moveToNext()) {
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.
                            Images.Media.DATA));
                    if (!TextUtils.isEmpty(path) && (path.endsWith(".png") || path.endsWith(".jpg")
                            || path.endsWith(".jpeg"))) {

                    }
                    allImagePaths.add(path);
                }
                cursor.close();
                handler.obtainMessage().sendToTarget();
            }
        }).start();
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }


    private static BitmapWorkTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }


    public static boolean cancelPotentialWork(String url, ImageView imageView) {
        final BitmapWorkTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

        if (bitmapWorkerTask != null) {
            final String bitmapData = bitmapWorkerTask.data;
            // If bitmapData is not yet set or it differs from the new data
            if (TextUtils.isEmpty(bitmapData) || bitmapData != url) {
                // Cancel previous task
                bitmapWorkerTask.cancel(true);
            } else {
                // The same work is already in progress
                return false;
            }
        }
        // No task associated with the ImageView, or an existing task was cancelled
        return true;
    }

    public void loadBitmap(String url, ImageView imageView) {
        if (cancelPotentialWork(url, imageView)) {
            final BitmapWorkTask task = new BitmapWorkTask(imageView);
            final AsyncDrawable asyncDrawable =
                    new AsyncDrawable(getResources(), mPlaceHolderBitmap, task);
            imageView.setImageDrawable(asyncDrawable);
            task.execute(url);
        }
    }



}
