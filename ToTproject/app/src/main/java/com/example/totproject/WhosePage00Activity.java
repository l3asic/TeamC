package com.example.totproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.ChangeView;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.main.Fragment03BoardTab;

import java.util.List;

public class WhosePage00Activity extends AppCompatActivity {
    ImageView whosepage_imgv_profile;
    TextView whosepage_tv_member_id, whosepage_tv_text, whosepage_tv_board_cnt;

    String member_id, cnt_board_list;


    /* ===================================== Contructor ================================== */
    public WhosePage00Activity() {
    }

    public WhosePage00Activity(MemberDTO memberDTO, List<BoardCommonVO> list) {
        this.member_id = memberDTO.getMember_id();
        this.cnt_board_list = list.size() + "";

        //   whosepage_tv_member_id.setText(member_id);
        //  whosepage_tv_board_cnt.setText(cnt_board_list);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzz_whosepage00_act);

        whosepage_tv_member_id = findViewById(R.id.whosepage_tv_member_id);
        whosepage_tv_text = findViewById(R.id.whosepage_tv_text);
        whosepage_tv_board_cnt = findViewById(R.id.whosepage_tv_board_cnt);


    }//onCreate


    @Override
    protected void onStart() {
        super.onStart();


        Intent getIntent = getIntent();
        int tabCode = getIntent.getIntExtra("tabCode", 0);
        String tabText = getIntent.getStringExtra("fromWhere");

        if (tabCode == 1) {
            Fragment03BoardTab fragment03BoardTab = new Fragment03BoardTab(WhosePage00Activity.this, getSupportFragmentManager(), "whosePage_write", Logined.member_id);
            Toast.makeText(WhosePage00Activity.this, "작성 게시물확인", Toast.LENGTH_SHORT).show();
            whosepage_tv_text.setText("작성한 게시물 수 : ");
            ChangeView.viewFrament(R.id.whosepage_container, fragment03BoardTab, getSupportFragmentManager());
        } else if (tabCode == 2) {
            Toast.makeText(WhosePage00Activity.this, "좋아요 게시물확인", Toast.LENGTH_SHORT).show();
            whosepage_tv_text.setText("좋아요 게시물 수 : ");
            Fragment03BoardTab fragment03BoardTab = new Fragment03BoardTab(WhosePage00Activity.this, getSupportFragmentManager(), "whosePage_likes", Logined.member_id);
            ChangeView.viewFrament(R.id.whosepage_container, fragment03BoardTab, getSupportFragmentManager());
        } else if (tabCode == 3) {
            Toast.makeText(WhosePage00Activity.this, "탭코드3", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    /* =============================== 메소드 ============================= */
    public void setActTexts(String member_id, List<BoardCommonVO> list) { //생성자만으로 안되면 이거 실행해야함
        whosepage_tv_member_id.setText(member_id);
        whosepage_tv_board_cnt.setText(list.size() + "");
    }


}