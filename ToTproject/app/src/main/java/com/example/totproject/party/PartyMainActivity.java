package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.totproject.R;

public class PartyMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04_party_main);
        Openparty_list_Fragment openparty_list_frag = new Openparty_list_Fragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, openparty_list_frag).commit();


    }
}