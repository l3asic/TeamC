package com.example.totproject.party_plan;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;

import java.util.ArrayList;


public class PlanInfo02Fragment extends Fragment {

    ExpandableListView expdListView;

    Context context;

    public PlanInfo02Fragment(Context context) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partyplan_frag_planinfo02, container, false);

        ArrayList<PlanInfoDTO> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            PlanInfoDTO dto = new PlanInfoDTO("Day01", "0910", 0101, "호텔 체크인", "짐풀러 체크인 기타메모입니다기타메모입니다기타메모입니다기타메모입니다기타메모입니다 ");
            ArrayList subList = new ArrayList();

            for (int j = 0; j < 5; j++) {
                subList.add(" 계획 계획 ");
            }
            dto.setSubList(subList);

            list.add(dto);
        }

        expdListView = view.findViewById(R.id.expdListView);

        // @@@@ 어댑터 완성후 여기 마무리 할것
        PlanInfoAdapter adapter = new PlanInfoAdapter(getActivity(),(LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE), list);
        expdListView.setAdapter(adapter);


        return view;
    }
}