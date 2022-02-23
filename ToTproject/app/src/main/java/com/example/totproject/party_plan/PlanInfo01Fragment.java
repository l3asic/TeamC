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
    PlanlistDTO planlistDTO;



    //@@@@@@ 멤버 추가하기@@@@@@@@@@@@@@@@
    TextView tv_plan_startdate, tv_plan_starttime, tv_plan_enddate, tv_plan_endtime, tv_plan_location, tv_plan_startpoint,
            tv_plan_hotel, tv_plan_cost;

    Button btn_plan_info02;


    public PlanInfo01Fragment(Context context, PlanlistDTO planlistDTO) {
        this.context = context;
        this.planlistDTO = planlistDTO;
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


        tv_plan_startdate.setText(planlistDTO.getPlan_startdate());
        tv_plan_starttime.setText(planlistDTO.getPlan_starttime());
        tv_plan_enddate.setText(planlistDTO.getPlan_enddate());
        tv_plan_endtime.setText(planlistDTO.getPlan_endtime());
        tv_plan_location.setText(planlistDTO.getPlan_location());
        tv_plan_startpoint.setText(planlistDTO.getPlan_startpoint());
        tv_plan_hotel.setText(planlistDTO.getPlan_hotel());
        tv_plan_cost.setText(planlistDTO.getPlan_cost());


        btn_plan_info02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanInfo02Fragment plan_info_frag02 = new PlanInfo02Fragment(getActivity(),planlistDTO);
                planMainActivity.changePlanFrag(plan_info_frag02 , planlistDTO.getPlan_name());

            }
        });


        return view;
    }//onCreateView()





}