package com.example.zuoyeo.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoyeo.Beans;
import com.example.zuoyeo.R;
import com.example.zuoyeo.presenter.contract.Contract;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements Contract.IView<Contract.IPrsenter> {


    private Contract.IPrsenter iPrsenter;
    private FlyBanner banner;
    private RecyclerView rvs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        iPrsenter.upfataTWo();
        initData();
        return inflate;
    }

    private void initData() {
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        banner.setImages(images);
    }

    @Override
    public void stePresenter(Contract.IPrsenter iPrsenter) {
        this.iPrsenter = iPrsenter;

    }

    @Override
    public void setdata(String string) {
        Gson gson = new Gson();
        Beans beans = gson.fromJson(string, Beans.class);
        List<Beans.ResultBean.DataBean> list = beans.getResult().getData();
        rvs.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapters myAdapter=new MyAdapters(list,getActivity());
        rvs.setAdapter(myAdapter);
        myAdapter.seteOnClickListener(new MyAdapters.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
            }
        });
    }

    private void initView(View inflate) {
        banner = (FlyBanner) inflate.findViewById(R.id.banner);
        rvs = (RecyclerView) inflate.findViewById(R.id.rvs);
    }
}
