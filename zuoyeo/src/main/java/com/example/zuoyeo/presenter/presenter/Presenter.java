package com.example.zuoyeo.presenter.presenter;

import com.example.zuoyeo.data.http.Api;
import com.example.zuoyeo.data.model.IModel;
import com.example.zuoyeo.data.model.Modellmp;
import com.example.zuoyeo.presenter.contract.Contract;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 石栋 on 2018/2/27.
 */

public class Presenter implements Contract.IPrsenter {
    private Modellmp model;
    private Contract.IView iView;

    public Presenter(Contract.IView iView) {
        this.iView = iView;
        this.model = new Modellmp();
        iView.stePresenter(this);

    }

    @Override
    public void start() {

    }

    @Override
    public void upfataUI() {
        model.getData(new IModel.Liseners() {
            @Override
            public void senddata(Api api) {
                Call<ResponseBody> call = api.getitme();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String string = response.body().string();
                            iView.setdata(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public void upfataTWo() {
        model.getData(new IModel.Liseners() {
            @Override
            public void senddata(Api api) {
                Call<ResponseBody> call = api.getdata();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String string = response.body().string();
                            iView.setdata(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
    }


}
