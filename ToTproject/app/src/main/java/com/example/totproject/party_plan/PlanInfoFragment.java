package com.example.totproject.party_plan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;

import java.util.ArrayList;


public class PlanInfoFragment extends Fragment {
    Context context;

    //@@@@@@ 멤버 추가하기@@@@@@@@@@@@@@@@
    TextView tv_plan_startdate, tv_plan_starttime, tv_plan_enddate, tv_plan_endtime, tv_plan_location, tv_plan_startpoint,
            tv_plan_hotel, tv_plan_cost;

    Button btn_plan_detail;

    ArrayList<PlanlistDTO> dto =new ArrayList<>();

    public PlanInfoFragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partyplan_frag_plandetail, container, false);

        btn_plan_detail = view.findViewById(R.id.btn_plan_detail);


        tv_plan_startdate=view.findViewById(R.id.tv_plan_startdate);
        tv_plan_starttime=view.findViewById(R.id.tv_plan_starttime);
        tv_plan_enddate=view.findViewById(R.id.tv_plan_enddate);
        tv_plan_endtime=view.findViewById(R.id.tv_plan_endtime);
        tv_plan_location=view.findViewById(R.id.tv_plan_location);
        tv_plan_startpoint=view.findViewById(R.id.tv_plan_startpoint);
        tv_plan_hotel=view.findViewById(R.id.tv_plan_hotel);
        tv_plan_cost=view.findViewById(R.id.tv_plan_cost);


        //@@@@@@@@@@@ 디비 연결후 세팅해줄것@@@@@@@@@@@
        tv_plan_startdate.setText("");
        tv_plan_starttime.setText("");
        tv_plan_enddate.setText("");
        tv_plan_endtime.setText("");
        tv_plan_location.setText("");
        tv_plan_startpoint.setText("");
        tv_plan_hotel.setText("");
        tv_plan_hotel.setText("");




        btn_plan_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlanMainActivity.class);       //@@@@@@ 파티플랜 디테일로 이동
                intent.putExtra("tabcode", "3");
                startActivity(intent);
            }
        });





        return view;
    }//onCreateView()





}