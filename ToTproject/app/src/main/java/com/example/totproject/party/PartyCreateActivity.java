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
import java.util.List;
import java.util.concurrent.ExecutionException;

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



    int party_sn;
    int party_pic = 0001;   //@@@@@@@@@@@@@@@@@@@@@사진 처리 다시 해보기 @@@@@@@@@@@@@@@
    String party_leader = "준호";     //@@@@@@@@@@@@@@@@@@@@@@ DTO 멤버 아이디 불러오기@@@@@@@@@@@@@@@
    // String party_member = "b08";    //@@@@@@@@@@@@@@@@@@@@@@ DTO 멤버 아이디 불러오기 - 완료?@@@@@@@@@@@@@@@
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
        edt_party_name = findViewById(R.id.edt_party_name);
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
                // @@@@@@@@@@@ 파티 아이디 중복체크 할것 @@@@@@@@@@
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
        party_sn = 03;     //@@@@@ 스프링에서 추가넘버 삽입?
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

//      ArrayList<PartyListDTO> dto = new ArrayList<>();
//      dto.add(new PartyListDTO(party_sn,party_pic,party_private,party_leader,party_name,party_detail,party_tag1,party_tag2,party_tag3));

        PartyListDTO dto = new PartyListDTO(party_sn,party_pic,party_private,party_leader,party_name,party_detail,party_tag1,party_tag2,party_tag3, MemberDTO.id);


        //@@@@@@@@@@@@@ 여기에 디비 async 연결 코드 추가 해줄것@@@@@@@@@@@

//        ask = new CommonAsk("partyCreate.tot");        //매핑, dto값들
//        try {
//            ask.execute().get();     //get 은 inputString 위해
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        insertParty(dto);

















        Intent intent = new Intent(PartyCreateActivity.this, PartyMainActivity.class);
        intent.putExtra("tabcode",3);
        startActivity(intent);


    }//saveCreateParty()



    public PartyListDTO insertParty(PartyListDTO dto) {
        commonAsk = new CommonAsk("android/party/insertParty");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));

        InputStream in = CommonMethod.excuteAsk(commonAsk);
        Toast.makeText(PartyCreateActivity.this, "파티 생성완료 ( 임시)", Toast.LENGTH_SHORT).show();

        return dto;
    }








}
