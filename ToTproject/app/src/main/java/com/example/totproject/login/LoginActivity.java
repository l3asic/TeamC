package com.example.totproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.main.MainActivity;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.kakao.sdk.user.model.Profile;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.nhn.android.naverlogin.OAuthLogin;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    Button login_btn_login;
    EditText edit_login_id, edit_login_pw;
    TextView text_login_join, search_id, search_pw;
    Button kakaologin;
    OAuthLogin authLogin ;
    NidOAuthLoginButton naverlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act_login);
        login_btn_login = findViewById(R.id.login_btn_login);
        text_login_join =findViewById(R.id.text_login_join);
        edit_login_id = findViewById(R.id.edit_login_id);
        edit_login_pw = findViewById(R.id.edit_login_pw);
        search_id = findViewById(R.id.search_id);
        search_pw = findViewById(R.id.search_pw);
        kakaologin = findViewById(R.id.kakaologin);

        // Naver 로그인
        authLogin = OAuthLogin.getInstance();
        authLogin.showDevelopersLog(true);
        authLogin.init(
                LoginActivity.this,
                "uGpmI5HP4456GOdaotwq",
                "ElhUyTFWhH",
                "ToT"
        );
        naverlogin = findViewById(R.id.naverlogin);
        naverlogin.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                String accesToken = authLogin.getAccessToken(LoginActivity.this);
                String refreshToken = authLogin.getRefreshToken(LoginActivity.this);
                Toast.makeText(LoginActivity.this, "네이버로그인 성공", Toast.LENGTH_SHORT).show();
                goMain();

            }

            @Override
            public void onFailure(int i, @NonNull String s) {

            }

            @Override
            public void onError(int i, @NonNull String s) {

            }
        });


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

        // 아이디 찾기
        search_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "터치 확인", Toast.LENGTH_SHORT).show();
            }
        });

        // 비밀번호 찾기
        search_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "터치 확인", Toast.LENGTH_SHORT).show();
            }
        });


        // 회원가입
        text_login_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TendencyActivity01.class);
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