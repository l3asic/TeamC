package com.example.totproject.board;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.statics.ChangeView;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.board.Adapter.ReplyAdapter;
import com.example.totproject.board.VO.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Board00DetailFg extends Fragment {

    TextView board_user_detail_tv_replycnt, board_user_detail_tv_like_cnt;
    LinearLayout board_user_detail_linear_update, board_user_detail_linear_delete, board_user_detail_linear_like;
    ImageView board_user_detail_img_reply_submit, board_user_detail_img_like;
    EditText board_user_detail_edt_board_title, board_user_detail_edt_board_content;

    EditText board_user_detail_edt_reply_input;

    int succ;

    RecyclerView Board_User_Reply_RcView;
    BoardCommonVO vo = new BoardCommonVO();
    ReplyVO replyVO = new ReplyVO();
    List<ReplyVO> list = new ArrayList<>();
    int boardSN;

    Context context;
    FragmentManager manager;
    int paramSn;
    String tabText;

    /* ==================================== * from tbl_board ===================================== */
    public Board00DetailFg() {
    }

    public Board00DetailFg(Context context, FragmentManager manager, BoardCommonVO vo) {
        this.context = context;
        this.manager = manager;
        this.vo = vo;
    }

    public Board00DetailFg(Context context, FragmentManager manager, String tabText) {
        this.context = context;
        this.manager = manager;
        this.tabText = tabText;
        vo.setMember_id(Logined.member_id);
        vo.setBoard_class("user");

    }
    /* =========================================================================================== */

    /* =========================================================================================== */


    /*    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.zzz_boardtab_frag_detail);
            Intent getinIntent = new Intent(getIntent());
            vo = (BoardCommonVO) getinIntent.getSerializableExtra("vo");*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_boardtab_frag_detail, container, false);
        String pageMode = null;
        if (tabText == null) {
            pageMode = "detailView";
        } else if (tabText.equals("write")) {
            pageMode = "write";
        }

        board_user_detail_linear_update = v.findViewById(R.id.board_user_detail_linear_update);
        board_user_detail_linear_delete = v.findViewById(R.id.board_user_detail_linear_delete);
        /* ================================= board_detail 기능세팅 ========================================= */
        board_user_detail_linear_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        board_user_detail_linear_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        /* ================================= board_detail 기능세팅 ========================================= */
        board_user_detail_edt_board_title = v.findViewById(R.id.board_user_detail_edt_board_title);
        board_user_detail_edt_board_content = v.findViewById(R.id.board_user_detail_edt_board_content);
        board_user_detail_tv_replycnt = v.findViewById(R.id.board_user_detail_tv_replycnt);


        if (pageMode.equals("detailView")) {
            /* ================================= board_content 세팅 ========================================= */
            board_user_detail_edt_board_title.isEnabled();
            board_user_detail_edt_board_content.isEnabled();

            board_user_detail_edt_board_title.setText(vo.getBoard_title() + "");
            board_user_detail_edt_board_content.setText(vo.getBoard_content() + "");
            board_user_detail_tv_replycnt.setText(vo.getBoard_cnt_reply() + "");
            boardSN = vo.getBoard_sn();
            detail();
            /* ====================================================================================== */

            /* ===================================== DB댓글조회 및 어댑터 ============================== */
            Board_User_Reply_RcView = v.findViewById(R.id.board_useR_detail_recycler_detail);

            selectReplys();
/*            selectReply(boardSN);
            LinearLayoutManager lmanager = new LinearLayoutManager(
                    getActivity(), RecyclerView.VERTICAL, false);
            ReplyAdapter adapter = new ReplyAdapter(getActivity(), list);
            Board_User_Reply_RcView.setLayoutManager(lmanager);
            Board_User_Reply_RcView.setAdapter(adapter);*/

            /* ====================================================================================== */


            /* ===================================== 하단 액션바 ============================== */
            board_user_detail_linear_like = v.findViewById(R.id.board_user_detail_linear_like);//좋아요 구역

            board_user_detail_edt_reply_input = v.findViewById(R.id.board_user_detail_edt_reply_input);//댓글입력


            board_user_detail_img_reply_submit = v.findViewById(R.id.board_user_detail_img_reply_submit);//댓글게시
            board_user_detail_img_reply_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String inputReplyContent = board_user_detail_edt_reply_input.getText() + "";

                    /* == tbl_reply 기입할 정보 set == */
                    replyVO.setReply_content(inputReplyContent);
                    replyVO.setBoard_sn(boardSN);
                    replyVO.setMember_id(Logined.member_id);

                    succ = insertReply(replyVO);
                    if (succ > 0) {
                        Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                        board_user_detail_edt_reply_input.setText("");
                    } else {
                        Toast.makeText(getActivity(), "댓글등록 실패", Toast.LENGTH_SHORT).show();
                    }
                    selectReplys();
                }
            });
            board_user_detail_tv_like_cnt = v.findViewById(R.id.board_user_detail_tv_like_cnt);//좋아요 cnt
            getLikeCount();

            board_user_detail_img_like = v.findViewById(R.id.board_user_detail_img_like);// 좋아요 버튼
            board_user_detail_img_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int likes = Integer.parseInt(board_user_detail_tv_like_cnt.getText() + "");
                    setLike();
                    // tbl_likes 연동
                }
            });
            setLikeIcon();

            /* ====================================================================================== */
        } else if (pageMode.equals("write")) { 
                /*        a01.setVisibility(View.GONE);          // view 삭제
        a01.setVisibility(View.INVISIBLE);   // view 그대로 숨기기
        a01.setVisibility(View.VISIBLE);      // view 보이기*/
            LinearLayout board_user_detail_view_write;
            board_user_detail_view_write = v.findViewById(R.id.board_user_detail_view_write);
            RelativeLayout board_user_detail_view_detail;
            board_user_detail_view_detail = v.findViewById(R.id.board_user_detail_view_detail);
            board_user_detail_view_write.setVisibility(View.INVISIBLE);
            board_user_detail_view_detail.setVisibility(View.GONE);
            Button board_user_detail_btn_cancel, board_user_detail_btn_submit;
            board_user_detail_btn_cancel = v.findViewById(R.id.board_user_detail_btn_cancel);
            board_user_detail_btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "취소눌림", Toast.LENGTH_SHORT).show();
                }
            });
            board_user_detail_btn_submit = v.findViewById(R.id.board_user_detail_btn_submit);
            board_user_detail_btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "확인눌림", Toast.LENGTH_SHORT).show();
                    vo.setBoard_title(board_user_detail_edt_board_title.getText() + "");
                    vo.setBoard_title(board_user_detail_edt_board_content.getText() + "");
                    int succ = board_insert(vo);
                    if (succ > 0) {
                        Toast.makeText(getActivity(), "등록성공", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "등록실패", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
        return v;
    }//onCreateView

    @Override
    public void onResume() {
        super.onResume();
    }

    /* ===================================== db조회============================================ */
    CommonAsk commonAsk;
    Gson gson = new Gson();

    public void detail() {
        BoardCommonVO pvo = new BoardCommonVO();
        pvo.setBoard_sn(boardSN);
        pvo.setMember_id(Logined.member_id);
        commonAsk = new CommonAsk("detail_categoryBoard");
        commonAsk.params.add(new CommonAskParam("category", gson.toJson(pvo)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            this.vo = gson.fromJson(new InputStreamReader(in), BoardCommonVO.class);
            board_user_detail_edt_board_content.setText(vo.getBoard_content() + "");
            setLikeIcon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ReplyVO> selectReply(int board_sn) {
        commonAsk = new CommonAsk("android/cmh/reply_select/");
        commonAsk.params.add(new CommonAskParam("paramSn", board_sn + ""));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            list = gson.fromJson(new InputStreamReader(in), new TypeToken<List<ReplyVO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /* =================================== DB insert========================================== */
    public int board_insert(BoardCommonVO vo) {
        int succ = 0;
        commonAsk = new CommonAsk("android/cmh/board_insert");
        commonAsk.params.add(new CommonAskParam("vo", gson.toJson(vo)));
        //파일은 안주므로 주석  commonAsk.fileParams.add(new CommonAskParam("file", img_filepath));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            succ = gson.fromJson(new InputStreamReader(in), Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succ;
    }

    /* =============================================================== */
    public void getLikeCount() {
        commonAsk = new CommonAsk("category_like");
        commonAsk.params.add(new CommonAskParam("board_sn", String.valueOf(boardSN)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        String result = getStringFromInputStream(in);
        try {
            board_user_detail_tv_like_cnt.setText(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* =============================================================== */
    public void setLike() {
        BoardCommonVO pvo = new BoardCommonVO();
        pvo.setBoard_sn(boardSN);
        pvo.setFunction_like(vo.getFunction_like());
        pvo.setMember_id(Logined.member_id);
        commonAsk = new CommonAsk("set_like");
        commonAsk.params.add(new CommonAskParam("category", gson.toJson(pvo)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        String result = getStringFromInputStream(in);

        if (vo.getFunction_like() > 0) {
            vo.setFunction_like(0);
        } else {
            vo.setFunction_like(1);
        }
        setLikeIcon();
    }

    /* =============================================================== */
    public void setLikeIcon() {
        if (vo.getFunction_like() > 0) {
            Glide.with(Board00DetailFg.this).load(R.drawable.like).into(board_user_detail_img_like);
        } else {
            Glide.with(Board00DetailFg.this).load(R.drawable.like_gray).into(board_user_detail_img_like);
        }
        getLikeCount();
    }

    /* =============================================================== */
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
    /* =============================================================== */

    /* =============================== 댓글 insert ======================= */
    public int insertReply(ReplyVO replyVO) { //insert into tbl_reply
        succ = 0;
        commonAsk = new CommonAsk("android/cmh/reply_insert/");
        commonAsk.params.add(new CommonAskParam("replyVO", gson.toJson(replyVO)));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {
            succ = gson.fromJson(new InputStreamReader(in), Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succ;
    }
    /* =============================================================== */

    public void selectReplys(){
        selectReply(boardSN);
        LinearLayoutManager lmanager = new LinearLayoutManager(
                getActivity(), RecyclerView.VERTICAL, false);
        ReplyAdapter adapter = new ReplyAdapter(getActivity(), list);
        Board_User_Reply_RcView.setLayoutManager(lmanager);
        Board_User_Reply_RcView.setAdapter(adapter);
    }
}