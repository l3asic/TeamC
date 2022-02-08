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



import java.util.ArrayList;

public class PartyCreateActivity extends Activity {
    EditText edt_party_name;
    EditText edt_party_detail;
    CheckBox checkbox_party_private;
    LinearLayout lin_display_tags;
    EditText edt_party_tag;
    TextView tv_party_tag1,tv_party_tag2,tv_party_tag3;
    Button btn_create_party;
    Button btn_party_tag;
    Button btn_checkid;
    ImageView imgv_back_btn;

    int party_pic = 0001;   //@@@@@@@@@@@@@@@@@@@@@사진 처리 다시 해보기 ++ 멤버 스피너 처리 해보기@@@@@@@@@@@@@@@
    String party_leader = "준호";     //@@@@@@@@@@@@@@@@@@@@@@ DTO 멤버 아이디 불러오기@@@@@@@@@@@@@@@
    String party_sn, party_name, party_detail, party_private, party_tag1, party_tag2, party_tag3;
    ArrayList tags = new ArrayList();



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
        btn_party_tag = findViewById(R.id.btn_party_tag);
        tv_party_tag1 = findViewById(R.id.tv_party_tag1);
        tv_party_tag2 = findViewById(R.id.tv_party_tag2);
        tv_party_tag3 = findViewById(R.id.tv_party_tag3);
        imgv_back_btn = findViewById(R.id.imgv_back_btn);

        
        //뒤로가기
        imgv_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyCreateActivity.this, PartyMainActivity.class);
                startActivity(intent);
            }
        });

        btn_checkid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // @@@@@@@@@@@ 파티 아이디 중복체크 할것 @@@@@@@@@@
            }
        });


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




        btn_party_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTags();
            }
        });

        tv_party_tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(0);
            }
        });

        tv_party_tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(1);
            }
        });

        tv_party_tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTags(2);
            }
        });



        btn_create_party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                
                party_sn = "partysn00";     //@@@@@ 스프링에서 추가넘버 삽입?
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

                ArrayList<PartyListDTO> dto = new ArrayList<>();
                dto.add(new PartyListDTO(party_pic,party_sn,party_private,party_leader,party_name,party_detail,party_tag1,party_tag2,party_tag3));
                
                //@@@@@@@@@@@@@ 여기에 디비 async 연결 코드 추가 해줄것@@@@@@@@@@@
                
                

                Intent intent = new Intent(PartyCreateActivity.this, PartyMainActivity.class);
                intent.putExtra("tabcode",3);
                startActivity(intent);




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








}
