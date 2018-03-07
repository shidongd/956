package com.example.ezuoye.presenter.contracty;

import com.example.ezuoye.presenter.BasePresenter;
import com.example.ezuoye.ui.BaseView;

/**
 * Created by 石栋 on 2018/3/6.
 */

public interface Contracty {
    interface IPresenter extends BasePresenter {
        void upfataUI();
    }
    interface IView<IPresenter> extends BaseView<IPresenter> {
        void setdata(String string);
    }
}
