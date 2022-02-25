package com.example.totproject.party_plan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.DatePickerActivity;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.MainActivity;
import com.example.totproject.party.PartyCreateActivity;
import com.example.totproject.party.PartyListDTO;
import com.example.totproject.party.PartyMemberListDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PlanCreatePlanActivity extends AppCompatActivity {
    RecyclerView rec_memberlist;
    ArrayList<PartyMemberListDTO> plan_member_list = new ArrayList<>();
    ArrayList<PartyMemberListDTO> invite_list = new ArrayList<>();

    final int DIALOG_REQ = 1000;
    EditText edt_plan_name, edt_plan_location, edt_plan_startpoint, edt_plan_hotel, edt_plan_cost,edt_plan_starttime, edt_plan_endtime;
    TextView tv_plan_startdate, tv_plan_enddate;
    Button btn_plan_create;

    String start_date;
    String end_date;

    int year, month, day;
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
        tv_plan_startdate = findViewById(R.id.tv_createplan_startdate);
        tv_plan_enddate = findViewById(R.id.tv_plan_enddate);
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


        // @@@@@@@@@@@@ datepicker 영역


        tv_plan_startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanCreatePlanActivity.this, DatePickerActivity.class);
                startActivityForResult(intent ,DIALOG_REQ );



            }
        });





















    }//onCreate()






    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DIALOG_REQ && resultCode == RESULT_OK) {
            start_date = data.getExtras().getString("date");
            Toast.makeText(PlanCreatePlanActivity.this, "값 잘넘어옴 시작날짜" + start_date, Toast.LENGTH_SHORT).show();

        }
    }

    // 팝업중 다른곳 터치시 안닫힘
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if( event.getAction() == MotionEvent.ACTION_OUTSIDE ) {
            return false;
        }
        return true;
    }










    public void insertPlan(PlanlistDTO dto) {

        commonAsk = new CommonAsk("android/party/insertplan");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));
        commonAsk.params.add(new CommonAskParam("invite_list" ,  gson.toJson(invite_list) ));

        InputStream in = CommonMethod.excuteAsk(commonAsk);

    }

    private void insertPlanDays(PlanlistDTO dto, int diffDayss) {
        commonAsk = new CommonAsk("android/party/insertPlanDays");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));
        commonAsk.params.add(new CommonAskParam("diffDayss" ,  diffDayss+"" ));

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



    public void test(PartyListDTO plDTO) {

        start_date = "2022-03-01";  //@@ 임시 출발날짜 세팅
        end_date = "2022-03-03";  //@@ 임시 도착날짜 세팅

        // 두 날짜간 차이 (플랜 Days 세팅위해)  diffDayss <= 최종 날짜 차이

        int diffDayss = 0;
        if(start_date != null && end_date != null){
            Date start_date2 = null;
            Date end_date2 = null;
            try {
                start_date2 = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
                end_date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar start_date3 = Calendar.getInstance();
            Calendar end_date3 = Calendar.getInstance();
            start_date3.setTime(start_date2); //특정 일자
            end_date3.setTime(end_date2); //특정 일자

            long diffSec = (end_date3.getTimeInMillis() - start_date3.getTimeInMillis()) / 1000;
            long diffDays = diffSec / (24*60*60); //일자수 차이


            diffDayss = (int) (diffDays+1);

        }



        // 플랜 최종 저장 버튼 클릭시
        btn_plan_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(invite_list.size() == 0 ){
                    return;
                }


                PlanlistDTO planlistDTO = new PlanlistDTO(
                        00,
                        null,
                        party_sn,
                        edt_plan_name.getText()+"",
                        Logined.member_id,
                        tv_plan_startdate.getText()+"",
                        tv_plan_enddate.getText()+"",
                        edt_plan_location.getText()+"",
                        edt_plan_startpoint.getText()+"",
                        edt_plan_hotel.getText()+"",
                        edt_plan_cost.getText()+"",
                        Logined.member_id,
                        edt_plan_starttime.getText()+"",
                        edt_plan_endtime+""
                );

                insertPlan(planlistDTO);

                // @@@ 여기 왜 오류남
                if (diffDayss != 0){
                    insertPlanDays(planlistDTO, diffDayss);
                }







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