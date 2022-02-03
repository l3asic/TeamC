package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.totproject.R;
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
                if(item.getItemId() == R.id.bot_home){
                    ChangeFrament(main_container, mainTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_category){
                    ChangeFrament(main_container, categoryTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_board) {
                    ChangeFrament(main_container, boardTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_party) {
                    ChangeFrament(main_container, partyTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_iot) {
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


        cancel = findViewById(R.id.mainburger_btn_cancel);
/*        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
            }
        });*/

        NavigationView nav_view = findViewById(R.id.main_nav_view);
        View nav_headerview = nav_view.getHeaderView(0);
        ImageView nav_img = nav_headerview.findViewById(R.id.mainnav_image);
        TextView nav_textv = nav_headerview.findViewById(R.id.mainnav_nickname);

    }//onCreate()

    public void ChangeFrament(int container, Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
    }

}