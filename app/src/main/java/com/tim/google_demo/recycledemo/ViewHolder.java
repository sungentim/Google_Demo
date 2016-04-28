package com.tim.google_demo.recycledemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gensun on 16/4/22.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(View itemView, Context context, ViewGroup parent) {
        super(itemView);
        this.mConvertView = itemView;
        mContext = context;
        mViews = new SparseArray<View>();
    }


    public static ViewHolder getViewHolder(Context context, ViewGroup parent, int layoutId) {
        View rootView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView, context, parent);
        return viewHolder;
    }

    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


}
