package com.example.totproject.zzchaminhwan;

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
import com.example.totproject.zzchaminhwan.Adapter.NoticeAdapter;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;

import java.util.ArrayList;
import java.util.Date;

public class MainBurger01NoticeFg_backup extends Fragment {


    RecyclerView notice_rc_view;
    Context context;
    FragmentManager manager;
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NoticeVO vo = new NoticeVO();

            Fragment02CategoryDetail categoryDetail = new Fragment02CategoryDetail();
            getFragmentManager().beginTransaction().replace(R.id.cate_container, categoryDetail).commit();
            Bundle bundle = new Bundle();
            bundle.putString("sn", vo.getBoard_sn() + "");
            getParentFragmentManager().setFragmentResult("sn", bundle);

        }
    };

    public MainBurger01NoticeFg_backup(MainBurger00Activity mainBurger00Activity, FragmentManager manager) {
        this.context = mainBurger00Activity;
        this.manager = manager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup)
                inflater.inflate(R.layout.zzz_main_burger01_notice_fg, container, false);

        ArrayList<NoticeVO> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            NoticeVO vo = new NoticeVO();
            vo.setBoard_title(i + 1 + "번째 공지사항 제목");
            vo.setBoard_date_create("data");

            list.add(vo);
        }
        notice_rc_view = v.findViewById(R.id.notice_list);


        LinearLayoutManager lmanager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false);
        NoticeAdapter adapter = new NoticeAdapter(getContext(), list, listener, manager);

        notice_rc_view.setLayoutManager(lmanager);
        notice_rc_view.setAdapter(adapter);

        //manager.setOrientation(LinearLayoutManager.VERTICAL);


        return v;
    }


}

