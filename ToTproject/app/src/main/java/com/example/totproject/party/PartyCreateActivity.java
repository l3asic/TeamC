package com.example.totproject.party;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.MemberDTO;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class PartyCreateActivity extends Activity {
    EditText edt_party_name;
    EditText edt_party_detail;
    CheckBox checkbox_party_private;
    LinearLayout lin_display_tags;
    EditText edt_party_tag;
    TextView tv_party_tag1,tv_party_tag2,tv_party_tag3;
    Button btn_create_party,btn_create_party2;
    Button btn_party_tag;
    Button btn_checkid;
    ImageView imgv_back_btn;

    int can_pass = 2;   //2일시 중복체크상태, 1일시 이름 중복된 상태, 0일시 이름 (중복아님 파티가입가능)


    int party_sn;
    int party_pic = 0001;   //@@@@@@@@@@@@@@@@@@@@@사진 처리 다시 해보기 , DTO 세팅도 다시해야함@@@@@@@@@@@@@@@
    String party_name, party_detail, party_private, party_tag1, party_tag2, party_tag3;
    ArrayList tags = new ArrayList();

    CommonAsk commonAsk;
    Gson gson = new Gson();
    ArrayList<PartyListDTO> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_createparty);

        btn_checkid = findViewById(R.id.btn_checkid);
        edt_party_name = findViewById(R.id.edt_party_namet);
        edt_party_detail = findViewById(R.id.edt_party_detail);
        lin_display_tags = findViewById(R.id.lin_display_tags);
        checkbox_party_private = findViewById(R.id.checkbox_party_private);
        edt_party_tag = findViewById(R.id.edt_party_tag);
        btn_create_party = findViewById(R.id.btn_create_party);
        btn_create_party2 = findViewById(R.id.btn_create_party2);
        btn_party_tag = findViewById(R.id.btn_party_tag);
        tv_party_tag1 = findViewById(R.id.tv_party_tag1);
        tv_party_tag2 = findViewById(R.id.tv_party_tag2);
        tv_party_tag3 = findViewById(R.id.tv_party_tag3);
        imgv_back_btn = findViewById(R.id.imgv_back_btn);

        
        //뒤로가기 버튼
        imgv_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyCreateActivity.this, PartyMainActivity.class);
                startActivity(intent);
            }
        });

        //중복체크 버튼
        btn_checkid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String check = checkPartyName(edt_party_name.getText()+"");

                Toast.makeText(PartyCreateActivity.this, check, Toast.LENGTH_SHORT).show();

                if(check.equals("0")){
                    Toast.makeText(PartyCreateActivity.this, "사용가능한 파티 이름입니다.", Toast.LENGTH_SHORT).show();
                    can_pass = 0;
                }else{
                    Toast.makeText(PartyCreateActivity.this, "중복된 파티 이름입니다.", Toast.LENGTH_SHORT).show();
                    can_pass = 1;
                }

            }
        });

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



        // 태그추가 버튼
        btn_party_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (can_pass == 2){
                    Toast.makeText(PartyCreateActivity.this, "파티이름 중복체크를 해주세요", Toast.LENGTH_SHORT).show();
                }else if(can_pass == 1){
                    Toast.makeText(PartyCreateActivity.this, "파티이름 중복체크를 다시 해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    insertTags();
                }

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


        // 파티생성버튼1 (버거메뉴자리)
        btn_create_party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserCreateparty();
            }
        });

        // 파티생성버튼2 (아래버튼)
        btn_create_party2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserCreateparty();
            }
        });



    }//onCreate()

    // 태그 추가
    public void insertTags(){

        if (edt_party_tag.getText()+""!= null && tags.size() <3){
            String party_tag = edt_party_tag.getText()+"";
            tags.add(party_tag);
            setTags();      //태그 1~3 리스트로 세팅
            edt_party_tag.setText("");
        }else{
            Toast.makeText(PartyCreateActivity.this, "파티 태그는 최대 3개", Toast.LENGTH_SHORT).show();
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

    public void inserCreateparty(){
        party_name = edt_party_name.getText()+"";
        party_detail = edt_party_detail.getText()+"";

        if(checkbox_party_private.isChecked()){
            party_private = "y";
        }else{
            party_private = "n";
        }
        party_tag1 = tv_party_tag1.getText()+"";
        party_tag2 = tv_party_tag2.getText()+"";
        party_tag3 = tv_party_tag3.getText()+"";


        PartyListDTO dto = new PartyListDTO(0,party_pic,party_private,MemberDTO.id,party_name,party_detail,party_tag1,party_tag2,party_tag3, MemberDTO.id);
        insertParty(dto);

        Intent intent = new Intent(PartyCreateActivity.this, PartyMainActivity.class);
        intent.putExtra("tabcode",3);
        startActivity(intent);


    }//saveCreateParty()

    public String checkPartyName(String party_name) {
        String check = "1";
        commonAsk = new CommonAsk("android/party/checkpartyname");
        commonAsk.params.add(new CommonAskParam("party_name",party_name));

        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            check = gson.fromJson(new InputStreamReader(in), new TypeToken<String>() {
            }.getType());            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }




    public PartyListDTO insertParty(PartyListDTO dto) {
        commonAsk = new CommonAsk("android/party/insertParty");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));

        InputStream in = CommonMethod.excuteAsk(commonAsk);
        Toast.makeText(PartyCreateActivity.this, "파티 생성완료 ( 임시)", Toast.LENGTH_SHORT).show();

        return dto;
    }








}
