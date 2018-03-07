package com.example.ezuoye.ui.activity4;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ezuoye.R;

public class Main3Activity extends AppCompatActivity {

    private ViewPager vp;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tv = (TextView) findViewById(R.id.tv);
    }
}
