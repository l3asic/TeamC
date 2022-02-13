package com.example.totproject.party;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.totproject.R;
import com.example.totproject.main.MainActivity;
import com.example.totproject.party_plan.PlanMainActivity;
import com.google.android.material.navigation.NavigationView;

public class MyPartyInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button partyinfo_btn_burger ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_myparty_info);

        partyinfo_btn_burger = findViewById(R.id.partyinfo_btn_burger);


        //@@@@@@@@@@@@@@@@ 버거메뉴 클릭시  => 파티플랜이동(임시)   수정해야함
        partyinfo_btn_burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPartyInfoActivity.this, PlanMainActivity.class);
                startActivity(intent);
            }
        });


        toolbar = (Toolbar) findViewById(R.id.partyinfo_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.partytinfo_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );//햄버거 버튼 만들기 ( 버튼을 눌러서 반전시키는 효과를 만듬 )
        drawer.addDrawerListener(toggle);

        partyinfo_btn_burger = findViewById(R.id.partyinfo_btn_burger);
        partyinfo_btn_burger.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.END)) {
                    drawer.closeDrawer(Gravity.END);
                } else {
                    drawer.openDrawer(Gravity.END);
                }
            }
        });
        NavigationView nav_view = findViewById(R.id.partyinfo_burger_view);
        View nav_headerview = nav_view.getHeaderView(0);

    ImageView partyinfo_burger_invite, partyinfo_burger_membermanage, partyinfo_burger_infomanage, partyinfo_burger_patydelete;
        partyinfo_burger_invite = nav_headerview.findViewById(R.id.partyinfo_burger_invite);
        partyinfo_burger_membermanage = nav_headerview.findViewById(R.id.partyinfo_burger_membermanage);
        partyinfo_burger_infomanage = nav_headerview.findViewById(R.id.partyinfo_burger_infomanage);
        partyinfo_burger_patydelete = nav_headerview.findViewById(R.id.partyinfo_burger_patydelete);
        partyinfo_burger_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        partyinfo_burger_membermanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        partyinfo_burger_infomanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });        partyinfo_burger_patydelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}