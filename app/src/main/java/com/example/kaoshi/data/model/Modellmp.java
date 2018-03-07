package com.example.kaoshi.data.model;

import com.example.kaoshi.data.http.Api;
import com.example.kaoshi.data.http.Contern;

import retrofit2.Retrofit;

/**
 * Created by 石栋 on 2018/2/27.
 */

public class Modellmp implements IModel{
    @Override
    public void getData(Liseners liseners) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Contern.URL).build();
        Api api = retrofit.create(Api.class);
        liseners.senddata(api);
    }
}
