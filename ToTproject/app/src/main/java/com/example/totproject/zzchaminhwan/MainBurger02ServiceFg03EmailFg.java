package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.totproject.R;

public class MainBurger02ServiceFg03EmailFg extends Fragment implements OnBackPressedDispatcherOwner {

    EditText name, email, tel, title, content, password;
    Button cancel, submit;


    Context context;
    FragmentManager manager;
    public MainBurger02ServiceFg03EmailFg(Context context, FragmentManager manager) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_main_burger02_service_fg_03_email, container, false);

        name = v.findViewById(R.id.main_burger_service_email_edt_name);
        email = v.findViewById(R.id.main_burger_service_email_edt_email);
        tel = v.findViewById(R.id.main_burger_service_email_edt_tel);
        title = v.findViewById(R.id.main_burger_service_email_edt_title);
        content = v.findViewById(R.id.main_burger_service_email_edt_content);
        password = v.findViewById(R.id.main_burger_service_email_edt_password);

        cancel = v.findViewById(R.id.main_burger_service_email_btn_cancel);
        submit = v.findViewById(R.id.main_burger_service_email_btn_submit);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher();
            }
        });

        return v;

    }


    @NonNull
    @Override
    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return null;
    }
}