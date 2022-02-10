package com.example.totproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.main.MainActivity;

public class TendencyActivity02 extends AppCompatActivity {
    Button tend2_btn_skip, tend2_btn_join;
    int tabcode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency_activity_02);

        tend2_btn_skip = findViewById(R.id.tend2_btn_skip);
        tend2_btn_join = findViewById(R.id.tend2_btn_join);

        tend2_btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity02.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend2_btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}