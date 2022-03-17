package com.example.totproject.login;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.totproject.R;

public class TendencyMainFrag extends Fragment {
    ImageView imgv_tendencyymain ;
    LinearLayout linear_tendency ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tendency_main, container, false);

        imgv_tendencyymain = rootView.findViewById(R.id.imgv_tendencyymain);
        linear_tendency = rootView.findViewById(R.id.linear_tendency);
        linear_tendency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(1);
            }
        });
        Glide.with(getContext()).load(R.drawable.tendency_image).into(imgv_tendencyymain);
        return rootView;
    }

    void changeFragment(int frag){
        TendencyActivity activity = (TendencyActivity) getActivity();
        activity.changeFragment(1);
    }

}