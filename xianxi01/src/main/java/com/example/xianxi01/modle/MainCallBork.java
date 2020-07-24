package com.example.xianxi01.modle;

import com.example.xianxi01.bean.DatasBean;
import com.example.xianxi01.bean.Shitilei;

import java.util.List;

public interface MainCallBork {
    void Onsuccess(List<DatasBean> list);
    void OnFail(String str);
}
