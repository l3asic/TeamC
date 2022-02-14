package com.example.totproject.category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.VO.PictureVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//고장나면 02.11 오후 4:13분꺼 보면 됨

public class Fragment02CategoryDetail extends Fragment {
    RecyclerView recyclerView;
    ViewPager2 pager2;
    TextView category_detail_tv_reply;
    TextView category_detail_tv_content;    // 추가
    TextView category_detail_like_count;    // 추가
    ImageView like_ico;
    int boardSN=-1;      // 추가
    BoardCommonVO vo = new BoardCommonVO();
 //   Context dCOmtext;

    ArrayList<BoardCommonVO> list = new ArrayList<>();

    public Fragment02CategoryDetail( ) {
    }
    public Fragment02CategoryDetail(int paramSn) {
        this.boardSN=paramSn;
    }


    //    Context context; ;FragmentManager manager; int getParamSn;
//    public Fragment02CategoryDetail(Context context, FragmentManager manager, int getParamSn) { //컨텍슽르르 메인에서부터 가져옴
//        this.context = context;
//        this.manager = manager;
 //       this.getParamSn = getParamSn;
 //   }
   /* @Override
    public void onAttach(Context context){
        super.onAttach(context);
        dCOmtext = context;
    }
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup)
                inflater.inflate(R.layout.category_frag_detail , container , false);

        pager2 = rootView.findViewById(R.id.category_detail_pager);
        like_ico = rootView.findViewById(R.id.like_ico);
        category_detail_like_count = rootView.findViewById(R.id.category_detail_like_count);

        // 추가
        category_detail_tv_content = rootView.findViewById(R.id.category_detail_tv_content);

        category_detail_tv_content.setText(vo.getBoard_content());  //추가끝

        category_detail_tv_reply = rootView.findViewById(R.id.category_detail_tv_reply);

        category_detail_tv_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CategoryReplyActivity.class);
                intent.putExtra("sn",boardSN);
                startActivity(intent);
            }
        });

        like_ico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLike();
            }
        });



        recyclerView = rootView.findViewById(R.id.category_detail_recview);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        getReplyList();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("sn", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String sn, @NonNull Bundle bundle) {
                if(boardSN==0){
                boardSN = bundle.getInt("sn");}

                detail();
                contentPictureList();
                getLikeCount();
                getReplyList();


            }
        });

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
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public void detail() {
        BoardCommonVO pvo = new BoardCommonVO();
        pvo.setBoard_sn(boardSN);
        pvo.setMember_id("1111");
        commonAsk = new CommonAsk("detail_categoryBoard");
        commonAsk.params.add(new CommonAskParam("category", gson.toJson(pvo)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            this.vo = gson.fromJson(new InputStreamReader(in), BoardCommonVO.class);
            category_detail_tv_content.setText(vo.getBoard_content());
            seLikeIcon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contentPictureList() {
        commonAsk = new CommonAsk("list_picture");
        commonAsk.params.add(new CommonAskParam("board_sn", String.valueOf(boardSN)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            ArrayList<PictureVO> getList = gson.fromJson(new InputStreamReader(in), new TypeToken<List<PictureVO>>(){}.getType());
            PagerAdapter adapter2 = new PagerAdapter(getActivity(),getList);
            pager2.setAdapter(adapter2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLikeCount(){
        commonAsk = new CommonAsk("category_like");
        commonAsk.params.add(new CommonAskParam("board_sn", String.valueOf(boardSN)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        String result = getStringFromInputStream(in);

        try {
            category_detail_like_count.setText(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLike(){

        BoardCommonVO pvo = new BoardCommonVO();
        pvo.setBoard_sn(boardSN);
        pvo.setFunction_like(vo.getFunction_like());
        pvo.setMember_id("1111");

        commonAsk = new CommonAsk("set_like");
        commonAsk.params.add(new CommonAskParam("category", gson.toJson(pvo)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        String result = getStringFromInputStream(in);

        if(vo.getFunction_like() > 0){
            vo.setFunction_like(0);
        }else{
            vo.setFunction_like(1);
        }

        seLikeIcon();
    }

    public void getReplyList(){
        commonAsk = new CommonAsk("list_reviewpath");
        commonAsk.params.add(new CommonAskParam("board_sn", String.valueOf(boardSN)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        ArrayList<BoardCommonVO> getList = gson.fromJson(new InputStreamReader(in), new TypeToken<List<BoardCommonVO>>(){}.getType());

        try {
            RecAdapter adapter = new RecAdapter(getContext(),getList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void seLikeIcon(){
        if(vo.getFunction_like() > 0){
            Glide.with(getContext()).load(R.drawable.like).into(like_ico);
        }else{
            Glide.with(getContext()).load(R.drawable.like_gray).into(like_ico);
        }
        getLikeCount();
    }

    private String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

}