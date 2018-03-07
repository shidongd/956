package com.example.kaoshi.data.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 石栋 on 2018/2/27.
 */

public interface Api {
    @GET("qinzi.json")
    Call<ResponseBody> getitme();
    @GET("gushi.json")
    Call<ResponseBody> getdata();
}
