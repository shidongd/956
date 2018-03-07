package com.example.ezuoye.ui.activity4;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ezuoye.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      startActivity(new Intent(MainActivity.this, Main2Activity.class));
                  }
              },3000);
    }
}
