package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Tendency2Activity extends AppCompatActivity {
import android.widget.Button;

public class Tendency2Activity extends AppCompatActivity {
    Button tend2_btn1_skip, tend2_btn2_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency2);

        tend2_btn1_skip = findViewById(R.id.tend2_btn1_skip);
        tend2_btn2_next = findViewById(R.id.tend2_btn2_next);
    }
}