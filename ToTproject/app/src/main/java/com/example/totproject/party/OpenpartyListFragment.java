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
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class OpenpartyListFragment extends Fragment {
    RecyclerView openpartylist_item;
    Context context;
    ArrayList<PartyListDTO> list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public OpenpartyListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.party_frag_openpartylist, container, false);

        openpartylist_item = view.findViewById(R.id.openpartylist_item);




        showOpenPartylist();



        PartyListAdapter partyListAdapter = new PartyListAdapter(context,list,1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                context , RecyclerView.VERTICAL , false
        );

        openpartylist_item.setLayoutManager(layoutManager);
        openpartylist_item.setAdapter(partyListAdapter);







        return view;
    }//onCreateView()


    private ArrayList<PartyListDTO> showOpenPartylist() {
        commonAsk = new CommonAsk("android/party/openpartylist");
        //commonAsk.params.add(new CommonAskParam("party_private",gson.toJson(party_private)));        //@@@@@@ 아이디 => 멤버 아이디로해줄것
        //commonAsk.params.add(new CommonAskParam("party_private", party_private ));        //@@@@@@ 아이디 => 멤버 아이디로해줄것
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyListDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }//showOpenPartylist()
}