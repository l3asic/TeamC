package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainBurger01NoticeFgDetailFg extends Fragment {

    TextView notice_detail_title, notice_detail_content;
    TextView notice_detail_writedate;

    NoticeVO vo = new NoticeVO();

    Context context;
    FragmentManager manager;
    int paramSn;

    public MainBurger01NoticeFgDetailFg(Context context, FragmentManager manager, int paramSn) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
        this.paramSn = paramSn;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_main_burger01_notice_fg_detail_fg, container, false);

        notice_detail_title = v.findViewById(R.id.notice_detail_title);
        notice_detail_content = v.findViewById(R.id.notice_detail_content);
        notice_detail_writedate = v.findViewById(R.id.notice_detail_writedate);

vo = detail(paramSn);

notice_detail_title.setText(vo.getBoard_title());
        notice_detail_content.setText(vo.getBoard_content());
        notice_detail_writedate.setText(vo.getBoard_date_create()+"");






        return v;

    }
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public NoticeVO detail(int paramSn) {
        commonAsk = new CommonAsk("android/cmh/board.detail.notice");
        commonAsk.params.add(new CommonAskParam("paramSn", paramSn+""));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            vo = gson.fromJson(new InputStreamReader(in), NoticeVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}