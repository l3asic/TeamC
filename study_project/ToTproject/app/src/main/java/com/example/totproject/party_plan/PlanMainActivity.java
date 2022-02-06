package com.example.totproject.party_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.totproject.R;

public class PlanMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_main);

        PlanListFragment plan_list_frag = new PlanListFragment();



        // @@@@  일단 플랜 리스트 화면 보여주기(임시)
        getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_list_frag).commit();












    }
}