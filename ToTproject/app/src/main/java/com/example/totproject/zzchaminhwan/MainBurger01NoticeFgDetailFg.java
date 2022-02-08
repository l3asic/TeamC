package com.example.totproject.zzchaminhwan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;

import java.util.Date;


public class MainBurger01NoticeFgDetailFg extends Fragment {
TextView notice_detail_title,notice_detail_content;
Date notice_detail_writedate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_main_burger01_notice_fg_detail_fg, container, false);




        return v;

    }
}