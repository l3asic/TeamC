package com.example.test_account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_account.DTO.MemberDTO;
import com.example.test_account.conn.TestConn;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SignOn extends AppCompatActivity {
    EditText signon_edt_id, signon_edt_pw, signon_edt_name, signon_edt_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_on);
        signon_edt_id = findViewById(R.id.signon_edt_id);
        signon_edt_pw = findViewById(R.id.signon_edt_pw);
        signon_edt_name = findViewById(R.id.signon_edt_name);
        signon_edt_birth = findViewById(R.id.signon_edt_birth);

        //회원가입 버튼 눌렀을떄
        findViewById(R.id.signon_btn_signon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    int birth = Integer.parseInt(signon_edt_birth.getText()+"");

                    MemberDTO dto = new MemberDTO(
                            signon_edt_id.getText() + "",
                            signon_edt_pw.getText() + "",
                            signon_edt_name.getText() + "",
                            birth
                    );


                    Gson gson = new Gson();
                    String signOnInf = gson.toJson(dto);


                    TestConn tc = new TestConn("signOn.acc", signOnInf, "signON"); // 맵핑주소, Json스트링, 식별값
                    tc.execute().get();
                    //디비insert into 해야됨;; settext->append?
                    /*        Intent intent = new Intent(SignOn.this, SignIn.class);*/

                    /*                intent.putExtra("list", list);*/





                    /*    startActivity(intent);*/


                } catch (Exception e) {
                    Toast.makeText(SignOn.this, "트라이캐치", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //취소하기 버튼 눌렀을때
        findViewById(R.id.signon_btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignOn.this, SignIn.class);
                startActivity(intent);
            }
        });


    }
}