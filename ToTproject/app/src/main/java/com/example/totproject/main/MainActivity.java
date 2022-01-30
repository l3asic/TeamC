package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
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
    int container;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_main);

        bottom_nav = findViewById(R.id.main_nav);
        container = R.id.container;
        Fragment01MainTab mainTab_frag = new Fragment01MainTab();
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab();
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();


        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bot_home) {
                    ChangeFrament(container, mainTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_category) {
                    ChangeFrament(container, categoryTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_board) {
                    ChangeFrament(container, boardTab_frag);
                    return true;
                } else if (item.getItemId() == R.id.bot_party) {
                    ChangeFrament(container, partyTab_frag);
                    return true;
                }
                //One day we have to make that the IotTab@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //fking i can't typing Korean;;;


                return false;
            }
        });


        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );//햄버거 버튼 만들기 ( 버튼을 눌러서 반전시키는 효과를 만듬 )

             drawer.addDrawerListener(toggle);
               toggle.syncState();




        NavigationView nav_view = findViewById(R.id.main_nav_view);
        View nav_headerview = nav_view.getHeaderView(0);
        ImageView nav_img = nav_headerview.findViewById(R.id.mainnav_image);
        TextView nav_textv = nav_headerview.findViewById(R.id.mainnav_nickname);


    }//onCreate()

    public void ChangeFrament(int container, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
    }

}