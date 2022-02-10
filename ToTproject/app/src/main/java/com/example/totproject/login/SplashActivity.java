package com.example.totproject.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.common.Common;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00_splash);

    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //딜레를 주고나서 run을 실행함.
                //Toast.makeText(SplashActivity.this, "여기서 로그인 여부를 판별해 다음 액티비티를 정해야합니다 !", Toast.LENGTH_SHORT).show();

                Common.goMain(SplashActivity.this);
                finish();//뒤로가기 했을때 액티비티가 없게 현재 액티비를 종료시킴.
            }
        } ,  300); // 1초는 == , 1000 * 내가 주고싶은 초

    }
}