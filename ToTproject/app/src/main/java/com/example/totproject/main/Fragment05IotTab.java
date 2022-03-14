package com.example.totproject.main;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.iot.IotDTO;
import com.example.totproject.iot.IotMainActivity;
import com.example.totproject.party.PartyListDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment05IotTab extends Fragment {

    LinearLayout lin_iot_start;
    ImageView imgv_iot_tab ;


    CommonAsk commonAsk;
    Gson gson = new Gson();

    int on_off = -1;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag_iot_tab, container, false);

        lin_iot_start = view.findViewById(R.id.lin_iot_start);
        imgv_iot_tab = view.findViewById(R.id.imgv_iot_tab);








        Glide.with(getContext()).load(R.drawable.travel_iot).into(imgv_iot_tab);
        imgv_iot_tab.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);




        // IoT 메인액티비티로 이동
        lin_iot_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Logined.member_id != null){
                    Intent intent =  new Intent(getActivity(), IotMainActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getActivity(), "로그인후 이용해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        });









        return view;
    }









}