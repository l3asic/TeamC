package com.example.totproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.MainActivity;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

public class TendencyActivity extends AppCompatActivity {
    TendencyMainFrag mainFrag = new TendencyMainFrag();
    TendencyResearchFrag researchFrag = new TendencyResearchFrag();
    TendencyResultFrag resultFrag = new TendencyResultFrag();
    int backIndex = 0;
    TendDTO dto ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency);
        selectTend();
        if(dto != null){
            changeFragment(2);
        }else{
            changeFragment(0);
        }
        findViewById(R.id.category_img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    Gson gson = new Gson();
    public TendDTO selectTend(){

        CommonAsk commonAsk = new CommonAsk("tend_list");
        commonAsk.params.add(new CommonAskParam("member_id", Logined.member_id));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {

            dto   = gson.fromJson(new InputStreamReader(in), TendDTO.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public void changeFragment(int frag){
        if(frag != 0 ){
            backIndex = frag-1;
        }

        if(frag == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFrag).commit();
        }else if(frag == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,researchFrag).commit();
        }else if(frag == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,resultFrag).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(backIndex == 0){
            finish();
        }else {
            changeFragment(backIndex);
        }
    }
}