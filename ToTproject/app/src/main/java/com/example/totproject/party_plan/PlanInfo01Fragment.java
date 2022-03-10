package com.example.totproject.party_plan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.party.PartyJoinActivity;
import com.example.totproject.party.PartyListDTO;
import com.example.totproject.party.PartyMemberListDTO;
import com.example.totproject.party.PartymemberListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class PlanInfo01Fragment extends Fragment {
    Context context;
    PlanMainActivity planMainActivity = new PlanMainActivity();
    PlanlistDTO planlistDTO;
    PartyListDTO plDTO;
    GridView grid_memberlist;
    ArrayList<PartyMemberListDTO> plan_member_list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();



    LinearLayout lin_plan_tohome, lin_plan_toback, lin_plan_toback2;


    TextView tv_plan_startdate, tv_plan_starttime, tv_plan_enddate, tv_plan_endtime, tv_plan_location, tv_plan_startpoint,
            tv_plan_hotel, tv_plan_cost;

    Button btn_plan_info02, btn_planmain_update,btn_planmain_create;

    FloatingActionButton fab_planmain_create;

    public PlanInfo01Fragment(Context context, PlanlistDTO planlistDTO, PartyListDTO plDTO) {
        this.context = context;
        this.planlistDTO = planlistDTO;
        this.plDTO = plDTO;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partyplan_frag_planinfo01, container, false);

        planMainActivity = (PlanMainActivity) getActivity();


        btn_plan_info02 = view.findViewById(R.id.btn_plan_info02);

        grid_memberlist = view.findViewById(R.id.grid_memberlist);

        tv_plan_startdate=view.findViewById(R.id.tv_plan_startdate);
        tv_plan_starttime=view.findViewById(R.id.tv_plan_starttime);
        tv_plan_enddate=view.findViewById(R.id.tv_plan_enddate);
        tv_plan_endtime=view.findViewById(R.id.tv_plan_endtime);
        tv_plan_location=view.findViewById(R.id.tv_plan_location);
        tv_plan_startpoint=view.findViewById(R.id.tv_plan_startpoint);
        tv_plan_hotel=view.findViewById(R.id.tv_plan_hotel);
        tv_plan_cost=view.findViewById(R.id.tv_plan_cost);
        btn_planmain_update=view.findViewById(R.id.btn_planmain_update);

        
        // 프레그 01에서  플랜 추가 플로팅버튼 안보이게
        fab_planmain_create=getActivity().findViewById(R.id.fab_planmain_create);
        fab_planmain_create.setVisibility(View.GONE);

        // 홈버튼 없에기
        lin_plan_tohome=getActivity().findViewById(R.id.lin_plan_tohome);
        lin_plan_tohome.setVisibility(View.GONE);

        // Info 02 뒤로가기 버튼 안보이게
        lin_plan_toback2=getActivity().findViewById(R.id.lin_plan_toback2);
        lin_plan_toback2.setVisibility(View.GONE);

        // 뒤로가기버튼 보이게
        lin_plan_toback=getActivity().findViewById(R.id.lin_plan_toback);
        lin_plan_toback.setVisibility(View.VISIBLE);



        planMemberListNew(planlistDTO.getPlan_sn());




        // 어댑터 세팅영역
        PartymemberListAdapter adapter = new PartymemberListAdapter(getActivity(), plan_member_list);
        grid_memberlist = view.findViewById(R.id.grid_memberlist);
        grid_memberlist.setAdapter(adapter);
        setDynamicHeight(grid_memberlist);

        //@@@
        //btn_planmain_update.setText("플랜수정");
        tv_plan_startdate.setText(planlistDTO.getPlan_startdate());
        tv_plan_starttime.setText(planlistDTO.getPlan_starttime());
        tv_plan_enddate.setText(planlistDTO.getPlan_enddate());
        tv_plan_endtime.setText(planlistDTO.getPlan_endtime());
        tv_plan_location.setText(planlistDTO.getPlan_location());
        tv_plan_startpoint.setText(planlistDTO.getPlan_startpoint());
        tv_plan_hotel.setText(planlistDTO.getPlan_hotel());
        tv_plan_cost.setText(planlistDTO.getPlan_cost());


        // 뒤로가기 버튼 클릭시  (플랜 리스트 프레그로 이동)
        lin_plan_toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PlanMainActivity activity = new PlanMainActivity();
//                PlanListFragment list_frag = new PlanListFragment(getActivity(),planlistDTO.getParty_sn());
//                activity.changePlanFrag(list_frag,"파티 플랜 목록");

//                Intent intent = new Intent(getActivity(),PlanMainActivity.class);
//                intent.putExtra("plDTO", plDTO);
//                startActivity(intent);

                PlanMainActivity activity = (PlanMainActivity) context;
                PlanListFragment frag = new PlanListFragment(getActivity(),plDTO.getParty_sn());
                activity.changePlanFrag(frag,"파티 플랜 목록");
            }
        });



        //해당 플랜 디테일 보기
        btn_plan_info02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanInfo02Fragment plan_info_frag02 = new PlanInfo02Fragment(getActivity(),planlistDTO);
                planMainActivity.changePlanFrag(plan_info_frag02 , planlistDTO.getPlan_name());



            }
        });

        // 플랜 업데이트 버튼 클릭시
        btn_planmain_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlanUpdatePlanActivity.class);
                intent.putExtra("planlistDTO",planlistDTO);
                getActivity().startActivity(intent);
            }
        });




        return view;
    }//onCreateView()


    //파티 멤버리스트 조회 (엮여있는게 있을까봐 메소드 새로팜)
    public ArrayList<PartyMemberListDTO> planMemberListNew(int plan_sn) {
        commonAsk = new CommonAsk("android/party/planMemberListNew");
        commonAsk.params.add(new CommonAskParam("plan_sn",plan_sn+""));

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


    private void setDynamicHeight(GridView gridView) {
        ListAdapter gridViewAdapter = gridView.getAdapter();
        if (gridViewAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int items = gridViewAdapter.getCount();
        int rows = 0;

        View listItem = gridViewAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x = 1;
        if( items > 2 ){
            x = items/2;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight -50;
        gridView.setLayoutParams(params);
    }

}