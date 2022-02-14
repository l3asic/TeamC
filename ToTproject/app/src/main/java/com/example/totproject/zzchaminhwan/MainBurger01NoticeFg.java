package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.zzchaminhwan.Adapter.NoticeAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainBurger01NoticeFg extends Fragment {


    RecyclerView notice_rc_view;
    Date date = new Date();
    List<BoardCommonVO> list = new ArrayList<>();
   /* public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              BoardCommonVO vo = new   BoardCommonVO();

            Fragment02CategoryDetail categoryDetail = new Fragment02CategoryDetail();
            getFragmentManager().beginTransaction().replace(R.id.cate_container, categoryDetail).commit();

            Bundle bundle = new Bundle();
            bundle.putString("sn", vo.getBoard_sn() + "");
            getParentFragmentManager().setFragmentResult("sn", bundle);

        }
    };*/

    Context context;
    FragmentManager manager;

    public MainBurger01NoticeFg(MainBurger00Activity mainBurger00Activity, FragmentManager manager) {
        this.context = mainBurger00Activity;
        this.manager = manager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup)
                inflater.inflate(R.layout.zzz_main_burger01_notice_fg, container, false);


        list();
/*        for (int i = 0; i < 10; i++) {
              BoardCommonVO vo = new   BoardCommonVO();
            vo.setBoard_title(i + 1 + "번째 공지사항 제목");
            vo.setBoard_date_create(date);

            list.add(vo);
        }*/
        notice_rc_view = v.findViewById(R.id.notice_list);


        LinearLayoutManager lmanager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false);
        NoticeAdapter adapter = new NoticeAdapter(getContext(), list, manager);

        notice_rc_view.setLayoutManager(lmanager);
        notice_rc_view.setAdapter(adapter);

        //manager.setOrientation(LinearLayoutManager.VERTICAL);


        return v;
    }

    CommonAsk service;
    Gson gson = new Gson();

    public List<BoardCommonVO> list() {

        service = new CommonAsk("android/cmh/board_list@board_class=notice/view_cnt=50/");
        InputStream in = CommonMethod.excuteAsk(service);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<BoardCommonVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

