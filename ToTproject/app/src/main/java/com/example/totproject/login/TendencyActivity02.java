package com.example.totproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.totproject.R;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.kwkCommonAsk;
import com.example.totproject.main.MainActivity;
import com.google.gson.Gson;

import java.io.InputStream;

public class TendencyActivity02 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup mbti_buddy, mbti_family, mbti_price, mbti_sd, mbti_io;
    RadioButton mbti_buddy_rad1, mbti_buddy_rad2, mbti_buddy_rad3, mbti_buddy_rad4, mbti_buddy_rad5, mbti_family_rad1, mbti_family_rad2, mbti_family_rad3, mbti_family_rad4, mbti_family_rad5, mbti_price_rad1, mbti_price_rad2, mbti_price_rad3, mbti_price_rad4, mbti_price_rad5, mbti_sd_rad1, mbti_sd_rad2, mbti_sd_rad3, mbti_sd_rad4, mbti_sd_rad5, mbti_io_rad1, mbti_io_rad2, mbti_io_rad3, mbti_io_rad4, mbti_io_rad5;
    Button tend2_btn_skip, tend2_btn_join;
    int tabcode = 0;
    MbtiVO dto2 = new MbtiVO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency_activity_02);

        mbti_buddy = findViewById(R.id.mbti_buddy);
        mbti_family = findViewById(R.id.mbti_family);
        mbti_price = findViewById(R.id.mbti_price);
        mbti_sd = findViewById(R.id.mbti_sd);
        mbti_io = findViewById(R.id.mbti_io);

        mbti_buddy_rad1 = findViewById(R.id.mbti_buddy_rad1);
        mbti_buddy_rad2 = findViewById(R.id.mbti_buddy_rad2);
        mbti_buddy_rad3 = findViewById(R.id.mbti_buddy_rad3);
        mbti_buddy_rad4 = findViewById(R.id.mbti_buddy_rad4);
        mbti_buddy_rad5 = findViewById(R.id.mbti_buddy_rad5);
        mbti_buddy_rad1.setTag(1);
        mbti_buddy_rad2.setTag(2);
        mbti_buddy_rad3.setTag(3);
        mbti_buddy_rad4.setTag(4);
        mbti_buddy_rad5.setTag(5);

        mbti_family_rad1 = findViewById(R.id.mbti_family_rad1);
        mbti_family_rad2 = findViewById(R.id.mbti_family_rad2);
        mbti_family_rad3 = findViewById(R.id.mbti_family_rad3);
        mbti_family_rad4 = findViewById(R.id.mbti_family_rad4);
        mbti_family_rad5 = findViewById(R.id.mbti_family_rad5);
        mbti_family_rad1.setTag(1);
        mbti_family_rad2.setTag(2);
        mbti_family_rad3.setTag(3);
        mbti_family_rad4.setTag(4);
        mbti_family_rad5.setTag(5);

        mbti_price_rad1 = findViewById(R.id.mbti_price_rad1);
        mbti_price_rad2 = findViewById(R.id.mbti_price_rad2);
        mbti_price_rad3 = findViewById(R.id.mbti_price_rad3);
        mbti_price_rad4 = findViewById(R.id.mbti_price_rad4);
        mbti_price_rad5 = findViewById(R.id.mbti_price_rad5);
        mbti_price_rad1.setTag(1);
        mbti_price_rad2.setTag(2);
        mbti_price_rad3.setTag(3);
        mbti_price_rad4.setTag(4);
        mbti_price_rad5.setTag(5);

        mbti_sd_rad1 = findViewById(R.id.mbti_sd_rad1);
        mbti_sd_rad2 = findViewById(R.id.mbti_sd_rad2);
        mbti_sd_rad3 = findViewById(R.id.mbti_sd_rad3);
        mbti_sd_rad4 = findViewById(R.id.mbti_sd_rad4);
        mbti_sd_rad5 = findViewById(R.id.mbti_sd_rad5);
        mbti_sd_rad1.setTag(1);
        mbti_sd_rad2.setTag(2);
        mbti_sd_rad3.setTag(3);
        mbti_sd_rad4.setTag(4);
        mbti_sd_rad5.setTag(5);

        mbti_io_rad1 = findViewById(R.id.mbti_io_rad1);
        mbti_io_rad2 = findViewById(R.id.mbti_io_rad2);
        mbti_io_rad3 = findViewById(R.id.mbti_io_rad3);
        mbti_io_rad4 = findViewById(R.id.mbti_io_rad4);
        mbti_io_rad5 = findViewById(R.id.mbti_io_rad5);
        mbti_io_rad1.setTag(1);
        mbti_io_rad2.setTag(2);
        mbti_io_rad3.setTag(3);
        mbti_io_rad4.setTag(4);
        mbti_io_rad5.setTag(5);


        tend2_btn_skip = findViewById(R.id.tend2_btn_skip);
        tend2_btn_join = findViewById(R.id.tend2_btn_join);

        MbtiVO dto1 = (MbtiVO) getIntent().getSerializableExtra("TendDTO");
        mbti_buddy.setOnCheckedChangeListener(this);
        mbti_family.setOnCheckedChangeListener(this);
        mbti_price.setOnCheckedChangeListener(this);
        mbti_sd.setOnCheckedChangeListener(this);
        mbti_io.setOnCheckedChangeListener(this);
        dto2.setMbti_tour(dto1.getMbti_tour());
        dto2.setMbti_activity(dto1.getMbti_activity());
        dto2.setMbti_festival(dto1.getMbti_festival());
        dto2.setMbti_solo(dto1.mbti_solo);
        dto2.setMbti_couple(dto1.getMbti_couple());


        tend2_btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TendencyActivity02.this, "회원가입", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TendencyActivity02.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tend2_btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity02.this, MainActivity.class);
                intent.putExtra("TendDTO", dto2);
                Toast.makeText(TendencyActivity02.this, "회원가입", Toast.LENGTH_SHORT).show();
                //tendConnect(dto);
                // startActivity(intent);

            }
        });
    }// oncreate()


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rdo_btn = findViewById(radioGroup.getCheckedRadioButtonId());


        if (radioGroup.getId() == R.id.mbti_buddy) {
            dto2.setMbti_buddy((Integer) rdo_btn.getTag());
        } else if (radioGroup.getId() == R.id.mbti_family) {
            dto2.setMbti_family((Integer) rdo_btn.getTag());
        } else if (radioGroup.getId() == R.id.mbti_price) {
            dto2.setMbti_price((Integer) rdo_btn.getTag());
        } else if (radioGroup.getId() == R.id.mbti_sd) {
            dto2.setMbti_sd((Integer) rdo_btn.getTag());
        } else if (radioGroup.getId() == R.id.mbti_io) {
            dto2.setMbti_io((Integer) rdo_btn.getTag());
        }


    }


    CommonMethod commonMethod = new CommonMethod();
    kwkCommonAsk commonAsk;
    Gson gson = new Gson();

    public void tendConnect(MbtiVO dto) {
        commonAsk = new kwkCommonAsk("tend_insert");
        String data = gson.toJson(dto);
        commonAsk.params.add(new CommonAskParam("vo", data));


        try {
            InputStream in = commonMethod.excuteAsk(commonAsk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}