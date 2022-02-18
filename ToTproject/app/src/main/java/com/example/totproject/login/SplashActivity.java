package com.example.totproject.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.totproject.R;
import com.example.totproject.common.Common;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.Logined;

public class SplashActivity extends AppCompatActivity {
    String loginId, loginPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00_splash);

        /* ============================== 전체화면 ============================== */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* ====================================================================================== */

        /* ============================== get Intent 유무 판별 ============================== */
        Intent getIntent = new Intent(getIntent());
        MemberDTO dtoFromLoginAct = (MemberDTO) getIntent.getSerializableExtra("dto");
        /* ====================================================================================== */

        /* ============================== 기기저장 객체화 ============================== */
        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = auto.edit();
        /* ====================================================================================== */

        /* ============================== 저장 정보 기입 ============================== */
        loginId = auto.getString("inputId", null);
        loginPw = auto.getString("inputPw", null);
        /* ====================================================================================== */

        MemberDTO dto = new MemberDTO();                     //memberDTO 사용시 어플 꺼져서 새로선언

        /* ============================== 로그인시도 ============================== */
/*        if (dtoFromLoginAct != null) {
            spEditor.putString("inputId", dtoFromLoginAct.getMember_id());
            spEditor.putString("inputPw", dtoFromLoginAct.getMember_pw());
            spEditor.commit();
            isLogined.isLogined = true;
             *//*=============여기 쫌더 예쁘게 만들수있음 =======================================*//*
        loginId = auto.getString("inputId", null);
        loginPw = auto.getString("inputPw", null);
        dto.setMember_id(loginId);
        dto.setMember_pw(loginPw);
        LoginActivity loginActivity = new LoginActivity();
        dto = loginActivity.loginTry(dto);
        } else {
            if (loginId != null && loginPw != null) {
                dto.setMember_id(loginId);
                dto.setMember_pw(loginPw);
                LoginActivity loginActivity = new LoginActivity();
                  dto = loginActivity.loginTry(dto);
                if (dto != null) {
                    isLogined.isLogined = true;
                } else {
                    isLogined.isLogined = false;
                }
            } else {
                isLogined.isLogined = false;
            }
        }*/
        if (loginId == null && loginPw == null) {
            if (dtoFromLoginAct == null) {
                Logined.isLogined = false;
            } else {
                spEditor.putString("inputId", dtoFromLoginAct.getMember_id());
                spEditor.putString("inputPw", dtoFromLoginAct.getMember_pw());
                spEditor.commit();
                Logined.isLogined = true;
                /*=============여기 쫌더 예쁘게 만들수있음 =======================================*/
                dto = dtoFromLoginAct;
            }
        } else {    /* ========= 로그인정보로 재로그인 (유저정보변경 확인) ========== */
            dto.setMember_id(loginId);
            dto.setMember_pw(loginPw);
            LoginActivity loginActivity = new LoginActivity();
            dto = loginActivity.loginTry(dto);
            if (dto == null) {
                Logined.isLogined = false;
            } else {
                Logined.isLogined = true;
            }
        }
        /* ====================================================================================== */

        /* =============================== 기기에 로그인 정보 옮김 =============================== */
        Logined.member_id = dto.getMember_id();
        Logined.member_pw = dto.getMember_pw();
        Logined.member_name = dto.getMember_name();
        Logined.member_nick = dto.getMember_nick();
        Logined.member_gender = dto.getMember_gender();
        Logined.member_tel = dto.getMember_tel();
        Logined.member_email = dto.getMember_email();
//isLogined.member_grade = dto.getMember_gender(); // 필드에 Grade(등급) 없음
        Logined.member_is_kakao = dto.getKakao();
        Logined.member_is_naver = dto.getNaver();
        /* ====================================================================================== */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* ============================== 로그인확인 안내 ============================== */
                if (Logined.member_id != null) {
                    Toast.makeText(SplashActivity.this, "로그인 : " + Logined.member_id, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SplashActivity.this , "Trip Or Trap", Toast.LENGTH_SHORT).show();
                }
                /* ============================================================================== */

                /* ==================== 스플래시 종료, 액티비티 초기화 ==================== */
                Common.goMain(SplashActivity.this);
                ActivityCompat.finishAffinity(SplashActivity.this);
                /* ============================================================================== */
            }
        }, 300);//Handler()
    }//onCreate
}

