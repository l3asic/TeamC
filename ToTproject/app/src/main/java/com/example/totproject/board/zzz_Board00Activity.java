package com.example.totproject.board;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.totproject.R;
import com.example.totproject.common.statics.ChangeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class zzz_Board00Activity extends AppCompatActivity {
    int tabCode;
    TextView board_act_tv_title;
    int board_container = R.id.board_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzz_board00_act_main);
        board_act_tv_title = findViewById(R.id.board_act_tv_title);

        Intent getIntent = new Intent(getIntent());
        String tabText = getIntent.getStringExtra("tabText");
        Board01WriteFg board01WriteFg = new Board01WriteFg();
        Board01WriteFg board01SearchFg = new Board01WriteFg();

        if ("write".equals(tabText)) {
            ChangeView.changeFrament(board_container, board01WriteFg, getSupportFragmentManager());
        } else if ("search".equals(tabText)) {
            ChangeView.changeFrament(board_container, board01WriteFg, getSupportFragmentManager());
        }

    }//oncreate()

    /* =================================== view변경 + 상단텍스트 변경 ===========-------======================== */


}