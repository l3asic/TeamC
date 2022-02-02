package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.totproject.R;

public class PartyMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_main);
        OpenpartyListFragment openparty_list_frag = new OpenpartyListFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, openparty_list_frag).commit();


    }
}