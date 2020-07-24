package com.example.zhoukao;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Interpolator;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {

    }
    public class Loginint implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.e("111",String.format("发送请求地址：%s%n请求头%s",request.url(),request.headers()));
            long stact = System.currentTimeMillis();
            Response proceed = chain.proceed(request);

            return null;
        }
    }
}
