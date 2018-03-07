package com.example.ezuoye.data.model;

import com.example.ezuoye.data.http.Api;
import com.example.ezuoye.data.http.Content;

import retrofit2.Retrofit;

/**
 * Created by 石栋 on 2018/3/6.
 */

public class Modellmp implements IModel{
    @Override
    public void getmsg(Listenerclik listenerclik) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Content.URL).build();
        Api api = retrofit.create(Api.class);
        listenerclik.datamsg(api);
    }
}
