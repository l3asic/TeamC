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
import com.example.totproject.common.MemberDTO;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MypartyListFragment extends Fragment {
    RecyclerView mypartylist_item;
    Context context;
    ArrayList<PartyListDTO> list = new ArrayList<>();
    CommonAsk commonAsk;
    Gson gson = new Gson();



    public MypartyListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.party_frag_mypartylist, container, false);

        mypartylist_item = view.findViewById(R.id.mypartylist_item);


        // @@@@@@@@ 멤버 DTO 임의 세팅 수정할것@@@@@@@@@
        MemberDTO memberDTO = new MemberDTO("a01","1234","준호","01012341234");   //저아디 하나 가져갈려고 하는거긴한데 일단 DTO 보내는거
        // @@@@@@@@ 멤버 DTO 임의 세팅 수정할것@@@@@@@@@

        showMyPartylist(memberDTO);




        PartyListAdapter partyListAdapter = new PartyListAdapter(context,list,3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                context , RecyclerView.VERTICAL , false
        );

        mypartylist_item.setLayoutManager(layoutManager);
        mypartylist_item.setAdapter(partyListAdapter);




        return view;
    }//onCreateView()


    public ArrayList<PartyListDTO> showMyPartylist(MemberDTO memberDTO){
        commonAsk = new CommonAsk("android/party/mypartylist");
        commonAsk.params.add(new CommonAskParam("memberDTO",gson.toJson(memberDTO)));        //@@@@@@ 아이디 => 멤버 아이디로해줄것
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PartyListDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }//showMyPartylist()















}