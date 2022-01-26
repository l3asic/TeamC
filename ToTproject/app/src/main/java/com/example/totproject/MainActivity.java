package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.totproject.party.PartyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    //PartyFragment party_frag = new PartyFragment(MainActivity.this);    //와 죽고싶다


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_main);

        bottom_nav = findViewById(R.id.main_nav);

        //   PartyFragment party_frag = new PartyFragment();

        PartyFragment party_frag = new PartyFragment();//ㅈㅈㅈㅅㅈㅅㅈㅅㅈㅅ

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, party_frag).commit();


    }//onCreate()


}//MainActivity()