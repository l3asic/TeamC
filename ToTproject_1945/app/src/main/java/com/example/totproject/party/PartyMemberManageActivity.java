package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.Logined;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PartyMemberManageActivity extends AppCompatActivity {
    ArrayList<MemberDTO> member_list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_membermanage);

        Intent getIntent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) getIntent.getSerializableExtra("plDTO");
        showPartyMember(plDTO);







    }//onCreate()


    public ArrayList<MemberDTO> showPartyMember(PartyListDTO plDTO){
        commonAsk = new CommonAsk("android/party/showpartymember");
        commonAsk.params.add(new CommonAskParam("plDTO",gson.toJson(plDTO)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            member_list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<MemberDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return member_list;

    }//showMyPartylist()






}