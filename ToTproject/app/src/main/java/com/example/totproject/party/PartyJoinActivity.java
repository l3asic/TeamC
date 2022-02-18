package com.example.totproject.party;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;

import java.util.ArrayList;

public class PartyJoinActivity extends AppCompatActivity {
    GridView gridView;
    LinearLayout lin_partyjoin_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_partyjoin);

        ArrayList<PartymemberListDTO> list = new ArrayList<>();



        //@@@@@@@@@@@@@@@@@@ and dum data @@@@@@@@@@@@@@@@@@@@
        list.add(new PartymemberListDTO("user01",01,"junho1","partysn01"));
        list.add(new PartymemberListDTO("user02",02,"junho2","partysn02"));
        list.add(new PartymemberListDTO("user03",03,"junho3","partysn03"));
        list.add(new PartymemberListDTO("user04",04,"junho4","partysn04"));
        list.add(new PartymemberListDTO("user05",05,"junho5","partysn05"));
        list.add(new PartymemberListDTO("user05",05,"junho5","partysn05"));
        list.add(new PartymemberListDTO("user05",05,"junho5","partysn05"));
        list.add(new PartymemberListDTO("user05",05,"junho5","partysn05"));
        list.add(new PartymemberListDTO("user05",05,"junho5","partysn05"));
        //@@@@@@@@@@@@@@@@@@ and dum data @@@@@@@@@@@@@@@@@@@@




        PartymemberListAdapter adapter = new PartymemberListAdapter(PartyJoinActivity.this, list);
        gridView = findViewById(R.id.grid_memberlist);
        gridView.setAdapter(adapter);

        lin_partyjoin_btn = findViewById(R.id.lin_partyjoin_btn);


        lin_partyjoin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyJoinActivity.this,PartyMainActivity.class);
                //intent.putExtra("joindata",)
                startActivity(intent);
            }
        });







    }
}