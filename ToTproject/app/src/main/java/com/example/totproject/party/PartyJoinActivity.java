package com.example.totproject.party;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.MemberDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PartyJoinActivity extends AppCompatActivity {

    TextView tv_partyjoin_name, tv_partyjoin_detail, tv_partyjoin_hashtag1, tv_partyjoin_hashtag2, tv_partyjoin_hashtag3, tv_partyjoin_cntmember;
    ImageView imgv_partyjoin_partyimg;


    GridView gridView;
    LinearLayout lin_partyjoin_btn;
    ArrayList<PartymemberListDTO> partymemberList = new ArrayList<>();

    ArrayList<PartyListDTO> list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_partyjoin);


        tv_partyjoin_name = findViewById(R.id.tv_partyjoin_name);
        imgv_partyjoin_partyimg = findViewById(R.id.imgv_partyjoin_partyimg);
        tv_partyjoin_detail = findViewById(R.id.tv_partyjoin_detail);
        tv_partyjoin_hashtag1 = findViewById(R.id.tv_partyjoin_hashtag1);
        tv_partyjoin_hashtag2 = findViewById(R.id.tv_partyjoin_hashtag2);
        tv_partyjoin_hashtag3 = findViewById(R.id.tv_partyjoin_hashtag3);
        tv_partyjoin_cntmember = findViewById(R.id.tv_partyjoin_cntmember);



        Intent intent = getIntent();
        int party_sn = intent.getIntExtra("party_sn",0);
        partyDetail(party_sn);

        // String member_id = memberDTO.getMember_id;
        String member_id = "b01";   //@@@@@@@@@@ 임시 아이디임 멤버DTO에서 받아올것@@@@@@@@

        for (int i =0 ; i<list.size(); i++){
            partymemberList.add(new PartymemberListDTO(list.get(i).getMember_id(),0));
        }

        tv_partyjoin_name.setText(list.get(0).getParty_name());
        //imgv_partyjoin_partyimg.setImageResource(list.get(0).getPicture_filepath());      //@@@@@@ 파티 대표 사진처리
        tv_partyjoin_detail.setText(list.get(0).getParty_detail());
        tv_partyjoin_hashtag1.setText(list.get(0).getParty_tag1());
        tv_partyjoin_hashtag2.setText(list.get(0).getParty_tag2());
        tv_partyjoin_hashtag3.setText(list.get(0).getParty_tag3());
        tv_partyjoin_cntmember.setText("가입된 멤버" + "("+list.size() +")");


        PartymemberListAdapter adapter = new PartymemberListAdapter(PartyJoinActivity.this, partymemberList);
        gridView = findViewById(R.id.grid_memberlist);
        gridView.setAdapter(adapter);

        lin_partyjoin_btn = findViewById(R.id.lin_partyjoin_btn);


        lin_partyjoin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartyListDTO dto = new PartyListDTO(
                        list.get(0).getParty_sn(),
                        list.get(0).getPicture_filepath(),
                        list.get(0).getParty_private(),
                        list.get(0).getParty_leader(),
                        list.get(0).getParty_name(),
                        list.get(0).getParty_detail(),
                        list.get(0).getParty_tag1(),
                        list.get(0).getParty_tag2(),
                        list.get(0).getParty_tag3(),
                        member_id
                        );
                partyJoin(dto);




                Intent intent = new Intent(PartyJoinActivity.this,PartyMainActivity.class);
                //intent.putExtra("joindata",)
                startActivity(intent);
            }
        });


    }//onCreate()

    public ArrayList<PartyListDTO> partyDetail(int party_sn){
        commonAsk = new CommonAsk("android/party/partydetail");
        commonAsk.params.add(new CommonAskParam("party_sn",party_sn+""));        //@@@@@@ 아이디 => 멤버 아이디로해줄것
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyListDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }//partyJoin()

    public void partyJoin(PartyListDTO dto){
        commonAsk = new CommonAsk("android/party/partyJoin");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

//        try {
//            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyListDTO>>() {
//            }.getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }//partyJoin()



}