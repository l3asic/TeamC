package com.example.test_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        Button btn_signin = findViewById(R.id.btn_signin);
        Button btn_signon = findViewById(R.id.btn_signon);


        //로그인 눌렀을때
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);// 스플래쉬 말고 로그인 으로
                startActivity(intent);

            }
        });

        //회원가입 눌렀을떄
        btn_signon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignOn.class);
                startActivity(intent);
            }
        });

        //롯데리아 눌렀을떄
        findViewById(R.id.abc123).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });


    }
}