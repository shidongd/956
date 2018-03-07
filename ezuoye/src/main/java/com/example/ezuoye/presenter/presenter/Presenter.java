package com.example.ezuoye.presenter.presenter;

import com.example.ezuoye.data.http.Api;
import com.example.ezuoye.data.model.IModel;
import com.example.ezuoye.data.model.Modellmp;
import com.example.ezuoye.presenter.contracty.Contracty;
import com.example.ezuoye.presenter.contracty.Contracty.IPresenter;
import com.example.ezuoye.ui.activity4.Main2Activity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 石栋 on 2018/3/6.
 */

public class Presenter implements IPresenter{
    private  Modellmp modle;
    private  Contracty.IView iView;

    public Presenter(Contracty.IView iView) {
        this.iView=iView;
        this.modle=new Modellmp();
        iView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void upfataUI() {
        modle.getmsg(new IModel.Listenerclik() {
            @Override
            public void datamsg(Api api) {
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
}
