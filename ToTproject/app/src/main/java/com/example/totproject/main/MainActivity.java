package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.totproject.WhosePage00Activity;
import com.example.totproject.R;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.login.JoinActivity;
import com.example.totproject.login.LoginActivity;
import com.example.totproject.login.SplashActivity;
import com.example.totproject.login.TendencyActivity01;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //https://salix97.tistory.com/72
    BottomNavigationView bottom_nav;
    int main_container;
    Button main_btn_burger, main_btn_reload;
    Toolbar toolbar;
    ImageView cancel;
    TextView main_tv_acttitle;

    LinearLayout afterLogin, main_burger_myboard, main_burger_myscrap, main_burger_myparty;
    LinearLayout main_burger_logout;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        bottom_nav = findViewById(R.id.main_nav);
        main_container = R.id.main_container;
        Fragment01HomeTab mainTab_frag = new Fragment01HomeTab(MainActivity.this, manager);
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab(MainActivity.this, manager);
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();
        Fragment05IotTab loginTab_frag = new Fragment05IotTab();
        Fragment00Empty empty_frag = new Fragment00Empty();
        //  getSupportFragmentManager().beginTransaction().replace(R.id.main_container, mainTab_frag).commit();
        /* =================================== 바텀메뉴 =================================== */
        main_tv_acttitle = findViewById(R.id.main_tv_acttitle);
        ChangeFrament(main_container, mainTab_frag, "맞춤 추천");
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bot_home) {
                    //ChangeFrament(main_container, mainTab_frag);
                    ChangeFrament(main_container, mainTab_frag, "맞춤 추천");
                    return true;
                } else if (item.getItemId() == R.id.bot_category) {
                    ChangeFrament(main_container, categoryTab_frag, "여행지 분류");
                    return true;
                } else if (item.getItemId() == R.id.bot_board) {
                    //   ChangeFrament(main_container, boardTab_frag);
                    ChangeFrament(main_container, boardTab_frag, "자유게시판");

                    return true;
                } else if (item.getItemId() == R.id.bot_party) {
                    ChangeFrament(main_container, partyTab_frag, "파티");
                    return true;
                } else if (item.getItemId() == R.id.bot_iot) {
                    ChangeActivity(TendencyActivity01.class);
                    main_tv_acttitle.setText("내꺼 가방ㅎ");
                    // ChangeFrament(main_container, loginTab_frag); //★★아이오티 화면나오면 수정해야함
                    return true;
                }
                //One day we have to make that the IotTab@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //fking i can't typing Korean;;;
                return false;
            }
        });
        /* ================================================================================ */

        /* =================================== 버거메뉴 생성 ================================================ */
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        /* =================================================================================================== */

        /* ================================= 버거메뉴 findView ================================= */
        NavigationView nav_view = findViewById(R.id.main_burger_view);
        View nav_headerview = nav_view.getHeaderView(0);
        /* ===================================================================================== */

        /* ============================== 새로고침 ============================== */
        main_btn_reload = findViewById(R.id.main_btn_reload);
        main_btn_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                startActivity(getIntent());
                ActivityCompat.finishAffinity(MainActivity.this);
            }
        });
        /* ====================================================================== */

        /* ========================= 버거메뉴 여닫기 ========================= */
        main_btn_burger = findViewById(R.id.main_btn_burger);
        main_btn_burger.setOnClickListener(new View.OnClickListener() {
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
        cancel = nav_headerview.findViewById(R.id.mainburger_btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(Gravity.END);
            }
        });
        /* ==================================================================================== */


        /* ============================== 버거메뉴 내부 ========================================= */
        /* ========== 로그아웃 ===================================================== = ========== */


        main_burger_logout = nav_headerview.findViewById(R.id.main_burger_logout);
        if (Logined.member_id == null) {
            main_burger_logout.setVisibility(View.GONE);
        }
        main_burger_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                SharedPreferences.Editor spEditor = auto.edit();
                spEditor.clear();
                spEditor.commit();
                goSplash();
            }
        });
        ImageView main_burger_imgv_circle;
        main_burger_imgv_circle= nav_headerview.findViewById(R.id.main_burger_imgv_circle);

        if (Logined.picture_filepath != null) {
            Glide.with(MainActivity.this).load(Logined.picture_filepath).into(main_burger_imgv_circle);
            //Glide.with(context).load(list.get(position).getPicture_filepath()).into(board_user_reply_img_profile);
        }else {
            Glide.with(MainActivity.this).load(R.drawable.logo_tot).into(main_burger_imgv_circle);
        }
        /* ========== = ===================================================== 로그아웃 ========== */

        main_burger_imgv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastCheck("프로필사진 바꾸기");
                if(Logined.picture_filepath == null){
                    Toast.makeText(MainActivity.this, "null임", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "filepath 있음", Toast.LENGTH_SHORT).show();

                }

            }
        });
        //android:visibility="invisible"


        main_burger_myboard = nav_headerview.findViewById(R.id.main_burger_myboard);
        main_burger_myscrap = nav_headerview.findViewById(R.id.main_burger_myscrap);
        main_burger_myparty = nav_headerview.findViewById(R.id.main_burger_myparty);

        main_burger_myboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWhosePage(1);
                 toastCheck();
            }
        });
        main_burger_myscrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWhosePage(2);
                 toastCheck();
            }
        });
        main_burger_myparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 toastCheck();
            }
        });


        TextView main_burger_tv_login = nav_headerview.findViewById(R.id.main_burger_tv_login);
        if (Logined.isLogined == true) {
            // main_burger_tv_login.setText("스태틱클래스.저장된이름");
            main_burger_tv_login.setText(Logined.member_id);
        }
        main_burger_tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        TextView main_burger_tv_join = nav_headerview.findViewById(R.id.main_burger_tv_join);
        main_burger_tv_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
        afterLogin = nav_headerview.findViewById(R.id.main_burger_afterlogin);
        if(Logined.isLogined==true){
            afterLogin.setVisibility(View.VISIBLE);
            main_burger_tv_join.setVisibility(View.INVISIBLE);
        }
        /* ===================================================================================== */


        /* =================================== 버거메뉴 =================================== */
        Menu nav_menu = nav_view.getMenu();
        NavigationView bottom_nav2;
        bottom_nav2 = findViewById(R.id.main_burger_view);
        bottom_nav2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                int id = item.getItemId();
                String tabText = (String) item.getTitle();
                String title = item.getTitle().toString();
                if (id == R.id.mainnav_notice) {
                    ChangeActivity(MainBurger00Activity.class, 1, tabText);
                } else if (id == R.id.mainnav_customer) {
                    ChangeActivity(MainBurger00Activity.class, 2, tabText);
                } else if (id == R.id.mainnav_policy) {
                    ChangeActivity(MainBurger00Activity.class, 3, tabText);
                } else if (id == R.id.mainnav_version) {
                    Date date = new Date();
                    Toast.makeText(MainActivity.this, "버전정보 확인 : " + date, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        /* ================================================================================ */


    }//onCreate()

    /* =================================== 메소드 ======================= */

    /* =================================== 상단 텍스트변경 =================================== */
    public void titleTextChange(TextView textView, String titleText) {
        textView.setText(titleText);
    }

    /* =================================== view변경 + 상단텍스트 변경 ===========-------======================== */
    public void ChangeFrament(int container, Fragment fragment, String titleText) {
        getSupportFragmentManager().beginTransaction().replace(container,fragment).addToBackStack(null).commit();
        main_tv_acttitle.setText(titleText);

    }

    public void ChangeActivity(Class nextAct, int tabcode) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode", tabcode);
        // intent.putExtra("tabText",tabText);
        startActivity(intent);
    }

    public void ChangeActivity(Class nextAct, int tabcode, String tabText) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode", tabcode);
        intent.putExtra("tabText", tabText);
        startActivity(intent);
    }

    public void ChangeActivity(Class nextClass) {
        Intent intent = new Intent(MainActivity.this, nextClass);
        startActivity(intent);
    }

    public void goSplash() {
        Intent intent = new Intent(MainActivity.this, SplashActivity.class);

        startActivity(intent);
        finish();
    }

    /* ============================== 뒤로가기 누번눌러 종료 ============---================== */
    private long backKeyPressedTime = 0;

    @Override
    public void onBackPressed() {

        Object ac = getSupportFragmentManager().getFragments().get(0).getClass();
        if (ac.equals( Fragment01HomeTab.class) || ac.equals(Fragment02CategoryTab.class) ||
         ac.equals( Fragment03BoardTab.class) || ac.equals(Fragment04PartyTab.class) || ac.equals(Fragment05IotTab.class)) {
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();

                return;
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                finish();
            }
        }else {
            manager.popBackStack();
        }
    }
    /* ======================================================================== */

    public void goWhosePage(int tabCode){
    Intent intent = new Intent(MainActivity.this, WhosePage00Activity.class);
    intent.putExtra("tabCode",tabCode);
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(Logined.member_id);
        memberDTO.setPicture_filepath(Logined.picture_filepath);
    intent.putExtra("memberDTO",memberDTO);
    startActivity(intent);}
    public void toastCheck(){
        Toast.makeText(this, "toastCheck", Toast.LENGTH_SHORT).show();
    }
    public void toastCheck(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}