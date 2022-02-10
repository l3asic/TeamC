package com.example.totproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.main.MainActivity;

public class TendencyActivity01 extends AppCompatActivity {

    Button tend_btn_skip, tend_btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency_activity_01);

        tend_btn_skip = findViewById(R.id.tend_btn_skip);
        tend_btn_next = findViewById(R.id.tend_btn_next);

        tend_btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity01.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity01.this, TendencyActivity02.class);
                startActivity(intent);
            }
        });
    }
}