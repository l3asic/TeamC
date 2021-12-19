package com.example.test_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.test_account.DTO.MemberDTO;
import com.example.test_account.conn.TestConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Logined extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined);

        try {

            Intent intent = new Intent(this.getIntent());
            String getId = intent.getStringExtra("id");
            Gson gson = new Gson();
            String signInInf = gson.toJson(getId);

            TestConn tc = new TestConn("signIn.acc", "signInInf", signInInf); // 맵핑주소, Json스트링, 식별값

            InputStream is = tc.execute().get();
            ArrayList<MemberDTO> list = gson.fromJson(new InputStreamReader(is),
                    new TypeToken<List<MemberDTO>>() {
                    }.getType());
            adapter.addItem(list);
        } catch (ExecutionException e) {
            Toast.makeText(Logined.this, "에러ㅋㅋ : Logined ExecutionException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (InterruptedException e) {
            Toast.makeText(Logined.this, "에러ㅋㅋ : Logined InterruptedException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



    }
}