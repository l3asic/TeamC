package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tendency2Activity extends AppCompatActivity {
    Button tend2_btn1_skip, tend2_btn2_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency2);

        tend2_btn1_skip = findViewById(R.id.tend2_btn1_skip);
        tend2_btn2_join = findViewById(R.id.tend2_btn2_join);

        tend2_btn1_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tendency2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend2_btn2_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tendency2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}