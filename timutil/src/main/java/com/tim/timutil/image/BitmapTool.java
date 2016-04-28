package com.tim.timutil.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by gensun on 16/4/22.
 */
public class BitmapTool {

    /**
     * 压缩图片到指定的尺寸大小
     *
     * @param resources:
     * @param resId:本地图片ID
     * @param reqWidth:指定的宽度
     * @param reqheight:指定的高度
     * @return
     */
    public static Bitmap decodeBitmapFromResce(Resources resources, int resId, int reqWidth, int reqheight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        //计算缩放比例
        options.inSampleSize = caculateSampleSize(options, reqWidth, reqheight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);
    }

    /**
     *
     * @param is:图片流
     * @param reqWidth
     * @param reqheight
     * @return
     */
    public static Bitmap decodeBitmapInputStream(InputStream is, int reqWidth, int reqheight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, options);
        //计算缩放比例
        options.inSampleSize = caculateSampleSize(options, reqWidth, reqheight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(is, null, options);
    }

    private static int caculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqheight) {

        int sampleSize = 1;
        int realWidth = options.outWidth;
        int realHeight = options.outHeight;

        if (realHeight > reqheight || realWidth > reqWidth) {
            double wRation = realWidth * 1.0 / reqWidth;
            double hRation = realHeight * 1.0 / reqheight;
            if (wRation > hRation) {
                sampleSize = (int) Math.ceil(wRation);
            } else {
                sampleSize = (int) Math.ceil(hRation);
            }
        }
        return sampleSize;
    }



}
