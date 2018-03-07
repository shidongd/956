package com.example.kaoshi.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kaoshi.Bean;
import com.example.kaoshi.R;
import com.example.kaoshi.ui.activity.Apy;

import java.util.List;
import java.util.Random;

/**
 * Created by 石栋 on 2018/2/28.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Bean.ResultBean.DataBean> list;
        private Context context;
    private OnClickListener listener;

    public MyAdapter(List<Bean.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder.img);
            holder.name.setText(list.get(position).getAuthor_name());
            holder.title.setText(list.get(position).getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, Apy.class));
                    listener.onClick(view,position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView title;
            private TextView name;
            private ImageView img;

            public ViewHolder(View itemView) {
                super(itemView);

                title = (TextView) itemView.findViewById(R.id.tv_title);
                name = (TextView) itemView.findViewById(R.id.tv_name);
                img = (ImageView) itemView.findViewById(R.id.img);

            }
        }
        public interface OnClickListener{

            void onClick(View view, int position);
        }
        public void setOnClickListener(OnClickListener listener){
            this.listener = listener;
        }
}
