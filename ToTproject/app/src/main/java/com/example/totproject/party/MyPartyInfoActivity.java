package com.example.totproject.party;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.party_plan.PlanMainActivity;

public class MyPartyInfoActivity extends AppCompatActivity {

    Button btn_party_info_berger ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_myparty_info);

        btn_party_info_berger = findViewById(R.id.btn_party_info_berger);


        //@@@@@@@@@@@@@@@@ 버거메뉴 클릭시  => 파티플랜이동(임시)   수정해야함
        btn_party_info_berger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPartyInfoActivity.this, PlanMainActivity.class);
                startActivity(intent);
            }
        });






    }
}