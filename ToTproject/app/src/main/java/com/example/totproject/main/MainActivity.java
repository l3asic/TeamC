package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.totproject.R;
import com.example.totproject.board.BoardMainActivity;
import com.example.totproject.login.JoinActivity;
import com.example.totproject.login.LoginActivity;
import com.example.totproject.login.TendencyActivity01;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //https://salix97.tistory.com/72
    BottomNavigationView bottom_nav;
    int main_container;
    Button main_btn_burger;
    Toolbar toolbar;
    ImageView cancel;

    LinearLayout afterLogin, main_burger_myboard, main_burger_myscrap, main_burger_myparty;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_main);
        if(android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);}

        bottom_nav = findViewById(R.id.main_nav);
        main_container = R.id.main_container;
        Fragment01HomeTab mainTab_frag = new Fragment01HomeTab(MainActivity.this, manager);
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab();
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();
        Fragment05IotTab loginTab_frag = new Fragment05IotTab();
        //ChangeFrament(main_container, mainTab_frag);
        //getSupportFragmentManager().beginTransaction().replace(R.id.main_container, mainTab_frag).commit();
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bot_home) {
                    //ChangeFrament(main_container, mainTab_frag);
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, mainTab_frag).commit();
                    return true;
                } else if (item.getItemId() == R.id.bot_category) {
                    ChangeFrament(main_container, categoryTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_board) {
                    //   ChangeFrament(main_container, boardTab_frag);
                    Intent intent = new Intent(MainActivity.this, BoardMainActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.bot_party) {
                    ChangeFrament(main_container, partyTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_iot) {
                    ChangeActivity(TendencyActivity01.class);
                   // ChangeFrament(main_container, loginTab_frag); //★★아이오티 화면나오면 수정해야함
                    return true;
                }
                //One day we have to make that the IotTab@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //fking i can't typing Korean;;;


                return false;
            }
        });


        //차민환

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );//햄버거 버튼 만들기 ( 버튼을 눌러서 반전시키는 효과를 만듬 )

        drawer.addDrawerListener(toggle);
        /* toggle.syncState();*/

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

        NavigationView nav_view = findViewById(R.id.main_burger_view);
        View nav_headerview = nav_view.getHeaderView(0);

        cancel = nav_headerview.findViewById(R.id.mainburger_btn_cancel);
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
        ImageView main_burger_imgv_circle = nav_headerview.findViewById(R.id.main_burger_imgv_circle);
        main_burger_imgv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "이미지 눌렸음 ㅎ", Toast.LENGTH_SHORT).show();

            }
        });

        afterLogin = nav_headerview.findViewById(R.id.main_burger_afterlogin);
        main_burger_myboard = nav_headerview.findViewById(R.id.main_burger_myboard);
        main_burger_myscrap = nav_headerview.findViewById(R.id.main_burger_myscrap);
        main_burger_myparty = nav_headerview.findViewById(R.id.main_burger_myparty);

        main_burger_myboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        main_burger_myscrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });
        main_burger_myparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "이미지 눌렸음 ", Toast.LENGTH_SHORT).show();
            }
        });


        TextView main_burger_tv_login = nav_headerview.findViewById(R.id.main_burger_tv_login);
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


    }//onCreate()

    //메소드
    public void ChangeFrament(int container, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
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
    
    public  void ChangeActivity(Class nextClass){
        Intent intent = new Intent(MainActivity.this, nextClass);
        startActivity(intent);
    }

    //.
    // 마지막으로 뒤로가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로가기 버튼을 누를때 표시
    private Toast toast;
    @Override
    public void onBackPressed() {
        // 기존 뒤로가기 버튼의 기능을 막기위해 주석처리 또는 삭제
        // super.onBackPressed();

        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지났으면 Toast Show
        // 2000 milliseconds = 2 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
            toast.cancel();
        }
    }

}