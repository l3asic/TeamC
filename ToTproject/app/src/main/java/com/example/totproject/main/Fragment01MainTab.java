package com.example.totproject.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.category.Fragment02CategoryDetail;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.Board_Common_VO;
import com.example.totproject.main.Adapter.MainTabAdapter;
import com.example.totproject.main.VO.MainTabVO;
import com.example.totproject.zzchaminhwan.Adapter.NoticeAdapter;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment01MainTab extends Fragment {

/*mRecyclerView.setLayoutManager(new LinearLayoutManager(this));	// 세로

mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));	// 가로*/

    RecyclerView maintab_rv_recommend, maintab_rv_nearby, maintab_rv_tour;


    ArrayList<Board_Common_VO> list = new ArrayList<>();

    Context context;
    FragmentManager manager;

    public Fragment01MainTab(MainActivity context, FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_frag_hometab, container, false);


        {

            list= list123("android/cmh/board.list.notice");
            maintab_rv_recommend = v.findViewById(R.id.maintab_rv_recommend);
            LinearLayoutManager lmanager = new LinearLayoutManager(
                    context, RecyclerView.HORIZONTAL, false);
            MainTabAdapter adapter = new MainTabAdapter(getContext(), list, manager);

            maintab_rv_recommend.setLayoutManager(lmanager);
            maintab_rv_recommend.setAdapter(adapter);
        }


        {
            list= list123("android/cmh/board.list.notice");
            maintab_rv_nearby = v.findViewById(R.id.maintab_rv_nearby);
            LinearLayoutManager lmanager = new LinearLayoutManager(
                    context, RecyclerView.HORIZONTAL, false);
            MainTabAdapter adapter = new MainTabAdapter(getContext(), list, manager);

            maintab_rv_nearby.setLayoutManager(lmanager);
            maintab_rv_nearby.setAdapter(adapter);
        }

        {
            list= list123("android/cmh/board.list.notice");
            maintab_rv_tour = v.findViewById(R.id.maintab_rv_tour);
            LinearLayoutManager lmanager = new LinearLayoutManager(
                    context, RecyclerView.VERTICAL, false);
            MainTabAdapter adapter = new MainTabAdapter(getContext(), list, manager);

            maintab_rv_tour.setLayoutManager(lmanager);
            maintab_rv_tour.setAdapter(adapter);
        }

        return v;
    }

    CommonAsk service;
    Gson gson = new Gson();

    public ArrayList<Board_Common_VO> list123(String mapping) {
        service = new CommonAsk(mapping);
        InputStream in = CommonMethod.excuteAsk(service);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<Board_Common_VO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}