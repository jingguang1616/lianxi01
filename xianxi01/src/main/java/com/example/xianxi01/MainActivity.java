package com.example.xianxi01;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.xianxi01.fragment.Fragment1;
import com.example.xianxi01.fragment.Fragment3;
import com.example.xianxi01.fragment.Fragment4;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tab)
    TabLayout tab;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(tb);
        FragmentManager manager = getSupportFragmentManager();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        manager.beginTransaction().add(R.id.fl,fragment1).add(R.id.fl,fragment2).add(R.id.fl,fragment3).add(R.id.fl,fragment4)
                .show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4)
                .commit();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.ic_launcher_background));
        tab.addTab(tab.newTab().setText("广场").setIcon(R.drawable.ic_launcher_background));
        tab.addTab(tab.newTab().setText("公众号").setIcon(R.drawable.ic_launcher_background));
        tab.addTab(tab.newTab().setText("体系").setIcon(R.drawable.ic_launcher_background));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    manager.beginTransaction().show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4).commit();
                }else if (tab.getPosition()==1){
                    manager.beginTransaction().show(fragment2).hide(fragment1).hide(fragment3).hide(fragment4).commit();
                }else if (tab.getPosition()==2){
                    manager.beginTransaction().show(fragment3).hide(fragment2).hide(fragment1).hide(fragment4).commit();
                }else if (tab.getPosition()==3){
                    manager.beginTransaction().show(fragment4).hide(fragment2).hide(fragment3).hide(fragment1).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
