package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {

    EditText join_id, join_pw, join_pw_donfirm, join_tel;
    TextView join_next;
    Button join_id_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_id = findViewById(R.id.join_id);
        join_id_confirm = findViewById(R.id.join_id_confirm);
        join_pw = findViewById(R.id.join_pw);
        join_pw_donfirm = findViewById(R.id.join_pw_confirm);
        join_next = findViewById(R.id.join_next);


        join_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, TendencyActivity.class);
                startActivity(intent);
            }
        });
    }
}