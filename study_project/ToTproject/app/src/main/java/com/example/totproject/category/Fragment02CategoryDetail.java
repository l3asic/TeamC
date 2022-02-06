package com.example.totproject.category;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;


public class Fragment02CategoryDetail extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup)
                inflater.inflate(R.layout.category_frag_detail , container , false);

        ArrayList<DetailDTO> list = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            DetailDTO dto = new DetailDTO();
            dto.setReply_sn(i);
            dto.setReply_content("댓글" + i + i + i + i + i);

            list.add(dto);
        }
        RecAdapter adapter = new RecAdapter(getContext(),list);
        recyclerView = rootView.findViewById(R.id.category_detail_recview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("sn", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String sn, @NonNull Bundle bundle) {
                String result = bundle.getString("sn");

                Log.d("asdfg", result);
            }
        });
    }
}