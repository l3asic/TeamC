package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totproject.R;
import com.example.totproject.category.DetailDTO;
import com.example.totproject.category.Fragment02CategoryDetail;
import com.example.totproject.category.GridDTO;
import com.example.totproject.category.RecAdapter;

import java.util.ArrayList;

public class MainBurger01NoticeFg extends Fragment {


    RecyclerView notice_rc_view;
    Context context;

    NoticeVO vo = new NoticeVO();
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainBurger01NoticeFgDetail noticeDetail = new MainBurger01NoticeFgDetail();
            getFragmentManager().beginTransaction().replace(R.id.mainburger_container, noticeDetail).commit();
            Bundle bundle = new Bundle();
            bundle.putString("title", vo.getTitle()+"");
            getParentFragmentManager().setFragmentResult("title",bundle);

        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.zzz_main_burger01_notice_fg, container, false);

        ArrayList<NoticeVO> list = new ArrayList<>();
        for(int i=0; i < 50; i++) {
            vo.setTitle(i+"");
            vo.setWritedate(i+"");

            list.add(vo);
        }

        NoticeAdapter adapter = new NoticeAdapter(getContext(),list);
        notice_rc_view = rootView.findViewById(R.id.notice_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        notice_rc_view.setLayoutManager(layoutManager);

        notice_rc_view.setAdapter(adapter);


        return rootView;
    }
/*    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("sn", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String sn, @NonNull Bundle bundle) {
                String result = bundle.getString("sn");

                Log.d("asdfg", result);
            }
        });
    }*/



}

