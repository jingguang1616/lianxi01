package com.example.xianxi01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xianxi01.adapter.Rcyadapter;
import com.example.xianxi01.base.BaseFragment;
import com.example.xianxi01.bean.DatasBean;
import com.example.xianxi01.bean.Shitilei;
import com.example.xianxi01.presenter.Mainpresenter;
import com.example.xianxi01.view.Mainview;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseFragment<Mainpresenter> implements Mainview {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private View view;
    private ArrayList<DatasBean> list;
    private Rcyadapter rcyadapter;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_2;
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcy.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        rcyadapter = new Rcyadapter(list, getActivity());
        rcy.setAdapter(rcyadapter);
    }

    @Override
    protected void initpresenter() {
        mpresenter=new Mainpresenter();
    }

    @Override
    protected void initData() {
        mpresenter.getString();
    }

    @Override
    public void setData(List<DatasBean> data) {
        list.clear();
        list.addAll(data);
        rcyadapter.notifyDataSetChanged();
    }

    @Override
    public void showTosat(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view = inflater.inflate(R.layout.fragment_2, container, false);
//
//        return view;
//    }
}
