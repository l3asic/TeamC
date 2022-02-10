package com.example.totproject.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.totproject.R;
import com.example.totproject.category.CategoryMainActivity;
import com.example.totproject.category.Fragment02CategoryGridView;
import com.example.totproject.common.Common;


public class Fragment02CategoryTab extends Fragment {
Button category_btn_tour, category_btn_activity, category_btn_festival;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup)
                inflater.inflate(R.layout.main_frag_categorytab , container , false);

        category_btn_tour =  rootView.findViewById(R.id.category_btn_tour);
        category_btn_activity = rootView.findViewById(R.id.category_btn_activity);
        category_btn_festival = rootView.findViewById(R.id.category_btn_festival);

        category_btn_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment02CategoryGridView categoryGridView = new Fragment02CategoryGridView();
                //getFragmentManager().beginTransaction().replace(R.id.container, categoryGridView).commit();
                cateTab(1,category_btn_tour.getText().toString());

            }
        });

        category_btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent activity = new Intent(getActivity(), CategoryMainActivity.class);
                //startActivity(activity);
                cateTab(2,category_btn_activity.getText().toString());
            }
        });

        category_btn_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().replace(R.id.container, categoryGridView).commit();
                // /* tour랑 같은 레이아웃 구성이어서 java코드에서 소스 수정하기 */
                cateTab(3,category_btn_festival.getText().toString());
            }
        });

        return rootView;

    }//onCreateView();


    public void cateTab(int tabcode,String tabText){

        /*SharedPreferences pref = getActivity().getSharedPreferences("Fragnebt02Tab", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("tabText", tabText);
        editor.apply();*/

        Intent intent = new Intent(getActivity(), CategoryMainActivity.class);
        intent.putExtra("tabcode",tabcode);
        intent.putExtra("tabText",tabText);

        startActivity(intent);

    }
    //Fragment02CategoryGridView categoryGridView = new Fragment02CategoryGridView();


}