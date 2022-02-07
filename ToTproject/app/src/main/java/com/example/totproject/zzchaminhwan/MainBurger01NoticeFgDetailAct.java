package com.example.totproject.zzchaminhwan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;


public class MainBurger01NoticeFgDetailAct extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzz_main_burger01_notice_fg_detail_act);


        ArrayList<NoticeVO> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            NoticeVO vo = new NoticeVO();
            vo.setTitle(i + "");
            vo.setWritedate("댓글" + i + i + i + i + i);

            list.add(vo);
        }
        NoticeAdapter adapter = new NoticeAdapter(MainBurger01NoticeFgDetailAct.this, list);
        //  recyclerView = rootView.findViewById(R.id.);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainBurger01NoticeFgDetailAct.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}