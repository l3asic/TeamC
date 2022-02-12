package com.example.totproject.party;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class SearchPartyFragment extends Fragment {
    String SearchKeyword;
    ArrayList<PartyListDTO> list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public SearchPartyFragment(String searchKeyword) {
        SearchKeyword = searchKeyword;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.party_frag_search, container, false);


        검색화면 하는중




        return view;
    }


    private ArrayList<PartyListDTO> searchOpenPartylist() {
        commonAsk = new CommonAsk("android/party/searchopenpartylist");
        //commonAsk.params.add(new CommonAskParam("party_private",gson.toJson(party_private)));
        //commonAsk.params.add(new CommonAskParam("party_private", party_private ));        //@@@@@@ 아이디 => 멤버 아이디로해줄것
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyListDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }//searchOpenPartylist()



}