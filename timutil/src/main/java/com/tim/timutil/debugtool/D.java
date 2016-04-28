package com.tim.timutil.debugtool;

import android.util.Log;

/**
 * Created by gensun on 16/4/22.
 */
public class D {
    private static boolean show_normal_log = true;
    private static final String LOG_TAG = D.class.getSimpleName();

    public static void v(String s) {
        if (show_normal_log) {
            Log.v(LOG_TAG, s);
        }
    }

    public static void d(String s) {
        if (show_normal_log) {
            Log.d(LOG_TAG, s);
        }
    }

    public static void d(Class claszz, String s) {
        if (show_normal_log) {
            Log.d(LOG_TAG, claszz.getSimpleName() + ":" + s);
        }
    }

    public static void i(String s) {
        if (show_normal_log) {
            Log.i(LOG_TAG, s);
        }
    }

    public static void w(String s) {
        if (show_normal_log) {
            Log.w(LOG_TAG, s);
        }
    }

    public static void e(Exception e) {
        if (show_normal_log) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }
}
