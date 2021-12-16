package com.example.project3_allview.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project3_allview.R;
import com.example.project3_allview.adapter.GridAdapter;
import com.example.project3_allview.dto.GridDTO;

import java.util.ArrayList;


public class Frag_GridView extends Fragment {
    //activity = onCreate();
    //Fragment = onCreateView();
    //getActivy <- 현재 액티비티를 받와서 그리고 나서 Context.
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag_grid
                , container
                , false);
        //rootView로 부터 widget(Control)들을 찾는다.
        ArrayList<GridDTO> list = new ArrayList<>();
        GridAdapter adapter = new GridAdapter(getContext(),list);
        gridView = rootView.findViewById(R.id.gridv);
        adapter.addItem(new GridDTO("title1","content1",R.drawable.img1));
        adapter.addItem(new GridDTO("title2","content2",R.drawable.img2));
        adapter.addItem(new GridDTO("title3","content3",R.drawable.img3));
        adapter.addItem(new GridDTO("title4","content4",R.drawable.img1));
        adapter.addItem(new GridDTO("title5","content5",R.drawable.img2));
        adapter.addItem(new GridDTO("title6","content6",R.drawable.img3));
        adapter.addItem(new GridDTO("title7","content7",R.drawable.img1));
        adapter.addItem(new GridDTO("title8","content8",R.drawable.img2));
        adapter.addItem(new GridDTO("title9","content9",R.drawable.img3));
        adapter.addItem(new GridDTO("title10","conten10",R.drawable.img1));
        adapter.addItem(new GridDTO("title11","conten11",R.drawable.img2));
        adapter.addItem(new GridDTO("title12","conten12",R.drawable.img3));
        gridView.setAdapter(adapter);
        return rootView;
    }
}