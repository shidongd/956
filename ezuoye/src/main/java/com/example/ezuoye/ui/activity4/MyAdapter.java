package com.example.ezuoye.ui.activity4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ezuoye.Beans;
import com.example.ezuoye.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 石栋 on 2018/3/6.
 */

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Beans.ResultBean.DataBean> data;

    public MyAdapter(Context context, List<Beans.ResultBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {

        int i = position % 2;
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        }
        return 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
            viewHolder = new One(inflate);
        } else {
            View inflate1 = LayoutInflater.from(context).inflate(R.layout.item2, null);
            viewHolder = new Two(inflate1);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            One holder1 = (One) holder;
            Picasso.with(context).load(data.get(position).getThumbnail_pic_s()).into(holder1.im);
            Picasso.with(context).load(data.get(position).getThumbnail_pic_s03()).into(holder1.img);
            holder1.tv_name.setText(data.get(position).getAuthor_name());
            holder1.tv_title.setText(data.get(position).getTitle());
            holder1.itemView.setTag(position);
        } else {
            Two holder2 = (Two) holder;
            Picasso.with(context).load(data.get(position).getThumbnail_pic_s03()).into(holder2.imgs);
            Picasso.with(context).load(data.get(position).getThumbnail_pic_s()).into(holder2.ims);
            Picasso.with(context).load(data.get(position).getThumbnail_pic_s()).into(holder2.is);
            holder2.tv_names.setText(data.get(position).getAuthor_name());
            holder2.tv_titles.setText(data.get(position).getTitle());
            holder2.itemView.setTag(position);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mm.MY(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class One extends RecyclerView.ViewHolder {


        private TextView tv_name;
        private ImageView im;
        private ImageView img;
        private TextView tv_title;

        public One(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            im = itemView.findViewById(R.id.im);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    class Two extends RecyclerView.ViewHolder {


        private TextView tv_names;
        private ImageView ims;
        private ImageView imgs;
        private ImageView is;
        private TextView tv_titles;

        public Two(View itemView) {
            super(itemView);
            tv_names = itemView.findViewById(R.id.tv_names);
            ims = itemView.findViewById(R.id.ims);
            imgs = itemView.findViewById(R.id.imgs);
            is = itemView.findViewById(R.id.is);
            tv_titles = itemView.findViewById(R.id.tv_titles);
        }
    }

    public interface MM {
        void MY(View view, int position);
    }

    private MM mm;

    public void HH(MM mm) {
        this.mm = mm;
    }

}
