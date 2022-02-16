package com.example.totproject.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.common.Common;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.isLogined;
import com.google.gson.Gson;

import java.lang.reflect.Member;

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
                MemberDTO memberDTO = new MemberDTO();
                Gson gson = new Gson();
                //딜레를 주고나서 run을 실행함.
                //Toast.makeText(SplashActivity.this, "여기서 로그인 여부를 판별해 다음 액티비티를 정해야합니다 !", Toast.LENGTH_SHORT).show();
                Intent getIntent = new Intent(getIntent());
                memberDTO = (MemberDTO) getIntent.getSerializableExtra("dto");

                String loginId, loginPwd;
                SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                loginId = auto.getString("inputId", null);
                loginPwd = auto.getString("inputPwd", null);

                if (memberDTO != null) { //로그인액티비티에서 로그인 성공해서 넘어온거면
                    isLogined.isLogined = false;

                    //아무것도 안함

                } else {//어플 처음켠상태라면

                    if ( loginId!=null && loginPwd!=null){ //기기저장정보가 있으면
                        memberDTO.setMember_id(loginId);
                        memberDTO.setMember_pw(loginId);
                        LoginActivity loginActivity = new LoginActivity();
                        if (loginActivity.loginTry(memberDTO) != null){//로그인 성공시
                            //           기기저장정보         있으면
                            //                    기기저장정보로 로그인시도
                            isLogined.isLogined = true;
                        }else{//로그인 실패시  //아무것도안함
                            isLogined.isLogined = false;
                        }
                    } else{//기기저장정보 없으면 아무것도 안해도됨
                        isLogined.isLogined = false;
                    }
                }
                Common.goMain(SplashActivity.this);
               // finish();//뒤로가기 했을때 액티비티가 없게 현재 액티비를 종료시킴.
            }
        }, 3000); // 1초는 == , 1000 * 내가 주고싶은 초

    }
}