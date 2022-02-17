package com.example.totproject.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.main.Adapter.BoardTabAdapter;
import com.example.totproject.main.Adapter.ReplyAdapter;
import com.example.totproject.main.VO.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment03BoardTab_Detail extends Fragment {

    TextView category_detail_tv_board_title, category_detail_tv_board_content, board_user_detail_tv_replycnt;

    RecyclerView Board_User_Reply_RcView;
    BoardCommonVO vo = new BoardCommonVO();
    ReplyVO replyVO = new ReplyVO();
    List<ReplyVO> list = new ArrayList<>();


    Context context;
    FragmentManager manager;
    int paramSn;

    public Fragment03BoardTab_Detail(Context context, FragmentManager manager, int paramSn) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
        this.paramSn = paramSn;
    }

    /* ==================================== * from tbl_board ===================================== */
    public Fragment03BoardTab_Detail(Context context, FragmentManager manager, BoardCommonVO vo) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
        this.vo = vo;
    }
    /* =========================================================================================== */

    /* =========================================================================================== */

    public Fragment03BoardTab_Detail(Context context, FragmentManager manager, ReplyVO replyVO) {
        this.context = context;
        this.manager = manager;
        this.replyVO = replyVO;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.boardtab_frag_detail, container, false);
        /* ================================= board_content 세팅 ========================================= */
        category_detail_tv_board_title = v.findViewById(R.id.category_detail_tv_board_title);
        category_detail_tv_board_content = v.findViewById(R.id.category_detail_tv_board_content);
        board_user_detail_tv_replycnt = v.findViewById(R.id.board_user_detail_tv_replycnt);

        category_detail_tv_board_title.setText(vo.getBoard_title() + "");
        category_detail_tv_board_content.setText(vo.getBoard_content() + "");
        board_user_detail_tv_replycnt.setText(vo.getBoard_cnt_reply() + "");
        /* ===================================== DB댓글조회 및 어댑터 ============================== */
        selectReply(vo.getBoard_sn());
        Board_User_Reply_RcView = v.findViewById(R.id.board_useR_detail_recycler_detail);

        LinearLayoutManager lmanager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false);
        ReplyAdapter adapter = new ReplyAdapter(context, list, manager);

        Board_User_Reply_RcView.setLayoutManager(lmanager);
        Board_User_Reply_RcView.setAdapter(adapter);
        /* ====================================================================================== */


        /* ====================================================================================== */


        return v;

    }//onCreateView

    /* ===================================== db조회ㅜ============================================ */
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public  List<ReplyVO> selectReply(int board_sn) {
        commonAsk = new CommonAsk("android/cmh/reply_select/");
        commonAsk.params.add(new CommonAskParam("paramSn", vo.getBoard_sn() + ""));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<ReplyVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /* ========================================================================================= */

}