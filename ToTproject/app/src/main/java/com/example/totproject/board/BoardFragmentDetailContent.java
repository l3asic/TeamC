package com.example.totproject.board;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totproject.R;


public class BoardFragmentDetailContent extends Fragment {
    public BoardFragmentDetailContent() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.board_fg_detail_content, container, false);
    }
}