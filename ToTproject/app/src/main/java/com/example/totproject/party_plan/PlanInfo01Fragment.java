package com.example.totproject.party_plan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;


public class PlanInfo01Fragment extends Fragment {
    Context context;
    PlanMainActivity planMainActivity = new PlanMainActivity();



    //@@@@@@ 멤버 추가하기@@@@@@@@@@@@@@@@
    TextView tv_plan_startdate, tv_plan_starttime, tv_plan_enddate, tv_plan_endtime, tv_plan_location, tv_plan_startpoint,
            tv_plan_hotel, tv_plan_cost;

    String plan_startdate, plan_starttime, plan_enddate, plan_endtime, plan_location, plan_startpoint, plan_hotel, plan_cost;

    Button btn_plan_info02;



    public PlanInfo01Fragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partyplan_frag_planinfo01, container, false);

        planMainActivity = (PlanMainActivity) getActivity();


        btn_plan_info02 = view.findViewById(R.id.btn_plan_info02);


        tv_plan_startdate=view.findViewById(R.id.tv_plan_startdate);
        tv_plan_starttime=view.findViewById(R.id.tv_plan_starttime);
        tv_plan_enddate=view.findViewById(R.id.tv_plan_enddate);
        tv_plan_endtime=view.findViewById(R.id.tv_plan_endtime);
        tv_plan_location=view.findViewById(R.id.tv_plan_location);
        tv_plan_startpoint=view.findViewById(R.id.tv_plan_startpoint);
        tv_plan_hotel=view.findViewById(R.id.tv_plan_hotel);
        tv_plan_cost=view.findViewById(R.id.tv_plan_cost);


        //@@@@@@@@@@@ 안드 더미데이터 @@@@@@@@@@@

        PlanlistDTO dto =new PlanlistDTO(
                01,
                001,
                0001,
                "제주 여행 계획",
                "준호",
                "2022-02-08",
                "2022-20-10",
                "제주도 서귀포",
                "농성역에서 모이기",
                "제주호텔",
                "350000",
                "준호",
                "09:30",
                "17:30"
        );

        //@@@@@@@@@@@ 안드 더미데이터 @@@@@@@@@@@

        plan_startdate = dto.getPlan_startdate();
        plan_starttime = dto.getPlan_starttime();
        plan_enddate = dto.getPlan_endtime();
        plan_endtime = dto.getPlan_endtime();
        plan_location = dto.getPlan_location();
        plan_startpoint = dto.getPlan_startpoint();
        plan_hotel = dto.getPlan_hotel();
        plan_cost = dto.getPlan_cost();

        tv_plan_startdate.setText(plan_startdate);
        tv_plan_starttime.setText(plan_starttime);
        tv_plan_enddate.setText(plan_enddate);
        tv_plan_endtime.setText(plan_endtime);
        tv_plan_location.setText(plan_location);
        tv_plan_startpoint.setText(plan_startpoint);
        tv_plan_hotel.setText(plan_hotel);
        tv_plan_cost.setText(plan_cost);




        btn_plan_info02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //planMainActivity.changePlanFrag(3,"플랜임시제목");
                //planMainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, new PlanInfo02Fragment(context)).commit();
              //  getFragmentManager().beginTransaction().replace(R.id.party_plan_container, new PlanInfo02Fragment(context)).commit();
                planMainActivity.changePlanFrag(3 , "te");
//                Intent intent = new Intent(context,  PlanMainActivity.class);
//                intent.putExtra("tabcode", "3");
//                startActivity(intent);


            }
        });





        return view;
    }//onCreateView()





}