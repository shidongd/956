package com.example.ezuoye.data.model;

import com.example.ezuoye.data.http.Api;

/**
 * Created by 石栋 on 2018/3/6.
 */

public interface IModel {
    void getmsg(Listenerclik listenerclik);
    interface Listenerclik{
        void datamsg(Api api);
    }
}
