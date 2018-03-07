package com.example.kzuo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kzuo.fragment.LieFragment;
import com.example.kzuo.fragment.ShouFragment;

public class MainActivity extends AppCompatActivity {

    private RadioButton butt;
    private RadioButton butt1;
    private RadioGroup radio;
    private FragmentManager supportFragmentManager;
    private LieFragment lieFragment;
    private ShouFragment shouFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportFragmentManager = getSupportFragmentManager();
        lieFragment = new LieFragment();
        shouFragment = new ShouFragment();
        initView();
        initData();

    }

    private void initData() {
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.butt:
                        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                        transaction.replace(R.id.Fran,lieFragment);
                        transaction.commit();
                        break;
                    case R.id.butt1:
                        FragmentTransaction transaction1 = supportFragmentManager.beginTransaction();
                        transaction1.replace(R.id.Fran,shouFragment);
                        transaction1.commit();
                        break;
                }
            }
        });
    }

    private void initView() {
        butt = (RadioButton) findViewById(R.id.butt);
        butt1 = (RadioButton) findViewById(R.id.butt1);
        radio = (RadioGroup) findViewById(R.id.radio);
    }
}
