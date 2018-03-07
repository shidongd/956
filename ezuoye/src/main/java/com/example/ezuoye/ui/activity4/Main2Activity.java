package com.example.ezuoye.ui.activity4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ezuoye.Beans;
import com.example.ezuoye.R;
import com.example.ezuoye.presenter.contracty.Contracty;
import com.example.ezuoye.presenter.presenter.Presenter;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Contracty.IView<Contracty.IPresenter>{

    private FlyBanner banner;
    private RecyclerView rv;
    private Contracty.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Presenter iPresenter = new Presenter(this);
        initData();

    }

    private void initData() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a);
        images.add(R.drawable.b);
        images.add(R.drawable.e);
        images.add(R.drawable.f);
        banner.setImages(images);
    }

    private void initView() {
        banner = (FlyBanner) findViewById(R.id.banner);
        rv = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void setPresenter(Contracty.IPresenter iPresenter) {
        this.iPresenter=iPresenter;
        iPresenter.upfataUI();
    }

    @Override
    public void setdata(String string) {
        Gson gson=new Gson();
        Beans beans = gson.fromJson(string, Beans.class);
        final List<Beans.ResultBean.DataBean> data = beans.getResult().getData();
        MyAdapter myAdapter=new MyAdapter(Main2Activity.this,data);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myAdapter);
        myAdapter.HH(new MyAdapter.MM() {
            @Override
            public void MY(View view, int position) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                intent.putExtra("tu",data.get(position).getThumbnail_pic_s());
                intent.putExtra("tu2",data.get(position).getThumbnail_pic_s02());
                intent.putExtra("tu3",data.get(position).getThumbnail_pic_s03());
                startActivity(intent);
            }
        });
    }
}