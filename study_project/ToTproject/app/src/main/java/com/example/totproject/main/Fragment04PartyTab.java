package com.example.totproject.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.totproject.R;
import com.example.totproject.party.PartyCreateActivity;
import com.example.totproject.party.PartyMainActivity;


public class Fragment04PartyTab extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_frag_partytab, container, false);

        TextView tv_open_party_list = view.findViewById(R.id.tv_open_party_list);
        TextView tv_create_party = view.findViewById(R.id.tv_create_party);
        TextView tv_my_party_list = view.findViewById(R.id.tv_my_party_list);



        tv_open_party_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_partytab(1);
            }
        });


        tv_create_party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_partytab(2);
            }
        });

        tv_my_party_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_partytab(3);
            }

        });



 



        return view;
    }


    public void click_partytab(int tabcode){
        Intent intent = new Intent(getActivity(), PartyMainActivity.class);
        intent.putExtra("tabcode",tabcode);
        startActivity(intent);

    }










}//Fragment04PartyTab