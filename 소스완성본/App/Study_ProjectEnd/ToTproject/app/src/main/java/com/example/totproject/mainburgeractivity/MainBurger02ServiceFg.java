package com.example.totproject.mainburgeractivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.totproject.R;

public class MainBurger02ServiceFg extends Fragment {


    LinearLayout service1,service2, service3, service4;
    Context context;
    FragmentManager manager;
    String whatCase;
    ImageView imgv_serviceymain;
    public MainBurger02ServiceFg(Context context, FragmentManager manager) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.mainburger02_service_fg, container, false);
        imgv_serviceymain = v.findViewById(R.id.imgv_servicemain);
        Glide.with(getContext()).load(R.drawable.service_image).into(imgv_serviceymain);
        imgv_serviceymain.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        service1 = v.findViewById(R.id.linear_service1);
        service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testToast();
                changeFragment(new MainBurger02ServiceFg01QnAFg(context,manager));
            }
        });
        service2 = v.findViewById(R.id.linear_service2);
        service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testToast();
                whatCase = "OneOne";
                changeFragment(new MainBurger02ServiceFg0203OneOneEmailFg(context,manager,whatCase));
            }
        });
        service3 = v.findViewById(R.id.linear_service3);
        service3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testToast();
                whatCase = "Email";
                changeFragment(new MainBurger02ServiceFg0203OneOneEmailFg(context,manager,whatCase));
            }
        });

        service4 = v.findViewById(R.id.linear_service4);
        service4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testToast();
                changeFragment(new MainBurger02ServiceFg04TelFg());
            }
        });


        return v;

    }

    int i = 1;

    public void testToast() {
        //Toast.makeText(context, "눌림" + i, Toast.LENGTH_SHORT).show();
        i++;
    }

    public void changeFragment(Fragment fragment) {
        manager.beginTransaction().replace(R.id.mainburger_container, fragment).addToBackStack(null).commit();
    }

}