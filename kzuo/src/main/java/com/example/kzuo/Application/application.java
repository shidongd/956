package com.example.kzuo.Application;

import android.app.Application;

import com.example.kao.DaoMaster;
import com.example.kao.DaoSession;


public class application extends Application {
    public static application application;
    private DaoSession daoSession;

    private static application application() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        DaoMaster.DevOpenHelper mast = new DaoMaster.DevOpenHelper(this, "stu.db");
        DaoMaster daoMaster = new DaoMaster(mast.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoSession getdaoSession() {

        return daoSession;
    }

}
