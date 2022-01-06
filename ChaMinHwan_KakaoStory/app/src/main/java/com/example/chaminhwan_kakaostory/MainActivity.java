package com.example.chaminhwan_kakaostory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.chaminhwan_kakaostory.fgm.fgm01_home;
import com.example.chaminhwan_kakaostory.fgm.fgm02_home;
import com.example.chaminhwan_kakaostory.fgm.fgm03_home;
import com.example.chaminhwan_kakaostory.fgm.fgm04_home;
import com.example.chaminhwan_kakaostory.fgm.fgm05_home;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//https://jeong9216.tistory.com/3

public class MainActivity extends AppCompatActivity {
    LinearLayout fgm_00;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        SettingListener();
        bottomNavigationView.setSelectedItemId(R.id.tab_01);
    }

    private void init() {
        fgm_00 = findViewById(R.id.fgm_00);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void SettingListener() { //선택 리스너 등록 bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener()); }


        class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_01: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fgm_00, new fgm01_home()).commit();
                        return true;
                    }
                    case R.id.tab_02: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fgm_00, new fgm02_home()).commit();
                        return true;
                    }
                    case R.id.tab_03: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fgm_00, new fgm03_home()).commit();
                        return true;
                    }
                    case R.id.tab_04: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fgm_00, new fgm04_home()).commit();
                        return true;
                    }
                    case R.id.tab_05: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fgm_00, new fgm05_home()).commit();
                        return true;
                    }
                }
                return false;
            }
        }
    }

}


