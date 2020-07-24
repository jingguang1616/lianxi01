package com.example.xianxi01.presenter;

import com.example.xianxi01.base.BasePresenter;
import com.example.xianxi01.bean.DatasBean;
import com.example.xianxi01.bean.Shitilei;
import com.example.xianxi01.modle.MainCallBork;
import com.example.xianxi01.modle.MainModle;
import com.example.xianxi01.view.Mainview;

import java.util.List;

public class Mainpresenter extends BasePresenter<Mainview> implements MainCallBork {

    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
    }

    @Override
    public void Onsuccess(List<DatasBean> list) {
        mview.setData(list);
    }

    @Override
    public void OnFail(String str) {
        mview.showTosat(str);
    }

    public void getString() {
        mainModle.getString(this);
    }
}
