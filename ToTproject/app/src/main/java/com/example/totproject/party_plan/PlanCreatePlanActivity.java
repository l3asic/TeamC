package com.example.totproject.party_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.totproject.R;

import java.util.ArrayList;

public class PlanCreatePlanActivity extends AppCompatActivity {
    EditText edt_plan_name, edt_plan_startdate, edt_plan_enddate, edt_plan_location, edt_plan_startpoint, edt_plan_hotel, edt_plan_cost;
    Button btn_plan_create;

    int plan_sn, picture_filepath, party_sn;
    String plan_name, plan_writer, plan_startdate, plan_enddate, plan_location, plan_startpoint, plan_hotel, plan_cost, member_id, plan_starttime, plan_endtime;

    ArrayList<PlanlistDTO> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_createplan);

        edt_plan_name = findViewById(R.id.edt_plan_name);
        edt_plan_startdate = findViewById(R.id.edt_plan_startdate);
        edt_plan_enddate = findViewById(R.id.edt_plan_enddate);
        edt_plan_location = findViewById(R.id.edt_plan_location);
        edt_plan_startpoint = findViewById(R.id.edt_plan_startpoint);
        edt_plan_hotel = findViewById(R.id.edt_plan_hotel);
        edt_plan_cost = findViewById(R.id.edt_plan_cost);
        btn_plan_create = findViewById(R.id.btn_plan_create);



        // @@@@@@@@@ 기타 DTO 정보들 처리해줄 것
        plan_name = edt_plan_name.getText()+"";
        plan_startdate = edt_plan_startdate.getText()+"";
        plan_enddate = edt_plan_enddate.getText()+"";
        plan_location = edt_plan_location.getText()+"";
        plan_startpoint = edt_plan_startpoint.getText()+"";
        plan_hotel = edt_plan_hotel.getText()+"";
        plan_cost = edt_plan_cost.getText()+"";


        //@@@@@@@ 안드 더미데이터 @@@@@@@@@
        list.add(new PlanlistDTO(
                01,
                001,
                0001,
                "광주여행계획",
                "작성자준호",
                "20220930",
                "20201002",
                "광주 서구",
                "농성역",
                "한울 호텔",
                "240000",
                "참여자준호",
                "10:30",
                "19:30"
        ));
        //@@@@@@@ 안드 더미데이터 @@@@@@@@@




        btn_plan_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //@@@@@@@@ 디비에 삽입(플랜저장)코드 추가 할것@@@@@@@@@@@@@

                Intent intent = new Intent(PlanCreatePlanActivity.this, PlanMainActivity.class);
                intent.putExtra("tabcode",1);
                startActivity(intent);

                
                
            }
        });






    }
}