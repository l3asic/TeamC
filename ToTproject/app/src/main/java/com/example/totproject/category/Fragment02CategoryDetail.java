package com.example.totproject.category;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Fragment02CategoryDetail extends Fragment {
    RecyclerView recyclerView;
    TextView category_detail_tv_reply;
    String result;
   // ArrayList<CategoryVO> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup)
                inflater.inflate(R.layout.category_frag_detail , container , false);

        if(getArguments() != null){
            result = getArguments().getString("sn"); //값을 받아옴
        }

        category_detail_tv_reply = rootView.findViewById(R.id.category_detail_tv_reply);

        category_detail_tv_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CategoryReplyActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<BoardCommonVO> list = new ArrayList<>();

        for(int i=0; i < list.size(); i++) {
            BoardCommonVO vo = new BoardCommonVO();
              vo.setBoard_content(list.get(i).getBoard_content());


            list.add(vo);
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

    CommonAsk commonAsk;
    Gson gson = new Gson();

    public BoardCommonVO detail(int paramSn) {
        commonAsk = new CommonAsk("android/cmh/board_detail@review");
        commonAsk.params.add(new CommonAskParam("paramSn", paramSn+""));
        BoardCommonVO vo = new BoardCommonVO();
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            vo = gson.fromJson(new InputStreamReader(in), BoardCommonVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }


    //CategoryVO vo = new CategoryVO();

    /*public CategoryVO reply_insert() {
        CategoryVO requestVO = new CategoryVO();
        CategoryVO responseVO = null;

        String category_reply_edt_text = category_reply_edt.getText().toString();
        requestVO.setBoard_content(category_reply_edt_text);
        requestVO.setPicture_file_count(replyAdapter.getItemCount());
        requestVO.setBoard_title("title");
        requestVO.setBoard_class("category");
        requestVO.setMember_id("1111");
        commonAsk = new CommonAsk("category_reply");

        commonAsk.params.add(new CommonAskParam("category", gson.toJson(requestVO)));
        for (int i = 0; i < replyAdapter.getItemCount();i ++ ){
            commonAsk.fileParams.add(new CommonAskParam("file"+i, replyAdapter.getList().get(i)));
        }

        //파일은 안주므로 주석  commonAsk.fileParams.add(new CommonAskParam("file", img_filepath));
        InputStream in =  CommonMethod.excuteAsk(commonAsk);

        String result = gson.fromJson(new InputStreamReader(in) , String.class);
        try {
            responseVO = gson.fromJson(new InputStreamReader(in), new TypeToken<List<CategoryVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseVO;
    }*/


}