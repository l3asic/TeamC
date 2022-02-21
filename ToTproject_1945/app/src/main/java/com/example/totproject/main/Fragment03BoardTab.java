package com.example.totproject.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.board.Activity03BoardDetail;
import com.example.totproject.board.BoardNewActivity;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.main.Adapter.BoardTabAdapter;
import com.example.totproject.zzchaminhwan.Adapter.NoticeAdapter;
import com.example.totproject.zzchaminhwan.MainBurger00Activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fragment03BoardTab extends Fragment {

    private FloatingActionButton boardtab_fab_main, boardtab_fab_mylist, boardtab_fab_write, boardtab_fab_search;
    private Animation fab_open, fab_close, rotate_clockwise, rotate_anticlockwise;
    private Boolean isFabOpen = false;
    private Object FragmentBoardSearch;
    List<BoardCommonVO> list = new ArrayList<>();
    BoardCommonVO vo = new BoardCommonVO();
    RecyclerView Board_User_RcView;

    Context context;
    FragmentManager manager;

    public Fragment03BoardTab(MainActivity mainActivity, FragmentManager manager) {
        this.context = mainActivity;
        this.manager = manager;
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
        selectBoardList(vo);
        Board_User_RcView = v.findViewById(R.id.boardtab_list_recycler);

        LinearLayoutManager lmanager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false);
        BoardTabAdapter adapter = new BoardTabAdapter(context, list, manager);

        Board_User_RcView.setLayoutManager(lmanager);
        Board_User_RcView.setAdapter(adapter);
        /* ====================================================================================== */


        /* ===================================== fab 버튼 ============================================ */
        boardtab_fab_main = v.findViewById(R.id.boardtab_fab_main);
        boardtab_fab_mylist = v.findViewById(R.id.boardtab_fab_mylist);
        boardtab_fab_write = v.findViewById(R.id.boardtab_fab_write);
        boardtab_fab_search = v.findViewById(R.id.boardtab_fab_search);

        fab_open = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_close);

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
        boardtab_fab_mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "팹 눌림", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Activity03BoardDetail.class);
                startActivity(intent);
            }
        });

        boardtab_fab_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "팹 눌림", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), BoardNewActivity.class);
                startActivity(intent);
            }
        });

        boardtab_fab_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "팹 눌림", Toast.LENGTH_SHORT).show();
                //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //transaction.replace(R.id.board_container, (Fragment) Board_frag_search).commit();
                //    getSupportFragmentManager().beginTransaction().replace(R.id.board_container, (Fragment) FragmentBoardSearch).addToBackStack(null).commit();

            }
        });
        /* ========================================================================================= */

        return v;
    }//oncreate()

    /* ========================================메소드============================================ */
    /* ===================================== fab 버튼 ============================================ */
    private void showfabMenu() {
        isFabOpen = true;
        boardtab_fab_mylist.animate().translationY(-getResources().getDimension(R.dimen.up_1state));
        boardtab_fab_write.animate().translationY(-getResources().getDimension(R.dimen.up_2state));
        boardtab_fab_search.animate().translationY(-getResources().getDimension(R.dimen.up_3state));
    }

    private void closefabMenu() {
        isFabOpen = false;
        boardtab_fab_mylist.animate().translationY(0);
        boardtab_fab_write.animate().translationY(0);
        boardtab_fab_search.animate().translationY(0);
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
    /* ========================================================================================= */
}