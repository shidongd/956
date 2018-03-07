package com.example.kaoshi.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.kaoshi.R;
import com.example.kaoshi.presenter.presenter.Presenter;
import com.example.kaoshi.ui.fragment.AFragment;
import com.example.kaoshi.ui.fragment.BFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioButton shi;
    private RadioButton but_zi;
    private ArrayList<Fragment> list;
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private ArrayList<Tab> mTabs= new ArrayList<Tab>(5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initTab();
    }
    private void initTab() {
        //实例化5个Tab类的对象
        Tab Tab_home = new Tab(R.drawable.bian,R.string.home,AFragment.class);
        Tab Tab_hot = new Tab(R.drawable.bian,R.string.hot, BFragment.class);


        //将这5个对象加到一个List中
        mTabs.add(Tab_home);
        mTabs.add(Tab_hot);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realcontent);
        mInflater = LayoutInflater.from(this);

        //通过循环实例化一个个TabSpec
        //并调用其中setIndicator方法
        //然后将TabSpec加到TabHost中
        for (Tab tab  :mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(String.valueOf(tab.getText()));
            tabSpec.setIndicator(buildView(tab));
            mTabHost.addTab(tabSpec,tab.getFragment(), null);
        }

        //通过这行代码可以去除掉底部菜单5个图表之间的分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);    }

    //设置Indicator中的View
    private View buildView(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator,null);
//        ImageView Tab_img = (ImageView) view.findViewById(R.id.tab_img);
//        TextView Tab_txt = (TextView) view.findViewById(R.id.tab_txt);
//
//        Tab_img.setBackgroundResource(tab.getImage());
//        Tab_txt.setText(tab.getText());
        return view;
    }


    private void initData() {
        list = new ArrayList<>();
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        list.add(aFragment);
        list.add(bFragment);
        MyAdapter myAdaper=new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdaper);
        Presenter presenter = new Presenter(aFragment);
        Presenter presenter1 = new Presenter(bFragment);
    }

    private void initView() {
//        vp = (ViewPager) findViewById(R.id.vp);
//        shi = (RadioButton) findViewById(R.id.shi);
//        but_zi = (RadioButton) findViewById(R.id.but_zi);
//        shi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vp.setCurrentItem(0);
//            }
//        });
//        but_zi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vp.setCurrentItem(1);
//            }
//        });
    }

    private class MyAdapter extends FragmentPagerAdapter{
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
