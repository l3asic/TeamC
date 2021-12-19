package com.example.test_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_account.DTO.MemberDTO;
import com.example.test_account.conn.TestConn;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;


public class SignIn extends AppCompatActivity {
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        EditText signin_edt_id = findViewById(R.id.signin_edt_id);
        EditText signin_edt_pw = findViewById(R.id.signin_edt_pw);
        btn_login.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    MemberDTO dto = new MemberDTO(signin_edt_id.getText() + "", signin_edt_pw.getText() + "");

                    Gson gson = new Gson();
                    String signInInf = gson.toJson(dto);

                    TestConn tc = new TestConn("signIn.acc", "signInInf", signInInf); // 맵핑주소, Json스트링, 식별값

                    tc.execute().get();
                } catch (ExecutionException e) {
                    Toast.makeText(SignIn.this, "에러ㅋㅋ : SignIn ExecutionException", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    Toast.makeText(SignIn.this, "에러ㅋㅋ : SignIn InterruptedException", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                Intent intent = new Intent(SignIn.this, Logined.class);
                intent.putExtra("id", signin_edt_id.getText());
                startActivity(intent);


            }
        });


    }
}