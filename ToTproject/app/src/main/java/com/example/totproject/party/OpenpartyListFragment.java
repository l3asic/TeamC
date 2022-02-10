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


public class OpenpartyListFragment extends Fragment {
    RecyclerView openpartylist_item;
    Context context;

    public OpenpartyListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.party_frag_openpartylist, container, false);

        openpartylist_item = view.findViewById(R.id.openpartylist_item);
        ArrayList<PartyListDTO> list = new ArrayList<>();

        //@@@@@@@@@@@@ 안드 더미데이터 넣기  ~
        for (int i=0; i<10;i++){
            list.add(new PartyListDTO(R.drawable.ic_launcher_background,
                    "partySN01"+i,
                    "n",
                    "파티리더명",
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

        openpartylist_item.setLayoutManager(layoutManager);
        openpartylist_item.setAdapter(partyListAdapter);







        return view;
    }
}