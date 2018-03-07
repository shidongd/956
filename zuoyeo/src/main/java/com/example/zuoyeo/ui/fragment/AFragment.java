package com.example.zuoyeo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;


import com.example.zuoyeo.Bean;
import com.example.zuoyeo.R;
import com.example.zuoyeo.presenter.contract.Contract;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements Contract.IView<Contract.IPrsenter> {


    private FlyBanner banner;
    private int[] icon = {R.drawable.icon_main_free_travel, R.drawable.icon_main_airticket, R.drawable.icon_main_visa, R.drawable.icon_main_destination_travel, R.drawable.icon_main_half_free, R.drawable.icon_main_hotel, R.drawable.icon_main_ticket, R.drawable.icon_main_other_product};
    private String[] iconName = {"自由行", "机票", "签证", "目的地参团", "半自由行", "酒店", "门票", "其他"};
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private RecyclerView rv;
    private Object data;
    private Contract.IPrsenter iPrsenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
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
        iPrsenter.upfataUI();
    }

    @Override
    public void setdata(String string) {
        final Gson gson = new Gson();
        Bean bean = gson.fromJson(string, Bean.class);
        List<Bean.ResultBean.DataBean> list = bean.getResult().getData();
        MyAdapter myAdapter = new MyAdapter(list, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(myAdapter);
        myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

        });
    }

    private void initView(View inflate) {
        banner = (FlyBanner) inflate.findViewById(R.id.banner);
        gview = (GridView) inflate.findViewById(R.id.gview);
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
