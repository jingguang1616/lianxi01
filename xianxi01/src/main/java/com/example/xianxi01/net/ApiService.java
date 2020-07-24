package com.example.xianxi01.net;

import com.example.xianxi01.bean.Shitilei;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//
    String URL="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Shitilei> getobsetvable();
}
