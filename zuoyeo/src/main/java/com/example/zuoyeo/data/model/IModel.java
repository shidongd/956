package com.example.zuoyeo.data.model;

import com.example.zuoyeo.data.http.Api;

/**
 * Created by 石栋 on 2018/2/27.
 */

public interface IModel {
    void getData(Liseners liseners);
    interface Liseners{
        void senddata(Api api);
    }
}
