package com.example.kaoshi.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.kaoshi.Bean;
import com.example.kaoshi.R;
import com.example.kaoshi.presenter.contract.Contract;
import com.example.kaoshi.ui.activity.Apy;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements Contract.IView<Contract.IPrsenter> {


    private FlyBanner banner;
    private int[] icon = {R.drawable.story_icon_new,R.drawable.story_icon_morning,R.drawable.story_icon_sleep,R.drawable.story_icon_classify};
    private String[] iconName = {"最新", "叫早", "哄睡", "全部"};
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
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
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
            this.iPrsenter=iPrsenter;
            iPrsenter.upfataUI();
    }

    @Override
    public void setdata(String string) {
        final Gson gson=new Gson();
        Bean bean = gson.fromJson(string, Bean.class);
        List<Bean.ResultBean.DataBean> list = bean.getResult().getData();
        MyAdapter myAdapter=new MyAdapter(list,getActivity());
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

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
