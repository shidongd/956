package com.example.kzuo.adap;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kzuo.R;
import com.example.kzuo.base.DataDemo;

import java.util.List;

/**
 * Created by 往事难寻。 on 2018/3/6.
 */
public class LieAdap extends RecyclerView.Adapter<LieAdap.Hello> implements View.OnClickListener {
    private Context context;
    private List<DataDemo.StudentsBean.StudentBean> student;
    public LieAdap(List<DataDemo.StudentsBean.StudentBean> student, FragmentActivity activity) {
        this.context=activity;
        this.student=student;
    }

    @Override
    public Hello onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item_one, parent, false);
        Hello hello=new Hello(inflate);
        inflate.setOnClickListener(this);
        return hello;
    }

    @Override
    public void onBindViewHolder(Hello holder, int position) {
        Glide.with(context).load(student.get(position).getImg()).into(holder.image);
        holder.one.setText(student.get(position).getName());
        holder.two.setText(student.get(position).getContent());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class Hello extends RecyclerView.ViewHolder {

        private  ImageView image;
        private  TextView one;
        private  TextView two;

        public Hello(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_one);
            one = (TextView) itemView.findViewById(R.id.text_one);
            two = (TextView) itemView.findViewById(R.id.text_two);
        }
    }
    public interface OnClickItem {
        void setClick(View v, int position);
    }

    private OnClickItem item;

    @Override
    public void onClick(View v) {
        if (item != null) {
            item.setClick(v, (int) v.getTag());
        }
    }

    public void setOnClick(OnClickItem item) {
        this.item = item;
    }
}
