package com.tim.rxandroiddemo.mylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tim.rxandroiddemo.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gensun on 16/4/28.
 */
public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.RepoViewHolder> {
    private ArrayList<Repo> mRepos; // 库信息


    public void setmRepos(ArrayList<Repo> mRepos) {
        this.mRepos = mRepos;
//        notifyItemInserted(mRepos.size() - 1);

        notifyDataSetChanged();
    }

    public MyListAdapter() {
        this.mRepos = new ArrayList<>();
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bindTo(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public static class Repo {
        public String name; // 库的名字
        public String description; // 描述
        public String language; // 语言


        public Repo() {
        }

        public Repo(String name, String description, String language) {
            this.name = name;
            this.description = description;
            this.language = language;
        }
    }


    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_iv_repo_name)
        TextView mItemIvRepoName;
        @Bind(R.id.item_iv_repo_detail)
        TextView mItemIvRepoDetail;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindTo(Repo repo) {
            mItemIvRepoName.setText(repo.name);
            mItemIvRepoDetail.setText(String.valueOf(repo.description + "(" + repo.language + ")"));
        }
    }
}
