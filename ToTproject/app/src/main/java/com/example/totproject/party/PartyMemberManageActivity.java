package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    RecyclerView rec_member_list;
    ArrayList<MemberDTO> member_list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();

    ImageView imgv_partleader_pic;
    TextView tv_partyleader_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_membermanage);

        rec_member_list = findViewById(R.id.rec_member_list);
        imgv_partleader_pic =findViewById(R.id.imgv_partleader_pic);
        tv_partyleader_name =findViewById(R.id.tv_partyleader_name);




        Intent getIntent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) getIntent.getSerializableExtra("plDTO");
        showPartyMember(plDTO);

        if (member_list != null){

            for (int i =0; i<member_list.size(); i++){
                // 파티장 영역 세팅
                if (member_list.get(i).getMember_id().equals(plDTO.getParty_leader())){
                    tv_partyleader_name.setText(member_list.get(i).getMember_nick());
                    member_list.remove(i);  // 파티장 정보 세팅하고 파티장리스트는 지워줌 (멤버에 안들어가게)

                }
            }

            // 파티원 목록 리싸이클러 뷰 영역
            PartymemberManageAdapter partymemberManageAdapter = new PartymemberManageAdapter(PartyMemberManageActivity.this, member_list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(
                    PartyMemberManageActivity.this , RecyclerView.VERTICAL , false
            );
            rec_member_list.setLayoutManager(layoutManager);
            rec_member_list.setAdapter(partymemberManageAdapter);
        }else{
            Toast.makeText(PartyMemberManageActivity.this, "가입된 파티원이 없습니다 (임시)", Toast.LENGTH_SHORT).show();
        }











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