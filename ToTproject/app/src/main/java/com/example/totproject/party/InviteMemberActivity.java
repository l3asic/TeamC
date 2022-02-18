package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.party_plan.PlanInfoDTO;
import com.google.gson.Gson;

import java.io.InputStream;

public class InviteMemberActivity extends AppCompatActivity {

    EditText edt_member_id;
    CommonAsk commonAsk;
    Gson gson = new Gson();
    Button btn_party_memberinvite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_memberinvite);
        edt_member_id = findViewById(R.id.edt_member_id);
        btn_party_memberinvite = findViewById(R.id.btn_party_memberinvite);
        
        Intent getIntent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) getIntent.getSerializableExtra("plDTO");
        String temp = plDTO.getMember_id();


        // 멤버 초대 버튼 클릭시
        btn_party_memberinvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plDTO.setMember_id(edt_member_id.getText() + "");
                invitePartyMember(plDTO);
                plDTO.setMember_id(temp);
                Intent intent = new Intent(InviteMemberActivity.this,MyPartyInfoActivity.class);
                intent.putExtra("party_dto",plDTO);
                startActivity(intent);

            }
        });





    }//onCreate()

    public void invitePartyMember(PartyListDTO plDTO) {
        commonAsk = new CommonAsk("android/party/invitepartymember");
        commonAsk.params.add(new CommonAskParam("plDTO", gson.toJson(plDTO)));
        CommonMethod.excuteAsk(commonAsk);

    }
}