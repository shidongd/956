package com.example.zuoyeo.presenter.contract;

import com.example.zuoyeo.presenter.BasePresenter;
import com.example.zuoyeo.ui.BaseView;

/**
 * Created by 石栋 on 2018/2/27.
 */

public interface Contract {
    interface IPrsenter extends BasePresenter {
        void upfataUI();
        void upfataTWo();
    }
    interface IView<IPrsenter> extends BaseView<IPrsenter> {
        void setdata(String string);
    }
}
