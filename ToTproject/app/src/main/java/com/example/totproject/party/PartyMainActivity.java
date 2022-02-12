package com.example.totproject.party;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.totproject.R;
import com.example.totproject.common.CommonMethod;

public class PartyMainActivity extends AppCompatActivity {


    TextView party_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_main);
        int tabcode = 0 ;
        party_title = findViewById(R.id.party_title);

        OpenpartyListFragment openparty_list_frag = new OpenpartyListFragment(PartyMainActivity.this);
        MypartyListFragment myparty_list_frag = new MypartyListFragment(PartyMainActivity.this);

        Intent party_intent = getIntent();

        tabcode = party_intent.getIntExtra("tabcode",0);

        if(tabcode == 1 || tabcode ==0 ){   //공개 파티목록 띄우기
            changeFrag(openparty_list_frag, "공개 파티 목록");
//            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, openparty_list_frag).commit();
//            party_title.setText("공개 파티 목록");
        }
        if(tabcode == 2){   //파티 만들기 
            Intent intent = new Intent(PartyMainActivity.this,PartyCreateActivity.class);
            startActivity(intent);
        }
        if(tabcode == 3){   //내파티리스트 띄우기
            changeFrag(myparty_list_frag,"가입된 내 파티 목록");
//            getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, myparty_list_frag).commit();
//            party_title.setText("가입된 파티 목록");
        }


    }//onCreate()

    public void changeFrag(Fragment frag, String title){
        getSupportFragmentManager().beginTransaction().replace(R.id.party_main_container, frag).commit();
        party_title.setText(title);
    }








}