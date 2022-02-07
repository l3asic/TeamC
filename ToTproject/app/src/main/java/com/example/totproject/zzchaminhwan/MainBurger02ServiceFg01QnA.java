package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.totproject.R;

public class MainBurger02ServiceFg01QnA extends Fragment {
    /*        a01.setVisibility(View.GONE);          // view 삭제
        a01.setVisibility(View.INVISIBLE);   // view 그대로 숨기기
        a01.setVisibility(View.VISIBLE);      // view 보이기*/

    TextView q01, q02, q03;
    LinearLayout a01, a02, a03;
    Button btn01, btn02, btn03;
    int isBtn01 = 0;
    int isBtn02 = 0;
    int isBtn03 = 0;

    Context context;
    FragmentManager manager;

    public MainBurger02ServiceFg01QnA(Context context, FragmentManager manager) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_main_burger02_service_fg_01_qna, container, false);

        q01 = v.findViewById(R.id.qna_tv_q01);
        a01 = v.findViewById(R.id.qna_tv_a01);
        a01.setVisibility(View.GONE);          // view 삭제
        btn01 = v.findViewById(R.id.qna_btn_01);

        q02 = v.findViewById(R.id.qna_tv_q02);
        a02 = v.findViewById(R.id.qna_tv_a02);
        a02.setVisibility(View.GONE);          // view 삭제
        btn02 = v.findViewById(R.id.qna_btn_02);

        q03 = v.findViewById(R.id.qna_tv_q03);
        a03 = v.findViewById(R.id.qna_tv_a03);
        a03.setVisibility(View.GONE);          // view 삭제
        btn03 = v.findViewById(R.id.qna_btn_03);



        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBtn01 == 1) {

                    a01.setVisibility(View.GONE);          // view 삭제
                    isBtn01 = 0;
                } else {
                    a01.setVisibility(View.VISIBLE);      // view 보이기
                    isBtn01 = 1;
                }


            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBtn02 == 1) {

                    a02.setVisibility(View.GONE);          // view 삭제
                    isBtn02 = 0;
                } else {
                    a02.setVisibility(View.VISIBLE);      // view 보이기
                    isBtn02 = 1;
                }


            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBtn03 == 1) {
                    a03.setVisibility(View.GONE);          // view 삭제
                    isBtn03 = 0;
                } else {
                    a03.setVisibility(View.VISIBLE);      // view 보이기
                    isBtn03 = 1;
                }


            }
        });


        return v;

    }

    int i = 1;

    public void testToast() {
        Toast.makeText(context, "눌림" + i, Toast.LENGTH_SHORT).show();
        i++;
    }
}