package com.example.xianxi01.modle;

import com.example.xianxi01.base.BaseApp;
import com.example.xianxi01.base.BaseModle;
import com.example.xianxi01.base.BaseView;
import com.example.xianxi01.bean.DatasBean;
import com.example.xianxi01.bean.Shitilei;
import com.example.xianxi01.db.DatasBeanDao;
import com.example.xianxi01.net.ApiService;
import com.example.xianxi01.view.Mainview;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModle extends BaseModle {

    private List<DatasBean> datas;

    public void getString(MainCallBork mainCallBork){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getobsetvable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shitilei>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Shitilei shitilei) {
                        //获取到网络集和对象
                        datas = shitilei.getData().getDatas();
                     //获取加工后的数据方法     //创建一个方法，参数为网络获取的集和
                        List<DatasBean> list = initfangfa(datas);
                        //把加工后的数据交给列表展示
                        mainCallBork.Onsuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private List<DatasBean> initfangfa(List<DatasBean> datas) {
        DatasBeanDao datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        //查询数据库所有
        List<DatasBean> loadAll = datasBeanDao.loadAll();
        //循环网络集和数据
        for (int i = 0; i < datas.size(); i++) {
            //获取到集和的索引
            DatasBean bean = datas.get(i);
            //循环数据库中的每个对象
            for (int j = 0; j < loadAll.size(); j++) {
                //根据索引获取当前数据库的对象
                DatasBean datasBean = loadAll.get(j);
                //比较网络中的对象和数据库中的对象看是否有共同点
                if (bean.getTitle().equals(datasBean.getTitle())){
                    //有共同点则为真，适配器得到为真的数据后就会显示为红心状态
                    bean.setXin(true);
                }
            }
        }
        //返回加工后数据
        return datas;
    }
}
