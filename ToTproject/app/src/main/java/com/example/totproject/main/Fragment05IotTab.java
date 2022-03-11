package com.example.totproject.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.totproject.R;
import com.example.totproject.iot.IotMainActivity;


public class Fragment05IotTab extends Fragment {

    Button btn_iot;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag_iot_tab, container, false);

        btn_iot = view.findViewById(R.id.btn_iot);

        btn_iot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), IotMainActivity.class);
                startActivity(intent);

            }
        });




        return view;
    }
}