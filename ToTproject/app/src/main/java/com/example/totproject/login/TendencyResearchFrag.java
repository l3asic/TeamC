package com.example.totproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.category.RecAdapter;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.kwkCommonAsk;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.MainActivity;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

public class TendencyResearchFrag extends Fragment {
    RecyclerView recv_tendency ;
    TendDTO dto;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tendency_research, container, false);
        recv_tendency = rootView.findViewById(R.id.recv_tendency);
        TendencyAdapter adapter = new TendencyAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recv_tendency.setLayoutManager(layoutManager);
        recv_tendency.setAdapter(adapter);
        rootView.findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dto = adapter.getDto();
                dto.setMember_id(Logined.member_id);
                int check = tendConnect(dto);
                if(check>=1){
                   changeFragment(2);

                }else{

                }
            }
        });

        return rootView;
    }
    CommonMethod commonMethod = new CommonMethod();
    CommonAsk commonAsk;
    Gson gson = new Gson();
    public int tendConnect(TendDTO dto){
        int succ = 0;
        commonAsk = new CommonAsk("tend_insert");
        String data = gson.toJson(dto);
        commonAsk.params.add(new CommonAskParam("vo",data));
        InputStream in = commonMethod.excuteAsk(commonAsk);
        try {

            succ   = gson.fromJson(new InputStreamReader(in), Integer.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return succ;
    }

    void changeFragment(int frag){
        TendencyActivity activity = (TendencyActivity) getActivity();
        activity.changeFragment(frag);
    }

}