package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.totproject.R;

public class PartyMainActivity extends AppCompatActivity {

    int tabcode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_main);

        OpenpartyListFragment openparty_list_frag = new OpenpartyListFragment();
        MypartyListFragment myparty_list_frag = new MypartyListFragment();

        Intent party_intent = getIntent();

        tabcode =party_intent.getIntExtra("tabcode",0);

        if(tabcode == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, openparty_list_frag).commit();
        }
        if(tabcode == 2){
            Intent intent = new Intent(PartyMainActivity.this,PartyCreateActivity.class);
            startActivity(intent);
        }
        if(tabcode == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, myparty_list_frag).commit();
        }






    }
}