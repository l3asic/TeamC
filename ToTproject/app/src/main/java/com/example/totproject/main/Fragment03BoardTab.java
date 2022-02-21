package com.example.totproject.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.WhosePage00Activity;
import com.example.totproject.board.zzz_Board00Activity;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.ChangeView;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.Adapter.BoardTabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fragment03BoardTab extends Fragment {

    private FloatingActionButton boardtab_fab_main, boardtab_fab_mypage, boardtab_fab_write, boardtab_fab_search;
    private Animation fab_open, fab_close, rotate_clockwise, rotate_anticlockwise;
    private Boolean isFabOpen = false;
    private Object FragmentBoardSearch;
    List<BoardCommonVO> list = new ArrayList<>();
    BoardCommonVO vo = new BoardCommonVO();
    RecyclerView Board_User_RcView;
    MemberDTO memberDTO = new MemberDTO();
    Context context;
    FragmentManager manager;
    TextView whosepage_tv_member_id;

    public Fragment03BoardTab(Context context, FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }

    String isCase;

    public Fragment03BoardTab(Context context, FragmentManager manager, String isCase) {
        this.context = context;
        this.manager = manager;
        this.isCase = isCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.main_frag_boardtab, container, false);



        /* ====================================================================================== */
        vo.setBoard_class("notice");
        vo.setList_cnt_many(999);
        /* ====================================================================================== */
        if (isCase == null) {
            list = selectBoardList(vo);
        } else if (isCase.equals("whosePage_write")) {
            memberDTO.setMember_id(Logined.member_id);
            list = whoseList(memberDTO, isCase); //whosePage 재활용
            WhosePage00Activity whosePage00Activity = new WhosePage00Activity(memberDTO,list);
        }


        Board_User_RcView = v.findViewById(R.id.boardtab_list_recycler);

        LinearLayoutManager lmanager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false);
        BoardTabAdapter adapter = new BoardTabAdapter(context, list, manager);

        Board_User_RcView.setLayoutManager(lmanager);
        Board_User_RcView.setAdapter(adapter);
        /* ====================================================================================== */


        if (isCase == null) {  // 재사용할려고 if()만듬
            /* ===================================== fab 버튼 ============================================ */
            boardtab_fab_search = v.findViewById(R.id.boardtab_fab_search);
            boardtab_fab_write = v.findViewById(R.id.boardtab_fab_write);
            boardtab_fab_mypage = v.findViewById(R.id.boardtab_fab_mypage);
            boardtab_fab_main = v.findViewById(R.id.boardtab_fab_main);
            boardtab_fab_search.setVisibility(View.VISIBLE);
            boardtab_fab_write.setVisibility(View.VISIBLE);
            boardtab_fab_mypage.setVisibility(View.VISIBLE);
            boardtab_fab_main.setVisibility(View.VISIBLE);

            fab_open = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_open);
            fab_close = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_close);

            boardtab_fab_write.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "팹 1", Toast.LENGTH_SHORT).show();
                    ChangeView.changeActivity(getActivity(), zzz_Board00Activity.class, "tabText", "write");
                }
            });
            boardtab_fab_search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "팹 2", Toast.LENGTH_SHORT).show();
                    ChangeView.changeActivity(getActivity(), zzz_Board00Activity.class, "tabText", "search");
                }
            });
            boardtab_fab_mypage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "팹 3", Toast.LENGTH_SHORT).show();
                    ChangeView.changeActivity(getActivity(), WhosePage00Activity.class, "whereFrom", "BoardTab");
                }
            });



            /* ============================ + 버튼ㄴ ====================================== */
            boardtab_fab_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isFabOpen) {
                        showfabMenu();
                    } else {
                        closefabMenu();
                    }
                }
            });
        }
        /* ========================================================================================= */

        return v;
    }//oncreate()

    /* ========================================메소드============================================ */


    /* ===================================== fab 버튼 ============================================ */
    private void showfabMenu() {
        isFabOpen = true;
        boardtab_fab_mypage.animate().translationY(-getResources().getDimension(R.dimen.up_1state));
        boardtab_fab_search.animate().translationY(-getResources().getDimension(R.dimen.up_2state));
        boardtab_fab_write.animate().translationY(-getResources().getDimension(R.dimen.up_3state));

    }

    private void closefabMenu() {
        isFabOpen = false;
        boardtab_fab_mypage.animate().translationY(0);
        boardtab_fab_search.animate().translationY(0);
        boardtab_fab_write.animate().translationY(0);

    }

    /* ===================================== db조회ㅜ============================================ */
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public List<BoardCommonVO> selectBoardList(BoardCommonVO vo) {
        commonAsk = new CommonAsk("android/cmh/board_list");
        commonAsk.params.add(new CommonAskParam("vo", gson.toJson(vo)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<BoardCommonVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<BoardCommonVO> whoseList(MemberDTO memberDTO, String isCase) {
        list = new ArrayList<>();
        commonAsk = new CommonAsk("android/cmh/" + isCase + "/");
        commonAsk.params.add(new CommonAskParam("vo", gson.toJson(memberDTO)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<BoardCommonVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /* ========================================================================================= */
}