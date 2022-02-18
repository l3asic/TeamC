package com.example.totproject.party_plan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;


public class PlanListFragment extends Fragment {
    RecyclerView planlist_item;
    Context context;

    public PlanListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partyplan_frag_planlist, container, false);

        planlist_item = view.findViewById(R.id.planlist_item);
        ArrayList<PlanlistDTO> list = new ArrayList<>();

        //@@@@@@@@@@@@ 안드 더미데이터 넣기  ~
        for (int i=0; i<10;i++){
            list.add(new PlanlistDTO(001+i,
                    R.drawable.ic_launcher_foreground,
                    0+i,
                    "제주도여행계획"+i,
                    "작성자준호",
                    "2022/02/08",
                    "2022/02/10",
                    "제주도 서귀포",
                    "농성역",
                    "제주호텔A",
                    "300000",
                    "juno",
                    "09:00",
                    "19:00"
                    )
            );
        }
        // ~ @@@@@@@@@@@@ 안드 더미데이터 넣기

        PlanListAdapter planListAdapter = new PlanListAdapter(context,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                context , RecyclerView.VERTICAL , false
        );

        planlist_item.setLayoutManager(layoutManager);
        planlist_item.setAdapter(planListAdapter);





        return view;
    }
}