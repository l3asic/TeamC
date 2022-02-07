package com.example.totproject.party;

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


public class MypartyListFragment extends Fragment {
    RecyclerView mypartylist_item;
    Context context;

    public MypartyListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.party_frag_mypartylist, container, false);

        mypartylist_item = view.findViewById(R.id.mypartylist_item);
        ArrayList<PartyListDTO> list = new ArrayList<>();

        //@@@@@@@@@@@@ 안드 더미데이터 넣기  ~
        for (int i=0; i<10;i++){
            list.add(new PartyListDTO(R.drawable.ic_launcher_background,
                            "partySN01",
                            "n",
                            "partyname01",
                            "파티 설명입니다  블라블라",
                    "#partyhashtag1",
                    "#partyhashtag2",
                    "#partyhashtag3"

                    )
            );
        }


        // ~ @@@@@@@@@@@@ 안드 더미데이터 넣기

        PartyListAdapter partyListAdapter = new PartyListAdapter(context,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                context , RecyclerView.VERTICAL , false
        );

        mypartylist_item.setLayoutManager(layoutManager);
        mypartylist_item.setAdapter(partyListAdapter);









        return view;
    }
}