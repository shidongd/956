package com.example.kaoshi.data.model;

import com.example.kaoshi.data.http.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by 石栋 on 2018/2/27.
 */

public interface IModel {
    void getData(Liseners liseners);
    interface Liseners{
        void senddata(Api api);
    }
}
