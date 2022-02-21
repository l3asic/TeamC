package com.example.totproject.party;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.login.JoinActivity;
import com.example.totproject.login.LoginActivity;
import com.example.totproject.main.MainActivity;
import com.example.totproject.party_plan.PlanMainActivity;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Date;

public class MyPartyInfoActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button partyinfo_btn_burger;
    PartyListDTO plDTO;

    CommonAsk commonAsk;
    Gson gson = new Gson();

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

                    drawer.openDrawer(Gravity.END);

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

        LinearLayout lin_leader_option, lin_member_option;

        LinearLayout lin_mypartyburger_invite, lin_mypartyburger_delete, lin_mypartyburger_membermanage, lin_mypartyburger_update;
        LinearLayout lin_mypartyburger_invite2, lin_mypartyburger_delete2, lin_mypartyburger_membermanage2, lin_mypartyburger_update2;

        lin_leader_option = nav_headerview.findViewById(R.id.lin_leader_option);
        lin_member_option = nav_headerview.findViewById(R.id.lin_member_option);

        lin_mypartyburger_invite = nav_headerview.findViewById(R.id.lin_mypartyburger_invite);
        lin_mypartyburger_membermanage = nav_headerview.findViewById(R.id.lin_mypartyburger_membermanage);
        lin_mypartyburger_update = nav_headerview.findViewById(R.id.lin_mypartyburger_update);
        lin_mypartyburger_delete = nav_headerview.findViewById(R.id.lin_mypartyburger_delete);

        lin_mypartyburger_invite2 = nav_headerview.findViewById(R.id.lin_mypartyburger_invite2);
        lin_mypartyburger_membermanage2 = nav_headerview.findViewById(R.id.lin_mypartyburger_membermanage2);
        lin_mypartyburger_update2 = nav_headerview.findViewById(R.id.lin_mypartyburger_update2);
        lin_mypartyburger_delete2 = nav_headerview.findViewById(R.id.lin_mypartyburger_delete2);


        // 로그인한 사람이 파티 리더 아이디와 같다면
        if(Logined.member_id.equals(plDTO.getParty_leader())){
            lin_leader_option.setVisibility(View.VISIBLE);
            lin_member_option.setVisibility(View.INVISIBLE);
        }else{
            lin_leader_option.setVisibility(View.INVISIBLE);
            lin_member_option.setVisibility(View.VISIBLE);
        }



        // 파티 리더 옵션

        // 버거메뉴 멤버 초대 클릭시
        lin_mypartyburger_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버초대 누름 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyPartyInfoActivity.this, InviteMemberActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);

            }
        });

        // 버거메뉴 멤버 관리 클릭시
        lin_mypartyburger_membermanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버 관리 누름 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyPartyInfoActivity.this, PartyMemberManageActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);
            }
        });

        // 파티 정보 수정 클릭시
        lin_mypartyburger_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPartyInfoActivity.this, UpdateMyPartyActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);
            }
        });

        // 버거메뉴 파티 해산 클릭시
        lin_mypartyburger_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "파티삭제 눌렸음 ", Toast.LENGTH_SHORT).show();

                showCustomDialog("정말 파티를 해산 하시겠어요?"); // alert 다이얼로그 확인창


            }
        });



        // 파티 멤버 옵션

        // 버거메뉴 멤버 초대 클릭시
        lin_mypartyburger_invite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버초대 누름 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyPartyInfoActivity.this, InviteMemberActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);

            }
        });

        // 버거메뉴 멤버 목록 클릭시
        lin_mypartyburger_membermanage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "멤버 목록 누름 ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyPartyInfoActivity.this, PartyMemberManageActivity.class);
                intent.putExtra("plDTO",plDTO);
                startActivity(intent);
            }
        });

        // 파티 정보 보기 클릭시
        lin_mypartyburger_update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPartyInfoActivity.this, PartyJoinActivity.class);
                intent.putExtra("party_sn",plDTO.getParty_sn());
                startActivity(intent);
            }
        });

        // 버거메뉴 파티 탈퇴 클릭시
        lin_mypartyburger_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyPartyInfoActivity.this, "파티삭제 눌렸음 ", Toast.LENGTH_SHORT).show();

                showCustomDialog("정말 파티를 탈퇴하시겠어요?"); // alert 다이얼로그 확인창


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

    public void showCustomDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyPartyInfoActivity.this,
                R.style.AlertDialogTheme);

        View view= LayoutInflater.from(MyPartyInfoActivity.this).inflate(
            R.layout.common_alert_yes_or_no_item,
                (LinearLayout)findViewById(R.id.layout_alert)
        );

        //다이얼로그 텍스트 설정
        builder.setView(view);
        ((TextView)view.findViewById(R.id.texttitle)).setText("※ 주의");
        ((TextView)view.findViewById(R.id.textmessage)).setText(msg);
        ((TextView)view.findViewById(R.id.btn_dialog_yes)).setText("네");
        ((TextView)view.findViewById(R.id.btn_dialog_no)).setText("아니요");

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);   //화면밖 터치시 다이얼로그 종료방지

        //네 클릭시
        view.findViewById(R.id.btn_dialog_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Logined.member_id.equals(plDTO.getParty_leader())){
                    deleteParty(plDTO); //파티 해산 기능
                }else{
                    deleteParty2(plDTO); //파티 탈퇴 기능
                }


                alertDialog.dismiss();  //알럿창 닫기
                Intent intent = new Intent(MyPartyInfoActivity.this, PartyMainActivity.class);
                intent.putExtra("tabcode",3);
                startActivity(intent);
            }
        });

        //아니요 클릭시
        view.findViewById(R.id.btn_dialog_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();  //알럿창 닫기
            }
        });

        //다이얼로그 형태 지우기
        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();



    }//showCustomDialog()

    private void deleteParty(PartyListDTO plDTO) {
        commonAsk = new CommonAsk("android/party/deleteparty");
        commonAsk.params.add(new CommonAskParam("plDTO", gson.toJson(plDTO)) );
        InputStream in = CommonMethod.excuteAsk(commonAsk);

    }

    private void deleteParty2(PartyListDTO plDTO) {
        commonAsk = new CommonAsk("android/party/deleteParty2");
        commonAsk.params.add(new CommonAskParam("plDTO", gson.toJson(plDTO)) );
        InputStream in = CommonMethod.excuteAsk(commonAsk);

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