package com.example.totproject.party_plan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;

public class PlanUpdatePlanActivity extends AppCompatActivity {
    RecyclerView plan_detail_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_updateplan);

        plan_detail_list = findViewById(R.id.plan_detail_list);
        ArrayList<PlanInfoDTO> list = new ArrayList<>();

        //@@@@@@@@@@@ 안드더미데이터 넣기 @@@@@@@@@@
        for (int i=0; i<10;i++){
            list.add(new PlanInfoDTO("2022-02-18",
                    "19:00",
                    01012,
                    "에펠탑",
                    "관광 하러"
                    )
            );
        }


        //@@@@@@@@@@@ 안드더미데이터 넣기 @@@@@@@@@@

        


        PlanUpdateAdapter planUpdateAdapter = new PlanUpdateAdapter(PlanUpdatePlanActivity.this,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                PlanUpdatePlanActivity.this , RecyclerView.VERTICAL , false
        );

        plan_detail_list.setLayoutManager(layoutManager);
        plan_detail_list.setAdapter(planUpdateAdapter);









    }
}