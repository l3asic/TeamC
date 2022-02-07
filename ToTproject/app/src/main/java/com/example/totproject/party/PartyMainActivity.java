package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.totproject.R;

public class PartyMainActivity extends AppCompatActivity {

    int tabcode = 0 ;
    TextView party_title;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_main);

        party_title = findViewById(R.id.party_title);

        OpenpartyListFragment openparty_list_frag = new OpenpartyListFragment(PartyMainActivity.this);
        MypartyListFragment myparty_list_frag = new MypartyListFragment(PartyMainActivity.this);

        Intent party_intent = getIntent();

        tabcode =party_intent.getIntExtra("tabcode",0);

        if(tabcode == 1 || tabcode ==0 ){   //공개 파티목록 띄우기
            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, openparty_list_frag).commit();
            party_title.setText("공개 파티 목록");
        }
        if(tabcode == 2){   //파티 만들기 
            Intent intent = new Intent(PartyMainActivity.this,PartyCreateActivity.class);
            startActivity(intent);
        }
        if(tabcode == 3){   //내파티리스트 띄우기
            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, myparty_list_frag).commit();
            party_title.setText("가입된 파티 목록");
        }






    }//onCreate()
}