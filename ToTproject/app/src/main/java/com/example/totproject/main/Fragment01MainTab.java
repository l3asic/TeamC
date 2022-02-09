package com.example.totproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;


public class Fragment01MainTab extends Fragment {

/*mRecyclerView.setLayoutManager(new LinearLayoutManager(this));	// 세로

mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));	// 가로*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag_hometab, container, false);



        return view;
    }
}