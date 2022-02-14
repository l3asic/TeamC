package com.example.totproject.party_plan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.MemberDTO;
import com.example.totproject.party.PartyCreateActivity;
import com.example.totproject.party.PartyListDTO;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;

public class PlanCreatePlanActivity extends AppCompatActivity {
    EditText edt_plan_name, edt_plan_startdate, edt_plan_enddate, edt_plan_location, edt_plan_startpoint, edt_plan_hotel, edt_plan_cost;
    Button btn_plan_create;

    int picture_filepath, party_sn;
//    ArrayList<PlanlistDTO> list = new ArrayList<>();

    CommonAsk commonAsk;
    Gson gson = new Gson();
    




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

        Intent get_intent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) get_intent.getSerializableExtra("plDTO");









        btn_plan_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //@@@@@@@@ 디비에 삽입(플랜저장)코드 추가 할것@@@@@@@@@@@@@

                //@@@@@@@ 안드 더미데이터 @@@@@@@@@
                PlanlistDTO planlistDTO = new PlanlistDTO(
                        01,      // @@@@@@@@@임시 플랜 SN
                        001,
                        party_sn,
                        edt_plan_name.getText()+"",
                        MemberDTO.id,
                        edt_plan_startdate.getText()+"",
                        edt_plan_enddate.getText()+"",
                        edt_plan_location.getText()+"",
                        edt_plan_startpoint.getText()+"",
                        edt_plan_hotel.getText()+"",
                        edt_plan_cost.getText()+"",
                        MemberDTO.id,      //@@@@ 파티 멤버 한해서만 추가?할수 있도록 수정
                        edt_plan_startdate.getText()+""
                );
                //@@@@@@@ 안드 더미데이터 @@@@@@@@@


                insertPlan(planlistDTO);
                Toast.makeText(PlanCreatePlanActivity.this, planlistDTO.getPlan_name(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(PlanCreatePlanActivity.this, PlanMainActivity.class);
                intent.putExtra("tabcode",1);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);

                
                
            }
        });






    }//onCreate()

    public void insertPlan(PlanlistDTO dto) {
        commonAsk = new CommonAsk("android/party/insertplan");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));

        InputStream in = CommonMethod.excuteAsk(commonAsk);
        Toast.makeText(PlanCreatePlanActivity.this, "플랜 생성완료 ( 임시)", Toast.LENGTH_SHORT).show();

    }



}