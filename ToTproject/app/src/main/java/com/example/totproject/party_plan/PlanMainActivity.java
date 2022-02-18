package com.example.totproject.party_plan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;

public class PlanMainActivity extends AppCompatActivity {
    int tabcode = 0;
    TextView tv_planmain_title;
    Button btn_planmain_create;
    String title_name;

    PlanListFragment   plan_list_frag     ;
    PlanInfo01Fragment plan_info_frag01 ;
    PlanInfo02Fragment plan_info_frag02 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyplan_act_main);
         plan_list_frag   = new PlanListFragment(PlanMainActivity.this);
         plan_info_frag01 = new PlanInfo01Fragment(PlanMainActivity.this);
         plan_info_frag02 = new PlanInfo02Fragment(PlanMainActivity.this);
        tv_planmain_title = findViewById(R.id.tv_planmain_title);


        Intent plan_intent = getIntent();

        tabcode = plan_intent.getIntExtra("tabcode",0);

        //title_name = plan_intent.getIntExtra("title_name","임시제목");        //@@@@@@@@ 타이틀 제목 세팅해주기
        title_name = "임시 제목";

        changePlanFrag(tabcode,title_name);

        btn_planmain_create = findViewById(R.id.btn_planmain_create);

        btn_planmain_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanMainActivity.this, PlanCreatePlanActivity.class);
                startActivity(intent);
            }
        });










    }//onCreate()

    //@@@@@@테스트용 체인지 프레그@@@@@@
    public void changePlanFrag(int tabcode, String title_name){
        if(tabcode == 1 || tabcode == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_list_frag).commit();
        }else if(tabcode ==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_info_frag01).commit();
        }else if(tabcode ==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_info_frag02).commit();
        }

        tv_planmain_title.setText(title_name);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
         if(tabcode ==3){
           // getSupportFragmentManager().beginTransaction().replace(R.id.party_plan_container, plan_info_frag02).commit();
        }
    }
}