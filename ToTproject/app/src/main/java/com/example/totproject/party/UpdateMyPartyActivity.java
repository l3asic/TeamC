package com.example.totproject.party;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.statics.Logined;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;

public class UpdateMyPartyActivity extends AppCompatActivity {
    TextView tv_party_name, tv_party_tag1,tv_party_tag2,tv_party_tag3;
    EditText edt_party_detail, edt_party_tag;
    CheckBox checkbox_party_private;
    Button btn_party_update, btn_party_tag;
    LinearLayout lin_display_tags;

    int party_sn;
    String party_pic = "0001";   //@@@@@@@@@@@@@@@@@@@@@사진 처리 다시 해보기 , DTO 세팅도 다시해야함@@@@@@@@@@@@@@@
    String party_name, party_detail, party_private, party_tag1, party_tag2, party_tag3;

    ArrayList tags = new ArrayList();

    CommonAsk commonAsk;
    Gson gson = new Gson();
    ArrayList<PartyListDTO> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_update_myparty);

        tv_party_name = findViewById(R.id.tv_party_name);
        edt_party_detail = findViewById(R.id.edt_party_detail);
        checkbox_party_private = findViewById(R.id.checkbox_party_private);
        btn_party_update = findViewById(R.id.btn_party_update);

        lin_display_tags = findViewById(R.id.lin_display_tags);
        edt_party_tag = findViewById(R.id.edt_party_tag);
        btn_party_tag = findViewById(R.id.btn_party_tag);
        tv_party_tag1 = findViewById(R.id.tv_party_tag1);
        tv_party_tag2 = findViewById(R.id.tv_party_tag2);
        tv_party_tag3 = findViewById(R.id.tv_party_tag3);


        Intent getIntent = getIntent();
        PartyListDTO plDTO = (PartyListDTO) getIntent.getSerializableExtra("plDTO");

        // 내파티 정보 보여주기 세팅

        tv_party_name.setText(plDTO.getParty_name());
        edt_party_detail.setText(plDTO.getParty_detail());

        if(plDTO.getParty_private().equals("y")){
            checkbox_party_private.setChecked(true);
            lin_display_tags.setVisibility(View.VISIBLE);
        }else{
            checkbox_party_private.setChecked(false);
            lin_display_tags.setVisibility(View.GONE);
        }

        //파티 공개여부 체크박스
        checkbox_party_private.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox_party_private.isChecked()){
                    lin_display_tags.setVisibility(View.VISIBLE);
                }else{
                    lin_display_tags.setVisibility(View.GONE);
                }

            }
        });

        tv_party_tag1.setText(plDTO.getParty_tag1());
        tv_party_tag2.setText(plDTO.getParty_tag2());
        tv_party_tag3.setText(plDTO.getParty_tag3());

        addTags(plDTO.getParty_tag1());
        addTags(plDTO.getParty_tag2());
        addTags(plDTO.getParty_tag3());


        // 태그추가 버튼
        btn_party_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTags();
            }
        });

        // 태그1 삭제버튼
        tv_party_tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(0);
            }
        });

        // 태그2 삭제버튼
        tv_party_tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(1);
            }
        });

        // 태그3 삭제버튼
        tv_party_tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(2);
            }
        });



        // 수정 저장 버튼 클릭시
        btn_party_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                party_sn = plDTO.getParty_sn();
                party_detail = edt_party_detail.getText() + "";

                if(checkbox_party_private.isChecked()){
                    party_private = "y";
                    party_tag1 = tv_party_tag1.getText()+"";
                    party_tag2 = tv_party_tag2.getText()+"";
                    party_tag3 = tv_party_tag3.getText()+"";
                }else{
                    party_private = "n";
                    party_tag1 = null;
                    party_tag2 = null;
                    party_tag3 = null;
                }
                


                PartyListDTO dto = new PartyListDTO(party_sn,party_pic,party_private, Logined.member_id,party_name,edt_party_detail.getText()+"", party_tag1,party_tag2,party_tag3, Logined.member_id);
                updateParty(dto);

                Intent intent = new Intent(UpdateMyPartyActivity.this, MyPartyInfoActivity.class);
                intent.putExtra("party_dto",dto);
                
                startActivity(intent);
            }
        });



    }//onCreate()

    private void updateParty(PartyListDTO dto) {
        commonAsk = new CommonAsk("android/party/updateparty");
        commonAsk.params.add(new CommonAskParam("dto", gson.toJson(dto)) );
        InputStream in = CommonMethod.excuteAsk(commonAsk);
    }

    private void addTags(String party_tag) {
        if (!party_tag.equals(null)){
            tags.add(party_tag);
        }
    }


    // 태그 추가
    public void insertTags(){

        if (edt_party_tag.getText()+""!= null && tags.size() <3){
            String party_tag = edt_party_tag.getText()+"";
            tags.add(party_tag);
            setTags();      //태그 1~3 리스트로 세팅
            edt_party_tag.setText("");
        }else{
            Toast.makeText(UpdateMyPartyActivity.this, "파티 태그는 최대 3개", Toast.LENGTH_SHORT).show();
            edt_party_tag.setText("");
        }


    }//insertTags()

    //TextView로 태그 세팅하기
    public void setTags(){
        if(tags.size() == 1){
            tv_party_tag1.setText("#"+tags.get(0));
            tv_party_tag2.setText("");
            tv_party_tag3.setText("");
        }else if(tags.size() == 2){
            tv_party_tag1.setText("#"+tags.get(0));
            tv_party_tag2.setText("#"+tags.get(1));
            tv_party_tag3.setText("");
        }else if(tags.size() == 3) {
            tv_party_tag1.setText("#"+tags.get(0));
            tv_party_tag2.setText("#"+tags.get(1));
            tv_party_tag3.setText("#"+tags.get(2));
        }else{
            tv_party_tag1.setText("");
            tv_party_tag2.setText("");
            tv_party_tag3.setText("");
        }


    }//setTags()


    //해당태그 클릭시 삭제
    public void deleteTags(int i){
        tags.remove(i);
        setTags();
    }


}