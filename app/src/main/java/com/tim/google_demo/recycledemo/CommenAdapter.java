package com.tim.google_demo.recycledemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by gensun on 16/4/22.
 */
public abstract class CommenAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<T> datas;
    private int myLayoutId;


    public List<T> getDatas() {
        return datas;
    }

    public void addItem(T item, int position) {
        datas.add(position, item);
        notifyItemInserted(position);
    }

    public void addItem(T item) {
        addItem(item, datas.size());
    }

    public void removeItem(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public CommenAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.myLayoutId = layoutId;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.getViewHolder(context, parent, myLayoutId);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bindData(holder, datas.get(position));
    }

    protected abstract void bindData(ViewHolder holder, T item);

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
