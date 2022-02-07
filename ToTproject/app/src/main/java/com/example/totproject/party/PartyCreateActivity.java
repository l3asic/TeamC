package com.example.totproject.party;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;

import java.util.ArrayList;

public class PartyCreateActivity extends Activity {
    EditText edt_party_name;
    EditText edt_party_detail;
    CheckBox checkbox_party_private;
    EditText edt_party_tag;
    TextView tv_party_tag1,tv_party_tag2,tv_party_tag3;
    Button btn_create_party;
    Button btn_party_tag;

    int party_pic = 0001;   //@사진 처리 다시 해보기
    String party_sn, party_name, party_detail, party_private, party_tag1, party_tag2, party_tag3;
    ArrayList tags = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_createparty);

        edt_party_name = findViewById(R.id.edt_party_name);
        edt_party_detail = findViewById(R.id.edt_party_detail);
        checkbox_party_private = findViewById(R.id.checkbox_party_private);
        edt_party_tag = findViewById(R.id.edt_party_tag);
        btn_create_party = findViewById(R.id.btn_create_party);
        btn_party_tag = findViewById(R.id.btn_party_tag);
        tv_party_tag1 = findViewById(R.id.tv_party_tag1);
        tv_party_tag2 = findViewById(R.id.tv_party_tag2);
        tv_party_tag3 = findViewById(R.id.tv_party_tag3);



        // 태그 넣기 (최대3개)
        btn_party_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tags.size() <3 ){
                    tags.add(edt_party_tag.getText()+"");
                }else{
                    Toast.makeText(PartyCreateActivity.this, "파티 태그 최대 갯수는 3개입니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });



        //태그 리스트로 뿌리기..
        party_tag1 = "#" + tags.get(0);
        party_tag2 = "#" + tags.get(1);
        party_tag3 = "#" + tags.get(2);


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
                dto.add(new PartyListDTO(party_pic,party_sn,party_private,party_name,party_detail,party_tag1,party_tag2,party_tag3));




            }
        });










    }
}
