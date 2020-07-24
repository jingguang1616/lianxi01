package com.example.xianxi01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xianxi01.R;
import com.example.xianxi01.base.BaseApp;
import com.example.xianxi01.bean.DatasBean;
import com.example.xianxi01.bean.Shitilei;
import com.example.xianxi01.db.DatasBeanDao;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Rcyadapter extends RecyclerView.Adapter {
    private ArrayList<DatasBean> list;
    private Context context;
    private View view;
    private DatasBeanDao datasBeanDao;


    public Rcyadapter(ArrayList<DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.buju, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DatasBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.time.setText(bean.getNiceDate());
        holder1.time2.setText(bean.getNiceShareDate());
        holder1.desc.setText(bean.getDesc());
        holder1.dizhi.setText(bean.getSuperChapterName());
        //初始化图片，最开始都是假，判断真假
        if (bean.getXin()){
            holder1.heixin.setImageResource(R.drawable.heart_select);//选中状态
        }else {
            holder1.heixin.setImageResource(R.drawable.heart_unselect);//默认状态，空心
        }
        datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
            //对图片进行监听
        holder1.heixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean xin = bean.getXin();//获取当前图片状态
                bean.setXin(!xin);//更改图片状态，非真及假，非假及真
                //当更改完图片的状态在次判断更改后的图片状态，样式
                if (bean.getXin()){
                    //当图片为选中状态时插入数据库
                    holder1.heixin.setImageResource(R.drawable.heart_select);
                    datasBeanDao.insertOrReplace(bean);
                }else {
                    //为选中时从数据库中删除该对象
                    holder1.heixin.setImageResource(R.drawable.heart_unselect);
                    datasBeanDao.delete(bean);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.time2)
        TextView time2;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.dizhi)
        TextView dizhi;
        @BindView(R.id.heixin)
        ImageView heixin;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
