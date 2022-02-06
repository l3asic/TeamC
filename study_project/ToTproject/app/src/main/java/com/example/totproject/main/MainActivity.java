package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_nav;
    int main_container;
    Button main_btn_burger;
    Toolbar toolbar;
    ImageView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_main);

        bottom_nav = findViewById(R.id.main_nav);
        main_container = R.id.main_container;
        Fragment01MainTab mainTab_frag = new Fragment01MainTab();
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab();
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();


        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bot_home) {
                    ChangeFrament(main_container, mainTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_category) {
                    ChangeFrament(main_container, categoryTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_board) {
                    ChangeFrament(main_container, boardTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_party) {
                    ChangeFrament(main_container, partyTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_iot) {
                    ChangeFrament(main_container, partyTab_frag); //★★아이오티 화면나오면 수정해야함
                    return true;
                }
                //One day we have to make that the IotTab@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //fking i can't typing Korean;;;


                return false;
            }
        });


        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

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
        ImageView nav_img = nav_headerview.findViewById(R.id.mainnav_image);
        TextView nav_textv = nav_headerview.findViewById(R.id.mainnav_nickname);

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
                    //ChangeActivity();
                    ChangeActivity(MainBurger00Activity.class,1,tabText);
                } else if (id == R.id.mainnav_customer) {
                    ChangeActivity(MainBurger00Activity.class,2,tabText);
                } else if (id == R.id.mainnav_policy) {
                    ChangeActivity(MainBurger00Activity.class,3,tabText);
                }else if (id == R.id.mainnav_version) {
                    Toast.makeText(MainActivity.this, "버전정보 확인", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });

    }//onCreate()

    public void ChangeFrament(int container, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
    }

    public void ChangeActivity(Class nextAct,int tabcode) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode",tabcode);
       // intent.putExtra("tabText",tabText);
        startActivity(intent);
    }
    public void ChangeActivity(Class nextAct,int tabcode ,String tabText) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode",tabcode);
         intent.putExtra("tabText",tabText);
        startActivity(intent);
    }



}