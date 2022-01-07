package com.example.chaminhwan_kakaostory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chaminhwan_kakaostory.fgm.fgm01_home;
import com.example.chaminhwan_kakaostory.fgm.fgm02_search;
import com.example.chaminhwan_kakaostory.fgm.fgm03_center;
import com.example.chaminhwan_kakaostory.fgm.fgm04_notice;
import com.example.chaminhwan_kakaostory.fgm.fgm05_mypage;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//https://jeong9216.tistory.com/3

public class MainActivity extends AppCompatActivity {
    LinearLayout fgm_00;
    ActionBar actionBar; //전역변수로 Actionbar를 선언만 해둠.
    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();//os가 return
        //actionBar.setTitle("머야 ㅆ");
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.tab1) {
                    changeFragment(new fgm01_home(), "tab1이 선택됨");
                    return true;
                } else if (item.getItemId() == R.id.tab2) {
                    changeFragment(new fgm02_search(), "tab2이 선택됨");
                    return true;
                } else if (item.getItemId() == R.id.tab3) {
                    changeFragment(new fgm03_center(), "tab3이 선택됨");
                    return true;
                } else if (item.getItemId() == R.id.tab4) {
                    changeFragment(new fgm04_notice(), "tab4이 선택됨");
                    return true;
                } else if (item.getItemId() == R.id.tab5) {
                    changeFragment(new fgm05_mypage(), "tab5이 선택됨");
                    return true;
                }


                return false;
            }
        });

    }

    public void changeFragment(Fragment fragment , String msg){
       Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.container , fragment).commit();
    }


}


