package com.example.ezuoye.data.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 石栋 on 2018/3/6.
 */

public interface Api {
    @GET(".")
    Call<ResponseBody> getitme();
}
