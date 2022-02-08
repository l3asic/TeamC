package com.example.totproject.party_plan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.totproject.R;

public class PlanMainActivity extends AppCompatActivity {
    int tabcode = 0;
    TextView tv_planmain_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_main);

        tv_planmain_title = findViewById(R.id.tv_planmain_title);

        PlanListFragment plan_list_frag = new PlanListFragment(PlanMainActivity.this);
        PlanInfo01Fragment plan_info_frag = new PlanInfo01Fragment(PlanMainActivity.this);
        PlanInfo02Fragment planInfo02Fragment = new PlanInfo02Fragment();
        Intent plan_intent = getIntent();

        tabcode = plan_intent.getIntExtra("tabcode",0);





        if (tabcode == 0 || tabcode ==1) {
            // @@@@  일단 플랜 리스트 화면 보여주기(임시)
            changeFrag(plan_list_frag,tv_planmain_title,"파티 플랜 목록");
        }

        if (tabcode == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_info_frag).commit();
            tv_planmain_title.setText("파티 계획 제목01");        //@@@@@@@@@@ 플랜 이름 넣어주기
        }
















    }//onCreate()

    //@@@@@@테스트용 체인지 프레그@@@@@@
    public void changeFrag(Fragment frag, TextView title, String str){
        getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, frag).commit();
        title.setText(str);
    }






}