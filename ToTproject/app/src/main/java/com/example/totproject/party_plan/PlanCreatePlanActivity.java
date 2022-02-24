package com.example.totproject.party_plan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.party.PartyListAdapter;
import com.example.totproject.party.PartyListDTO;
import com.example.totproject.party.PartyMemberListDTO;
import com.example.totproject.party.PartymemberListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlanCreatePlanActivity extends AppCompatActivity {
    RecyclerView rec_memberlist;
    ArrayList<PartyMemberListDTO> plan_member_list = new ArrayList<>();
    ArrayList<PartyMemberListDTO> invite_list = new ArrayList<>();


    EditText edt_plan_name, edt_plan_startdate, edt_plan_enddate, edt_plan_location, edt_plan_startpoint, edt_plan_hotel, edt_plan_cost,edt_plan_starttime, edt_plan_endtime;
    Button btn_plan_create;

    String picture_filepath = "001";
    int party_sn;
//    ArrayList<PlanlistDTO> list = new ArrayList<>();

    CommonAsk commonAsk;
    Gson gson = new Gson();
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_createplan);

        rec_memberlist = findViewById(R.id.rec_memberlist);

        edt_plan_name = findViewById(R.id.edt_plan_name);
        edt_plan_startdate = findViewById(R.id.edt_plan_startdate);
        edt_plan_enddate = findViewById(R.id.edt_plan_enddate);
        edt_plan_location = findViewById(R.id.edt_plan_location);
        edt_plan_startpoint = findViewById(R.id.edt_plan_startpoint);
        edt_plan_hotel = findViewById(R.id.edt_plan_hotel);
        edt_plan_cost = findViewById(R.id.edt_plan_cost);
        btn_plan_create = findViewById(R.id.btn_plan_create);
        edt_plan_starttime =findViewById(R.id.edt_plan_starttime);
        edt_plan_endtime =findViewById(R.id.edt_plan_endtime);

        Intent get_intent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) get_intent.getSerializableExtra("plDTO");
        party_sn = plDTO.getParty_sn();

        // 파티 멤버리스트 조회해오기
        planMemberList(party_sn);

        // 어댑터 세팅영역
        PlanMemberListAdpater adapter = new PlanMemberListAdpater(PlanCreatePlanActivity.this,plan_member_list,plDTO);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                PlanCreatePlanActivity.this , RecyclerView.VERTICAL , false
        );
        rec_memberlist.setLayoutManager(layoutManager);
        rec_memberlist.setAdapter(adapter);



        // @@ 체크박스로 멤버들 한번에 플랜데이터 삽입 해줄것










//        // 플랜 최종 저장 버튼
//        btn_plan_create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                PlanlistDTO planlistDTO = new PlanlistDTO(
//                        00,      // 임시 플랜 SN (디비에서 세팅)
//                        "001",
//                        party_sn,
//                        edt_plan_name.getText()+"",
//                        Logined.member_id,
//                        edt_plan_startdate.getText()+"",
//                        edt_plan_enddate.getText()+"",
//                        edt_plan_location.getText()+"",
//                        edt_plan_startpoint.getText()+"",
//                        edt_plan_hotel.getText()+"",
//                        edt_plan_cost.getText()+"",
//                        Logined.member_id,      //@@@@ 파티 멤버 한해서만 추가?할수 있도록 수정
//                        edt_plan_starttime.getText()+"",
//                        edt_plan_endtime+""
//                );
//
//
//                insertPlan(planlistDTO);
//                Intent intent = new Intent(PlanCreatePlanActivity.this, PlanMainActivity.class);
//                intent.putExtra("tabcode",1);
//                intent.putExtra("plDTO",plDTO);
//                startActivity(intent);
//
//
//            }
//        });






    }//onCreate()

    public void insertPlan(PlanlistDTO dto) {

        commonAsk = new CommonAsk("android/party/insertplan");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));
        commonAsk.params.add(new CommonAskParam("invite_list" ,  gson.toJson(invite_list) ));

        InputStream in = CommonMethod.excuteAsk(commonAsk);

    }

    public ArrayList<PartyMemberListDTO> planMemberList(int party_sn) {
        commonAsk = new CommonAsk("android/party/planmemberlist");
        commonAsk.params.add(new CommonAskParam("party_sn",party_sn+""));

        InputStream in = CommonMethod.excuteAsk(commonAsk);

        // 리스트로 리턴 처리해줄것

        try {
            plan_member_list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyMemberListDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return plan_member_list;
    }



    public void test(PartyListDTO plDTO){

//        // 체크박스 다나오게하는거
//        for(int i  = 0 ; i< plan_detail_list.getChildCount(); i++){
//            PlanUpdateAdapter.Viewholder viewholder = (PlanUpdateAdapter.Viewholder) plan_detail_list.findViewHolderForAdapterPosition(i);
//            viewholder.chk_planudelete.setVisibility(View.VISIBLE);
//
//        }

        // 플랜 최종 저장 버튼 클릭시
        btn_plan_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(invite_list.size() == 0 ){
                    return;
                }


                PlanlistDTO planlistDTO = new PlanlistDTO(
                        00,      // 임시 플랜 SN (디비에서 세팅)
                        "001",
                        party_sn,
                        edt_plan_name.getText()+"",
                        Logined.member_id,
                        edt_plan_startdate.getText()+"",
                        edt_plan_enddate.getText()+"",
                        edt_plan_location.getText()+"",
                        edt_plan_startpoint.getText()+"",
                        edt_plan_hotel.getText()+"",
                        edt_plan_cost.getText()+"",
                        Logined.member_id,      //@@@@ 파티 멤버 한해서만 추가?할수 있도록 수정
                        edt_plan_starttime.getText()+"",
                        edt_plan_endtime+""
                );

                insertPlan(planlistDTO);
                Intent intent = new Intent(PlanCreatePlanActivity.this, PlanMainActivity.class);
                intent.putExtra("tabcode",1);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);
                finish();



//                //새로고침 영역
//                finish();//인텐트 종료
//                overridePendingTransition(0, 0);//인텐트 효과 없애기
//                Intent intent = getIntent(); //인텐트
//                startActivity(intent); //액티비티 열기
//                overridePendingTransition(0, 0);//인텐트 효과 없애기


            }
        });



    }

    // 체크박스 체크된 디테일리스트 삭제





}