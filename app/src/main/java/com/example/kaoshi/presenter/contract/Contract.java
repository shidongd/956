package com.example.kaoshi.presenter.contract;

import com.example.kaoshi.presenter.BasePresenter;
import com.example.kaoshi.ui.BaseView;

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
