package com.example.totproject.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.Adapter.ReplyAdapter;
import com.example.totproject.main.VO.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment03BoardTab_Detail_Act extends AppCompatActivity {

    TextView board_user_detail_tv_board_title, board_user_detail_tv_board_content, board_user_detail_tv_replycnt, board_user_detail_tv_like_cnt;
    LinearLayout board_user_detail_linear_update, board_user_detail_linear_delete, board_user_detail_linear_like;

    ImageView board_user_detail_img_reply_submit, board_user_detail_img_like;
    EditText board_user_detail_edt_reply_input;


    RecyclerView Board_User_Reply_RcView;
    BoardCommonVO vo = new BoardCommonVO();
    ReplyVO replyVO = new ReplyVO();
    List<ReplyVO> list = new ArrayList<>();
    int boardSN ;

    Context context;
    FragmentManager manager;
    int paramSn;


    /* ==================================== * from tbl_board ===================================== */

    /* =========================================================================================== */

    /* =========================================================================================== */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzz_boardtab_frag_detail);
Intent getinIntent = new Intent(getIntent());
vo = (BoardCommonVO) getinIntent.getSerializableExtra("vo");

        board_user_detail_linear_update = findViewById(R.id.board_user_detail_linear_update);
        board_user_detail_linear_delete = findViewById(R.id.board_user_detail_linear_delete);
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
        board_user_detail_tv_board_title = findViewById(R.id.board_user_detail_tv_board_title);
        board_user_detail_tv_board_content = findViewById(R.id.board_user_detail_tv_board_content);
        board_user_detail_tv_replycnt = findViewById(R.id.board_user_detail_tv_replycnt);
        /* ================================= board_content 세팅 ========================================= */
        board_user_detail_tv_board_title.setText(vo.getBoard_title() + "");
        board_user_detail_tv_board_content.setText(vo.getBoard_content() + "");
        board_user_detail_tv_replycnt.setText(vo.getBoard_cnt_reply() + "");
        boardSN = vo.getBoard_sn();
detail();
        /* ====================================================================================== */

        /* ===================================== DB댓글조회 및 어댑터 ============================== */
        selectReply(vo.getBoard_sn());
        Board_User_Reply_RcView = findViewById(R.id.board_useR_detail_recycler_detail);

        LinearLayoutManager lmanager = new LinearLayoutManager(
                Fragment03BoardTab_Detail_Act.this, RecyclerView.VERTICAL, false);
        ReplyAdapter adapter = new ReplyAdapter(Fragment03BoardTab_Detail_Act.this, list);

        Board_User_Reply_RcView.setLayoutManager(lmanager);
        Board_User_Reply_RcView.setAdapter(adapter);

        /* ====================================================================================== */


        /* ===================================== 하단 입력창 ============================== */
        board_user_detail_linear_like=findViewById(R.id.board_user_detail_linear_like);//좋아요 구역

        board_user_detail_edt_reply_input=findViewById(R.id.board_user_detail_edt_reply_input);//댓글입력

        board_user_detail_img_reply_submit=findViewById(R.id.board_user_detail_img_reply_submit);//댓글게시
        board_user_detail_img_reply_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String abc = board_user_detail_edt_reply_input.getText()+"";
            }
        });
        board_user_detail_tv_like_cnt=findViewById(R.id.board_user_detail_tv_like_cnt);//좋아요 cnt
        getLikeCount();
        board_user_detail_img_like=findViewById(R.id.board_user_detail_img_like);// 좋아요 버튼
        board_user_detail_img_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likes = Integer.parseInt(board_user_detail_tv_like_cnt.getText()+"");
                setLike();
                // tbl_likes 연동
            }
        });
        setLikeIcon();


        /* ====================================================================================== */

    }//onCreateView

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
            board_user_detail_tv_board_content.setText(vo.getBoard_content()+"");
            setLikeIcon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ReplyVO> selectReply(int board_sn) {
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
            Glide.with(Fragment03BoardTab_Detail_Act.this).load(R.drawable.like).into(board_user_detail_img_like);
        } else {
            Glide.with(Fragment03BoardTab_Detail_Act.this).load(R.drawable.like_gray).into(board_user_detail_img_like);
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
}