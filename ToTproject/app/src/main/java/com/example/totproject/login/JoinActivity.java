package com.example.totproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {

    EditText join_id, join_pw, join_pw_confirm, join_tel;
    TextView join_next;
    Button join_id_confirm;
    String email;
    String emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]" +
                "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String pwValidation = "^.*(?=^.{8.20}$)(?=.*[0-9])(?=.*[a-zA-Z](?=.*[!@#$%^&+=]).*$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_act_join);

        join_id = findViewById(R.id.join_id);
        join_id_confirm = findViewById(R.id.join_id_confirm);
        join_pw = findViewById(R.id.join_pw);
        join_pw_confirm = findViewById(R.id.join_pw_confirm);
        join_next = findViewById(R.id.join_next);



        join_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, TendencyActivity01.class);
                startActivity(intent);
            }
        });
    } // onCreate()

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public void check_validation(String email, String password) {
        // 비밀번호 유효성 검사식1 : 숫자, 특수문자가 포함되어야 한다.
        String val_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
        // 비밀번호 유효성 검사식2 : 영문자 대소문자가 적어도 하나씩은 포함되어야 한다.
        String val_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";

        // 정규표현식 컴파일
        Pattern pattern_symbol = Pattern.compile(val_symbol);
        Pattern pattern_alpha = Pattern.compile(val_alpha);

        Matcher matcher_symbol = pattern_symbol.matcher(password);
        Matcher matcher_alpha = pattern_alpha.matcher(password);

        if (matcher_symbol.find() && matcher_alpha.find()) {
            // email과 password로 회원가입 진행
            email_signIn(email, password);
        }else {
            Toast.makeText(this, "비밀번호로 부적절합니다", Toast.LENGTH_SHORT).show();
        }

    }

    private void email_signIn(String email, String password) {

    }
}