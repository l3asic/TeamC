package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TendencyActivity extends AppCompatActivity {

    Button tend_btn1_skip, tend_btn2_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendenacyctivity);

        tend_btn1_skip = findViewById(R.id.tend_btn1_skip);
        tend_btn2_next = findViewById(R.id.tend_btn2_next);

        tend_btn1_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend_btn2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity.this, Tendency2Activity.class);
                startActivity(intent);
            }
        });
    }
}