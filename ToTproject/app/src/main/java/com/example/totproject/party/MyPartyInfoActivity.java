package com.example.totproject.party;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.totproject.R;
import com.example.totproject.login.JoinActivity;
import com.example.totproject.login.LoginActivity;
import com.example.totproject.main.MainActivity;
import com.example.totproject.party_plan.PlanMainActivity;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.navigation.NavigationView;

import java.util.Date;

public class MyPartyInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button partyinfo_btn_burger;
    PartyListDTO plDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_myparty_info);


        TextView party_title;
        party_title = findViewById(R.id.partyinfo_tv_title);        

        Intent my_party_info_intent = getIntent();
        plDTO = (PartyListDTO) my_party_info_intent.getSerializableExtra("party_dto");
        party_title.setText(plDTO.getParty_name());


        partyinfo_btn_burger = findViewById(R.id.partyinfo_btn_burger);


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

        ImageView cancel;
        cancel = nav_headerview.findViewById(R.id.partyinfo_burger_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
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


        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      버거 세팅영역     ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        ImageView partyinfo_burger_membermanage, partyinfo_burger_infomanage, partyinfo_burger_patydelete;

        LinearLayout lin_mypartyburger_invite, lin_mypartyburger_delete;

        lin_mypartyburger_invite = nav_headerview.findViewById(R.id.lin_mypartyburger_invite);
        partyinfo_burger_membermanage = nav_headerview.findViewById(R.id.partyinfo_burger_membermanage);
        partyinfo_burger_infomanage = nav_headerview.findViewById(R.id.partyinfo_burger_infomanage);
        lin_mypartyburger_delete = nav_headerview.findViewById(R.id.lin_mypartyburger_delete);        
        

        lin_mypartyburger_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버초대 누름 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyPartyInfoActivity.this, InviteMemberActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);

            }
        });
        partyinfo_burger_membermanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버관리 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        partyinfo_burger_infomanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        lin_mypartyburger_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "파티삭제 눌렸음 ", Toast.LENGTH_SHORT).show();
                //@@ 파티삭제 알럿창과 삭제 기능 추가할 것


            }
        });


        TextView main_burger_tv_login = nav_headerview.findViewById(R.id.partyinfo_burger_tv_name);
        main_burger_tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPartyInfoActivity.this, "텍스트", Toast.LENGTH_SHORT).show();

            }
        });

        TextView main_burger_tv_join = nav_headerview.findViewById(R.id.partyinfo_burger_tv_grade);
        main_burger_tv_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyPartyInfoActivity.this, "텍스트", Toast.LENGTH_SHORT).show();

            }
        });

        Menu nav_menu = nav_view.getMenu();

        NavigationView bottom_nav2;
        bottom_nav2 = findViewById(R.id.partyinfo_burger_view);
        bottom_nav2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);


                int id = item.getItemId();
                String tabText = (String) item.getTitle();
                String title = item.getTitle().toString();
                if (id == R.id.partyinfo_burger_home) {
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                } else if (id == R.id.partyinfo_burger_notice) {
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                } else if (id == R.id.partyinfo_burger_board) {

                } else if (id == R.id.partyinfo_burger_plan) {
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyPartyInfoActivity.this, PlanMainActivity.class);
                    intent.putExtra("plDTO",plDTO);
                    startActivity(intent);
                    //ChangeActivity(PlanMainActivity.class);
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                } else if (id == R.id.partyinfo_burger_member) {
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                } else if (id == R.id.partyinfo_burger_chat) {
                    Toast.makeText(MyPartyInfoActivity.this, "메뉴", Toast.LENGTH_LONG).show();
                }


                return true;
            }
        });


    }

    public void ChangeActivity(Class nextAct, int tabcode, String tabText) {
        Intent intent = new Intent(MyPartyInfoActivity.this, nextAct);
        intent.putExtra("tabcode", tabcode);
        intent.putExtra("tabText", tabText);
        startActivity(intent);
    }

    public void ChangeActivity(Class nextClass) {
        Intent intent = new Intent(MyPartyInfoActivity.this, nextClass);
        startActivity(intent);
    }
}