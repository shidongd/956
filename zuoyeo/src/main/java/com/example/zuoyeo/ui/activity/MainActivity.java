package com.example.zuoyeo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.example.zuoyeo.R;
import com.example.zuoyeo.presenter.presenter.Presenter;
import com.example.zuoyeo.ui.fragment.AFragment;
import com.example.zuoyeo.ui.fragment.BFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private RadioButton shi;
    private RadioButton but_zi;
    private ArrayList<Fragment> list;
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private RadioButton le;
    private RadioButton wo;
    private LinearLayout lin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        list = new ArrayList<>();
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        list.add(aFragment);
        list.add(bFragment);
        MyAdapter myAdaper = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdaper);
        Presenter presenter = new Presenter(aFragment);
        Presenter presenter1 = new Presenter(bFragment);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        shi = (RadioButton) findViewById(R.id.shi);
        but_zi = (RadioButton) findViewById(R.id.but_zi);
        shi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
            }
        });
        but_zi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1);
            }
        });
        le = (RadioButton) findViewById(R.id.le);
        wo = (RadioButton) findViewById(R.id.wo);
        lin = (LinearLayout) findViewById(R.id.lin);
        lin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (getTaskId()){
            case R.id.shi:
                vp.setCurrentItem(0);
                break;
            case R.id.but_zi:
                vp.setCurrentItem(1);
                break;
            case R.id.le:
                vp.setCurrentItem(2);
                break;
            case R.id.wo:
                vp.setCurrentItem(3);
                break;
        }
    }

    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
