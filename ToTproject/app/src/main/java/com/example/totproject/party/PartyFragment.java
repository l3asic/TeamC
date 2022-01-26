package com.example.totproject.party;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.totproject.MainActivity;
import com.example.totproject.R;


public class PartyFragment extends Fragment {

    TextView tv_open_party_list;

   // Context context;

  /* public PartyFragment(Context context) {
        this.context = context;// 이게 메인액티비티 가서 보면 넘겨주거든요 ㄱㄱ 어뭐지...어딧더라..
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup main_container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_04_party_main, main_container, false);

        tv_open_party_list = view.findViewById(R.id.tv_open_party_list);

        tv_open_party_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 잠시 제꺼 카카오스토리좀보고옴
               Intent intent = new Intent(getActivity(), PartyMainActivity.class );
               intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
               startActivity(intent);


               //startActivity(intent);

            }
        });



        return view;
    }
}