package com.example.xianxi01.base;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xianxi01.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
        public P mpresenter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this,view);
        initpresenter();
        if (mpresenter!=null){
            mpresenter.bindVIew(this);
        }
        initView();
        initData();
        initListen();
        return view;
    }
    protected abstract int getLayout();

    protected abstract void initListen();

    protected abstract void initView();

    protected abstract void initpresenter();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpresenter!=null){
            mpresenter.disdory();
            mpresenter=null;
        }
    }
}
