package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tendencyctivity extends AppCompatActivity {

    Button tend_btn1, tend_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendencyctivity);

        tend_btn1 = findViewById(R.id.tend_btn1);
        tend_btn2 = findViewById(R.id.tend_btn2);

        tend_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tendencyctivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tendencyctivity.this, Tendency2Activity.class);
                startActivity(intent);
            }
        });
    }
}