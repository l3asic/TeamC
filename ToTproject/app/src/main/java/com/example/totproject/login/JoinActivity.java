package com.example.totproject.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.kwkcommon.CommonAskParam;
import com.example.totproject.kwkcommon.CommonMethod;
import com.example.totproject.kwkcommon.MemberDTO;
import com.example.totproject.kwkcommon.kwkCommonAsk;
import com.google.gson.Gson;

import java.io.InputStream;

public class JoinActivity extends AppCompatActivity {

    EditText join_id, join_pw, join_pw_confirm, join_name, join_nick, join_email, join_tel;
    TextView join_next;
    Button join_id_confirm, join_gender, join_gender_f;
    AlertDialog dialog;
    boolean validate = false;
    //String pwValidation = "^.*(?=^.{4,}$)(?=.*[0-9])(?=.^[a-zA-Z]).*$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_act_join);

        join_id = findViewById(R.id.join_id);
        join_id_confirm = findViewById(R.id.join_id_confirm);
        join_pw = findViewById(R.id.join_pw);
        join_pw_confirm = findViewById(R.id.join_pw_confirm);
        join_tel = findViewById(R.id.join_tell);
        join_name = findViewById(R.id.join_name);
        join_nick = findViewById(R.id.join_nick);
        join_gender = findViewById(R.id.join_gender);
        join_email = findViewById(R.id.join_email);
        join_next = findViewById(R.id.join_next);

        // 아이디 유효성
        join_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length() <5) {
                    join_id.setTextColor(Color.RED);
                }else if(text.matches("!,@,#,$,%,^,&,*")) {
                    join_id.setTextColor(Color.RED);
                }else {
                    join_id.setTextColor(Color.GREEN);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // 아이디 중복확인
        join_id_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate) {

                    return;  //
                }
                if(join_id.getText().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("아이디는 필수 입력값압니다").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

            }
        });// join_id_confirm()


        // 비밀번호 유효성
        join_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length() > 4) {
                    join_pw.setTextColor(Color.GREEN);
                }else {
                    join_pw.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });



        // 비밀번호 확인
        join_pw_confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 if(join_pw_confirm.getText().toString().equals(join_pw.getText().toString())) {
                    join_pw_confirm.setTextColor(Color.GREEN);
                     AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                     dialog = builder.setMessage("비밀번호가 일치합니다").setPositiveButton("확인", null).create();
                     dialog.show();
                }else {
                    join_pw_confirm.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // 아이디, 비번, 핸드폰 미입력 확인
        join_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   if(join_id.getText().length() < 1 || join_pw.getText().length() < 1
                        || join_name.getText().length() <1 || join_nick.getText().length() <1
                        || join_tel.getText().length() < 1 || join_pw_confirm.getText().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("아이디, 비번, 이름, 닉네임,전화번호는  필수 입력값압니다").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }
                else {*/

                    MemberDTO dto = new MemberDTO(
                            join_id.getText() + "testid",
                            join_pw.getText() + "test",
                            join_name.getText() + "test",
                            join_nick.getText() + "test",
                            join_gender.getText() + "f",
                            join_tel.getText() + "010",
                            join_email.getText() + "test"
                    );
                    joinConnect(dto);


                    Intent intent = new Intent(JoinActivity.this, TendencyActivity01.class);
                    startActivity(intent);
              /*  }*/
            }
        });

    } // onCreate()
    CommonMethod commonMethod = new CommonMethod();
    Gson gson = new Gson();
    kwkCommonAsk commonAsk;
    public  void joinConnect (MemberDTO dto) {
        commonAsk = new kwkCommonAsk("join.test");
        String data = gson.toJson(dto);
        commonAsk.params.add(new CommonAskParam("vo",data));


try {


    InputStream in = commonMethod.excuteAsk(commonAsk);
}catch (Exception e) {
    e.printStackTrace();
}



    }
}