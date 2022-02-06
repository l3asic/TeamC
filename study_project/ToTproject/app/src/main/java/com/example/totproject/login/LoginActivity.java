package com.example.totproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;
import com.example.totproject.main.MainActivity;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.kakao.sdk.user.model.Profile;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
  Button login_btn_login;
  EditText edit_login_id, edit_login_pw;
  TextView text_login_join;
  Button kakaologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act_login);
        login_btn_login = findViewById(R.id.login_btn_login);
        text_login_join =findViewById(R.id.text_login_join);
        edit_login_id = findViewById(R.id.edit_login_id);
        edit_login_pw = findViewById(R.id.edit_login_pw);
        kakaologin = findViewById(R.id.imgv_kakaologin);

        // Kakao SDK 초기화
        KakaoSdk.init(this, "77f34c0e0e72631cebb2c001a7e0257a");

        // 로그인
        login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if((edit_login_id.getText()+"").equals("aaa") && (edit_login_pw.getText()+"").equals("aaa") ) {
                   Toast.makeText(LoginActivity.this, "로그인 되었습니다", Toast.LENGTH_SHORT).show();
                goMain();
               } else {
                   Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호틀림", Toast.LENGTH_SHORT).show();
               }


            }
        });

        // 회원가입
        text_login_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });


        // 로그인 공통 callback 구성

        //https://developers.kakao.com/docs/latest/ko/kakaologin/android
        //kotlin ↓ 자바로 바꿈
        Function2<OAuthToken , Throwable , Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Toast.makeText(LoginActivity.this, "정보를 받아옴", Toast.LENGTH_SHORT).show();
                   getKakaoinfo();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                if(throwable != null){
                    Toast.makeText(LoginActivity.this, "뭔가 오류가남.", Toast.LENGTH_SHORT).show();
                }

                return null;
            }
        };


        // 카카오 로그인
        kakaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
               if( UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                   Toast.makeText(LoginActivity.this, "카카오톡 설치됨", Toast.LENGTH_SHORT).show();
                   UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,callback);
               }else {
                   Toast.makeText(LoginActivity.this, "카카오톡 설치 안됨", Toast.LENGTH_SHORT).show();
                   UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,callback);
               }
              
            }
        });

    }// onCreate()

    public void getKakaoinfo() {
        UserApiClient.getInstance().me( (user, throwable) -> {
            if(throwable != null){
                //오류가 났을때 어떤 오류인지 알아볼수가 있음 . KOE + 숫자
            }else{
                // [ {  }  ] json 구조처럼 바로 데이터가 있는게 아니라 Account라는 키로 한칸을 들어가고
                //여기안에서 또 profile이라는 칸으로 또 이동 .
                Account kakaoAcount = user.getKakaoAccount();
                if(kakaoAcount != null){
                    Profile profile = kakaoAcount.getProfile();
                    if(profile != null){
                        Toast.makeText(LoginActivity.this, profile.getNickname()+"님 환영", Toast.LENGTH_SHORT).show();
                        goMain();
                    }
                }
            }

            return  null;
        }) ;

    }

    public void goMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

}