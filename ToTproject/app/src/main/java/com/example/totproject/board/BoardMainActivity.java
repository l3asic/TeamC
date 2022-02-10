package com.example.totproject.board;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.totproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BoardMainActivity extends AppCompatActivity {

    private FloatingActionButton board_fab_main, board_fab1, board_fab2, board_fab3;
    private Animation fab_open, fab_close, rotate_clockwise, rotate_anticlockwise;
    private Boolean isFabOpen = false;
    private Object FragmentBoardSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_act_main);

        board_fab_main = findViewById(R.id.board_fab_main);
        board_fab1 = findViewById(R.id.board_fab1);
        board_fab2 = findViewById(R.id.board_fab2);
        board_fab3 = findViewById(R.id.board_fab3);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        board_fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !isFabOpen ) {
                    showfabMenu();
                }
                else{
                    closefabMenu();
                }
            }
        });

        board_fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardMainActivity.this, Activity03BoardDetail.class);
                startActivity(intent);
            }
        });

        board_fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardMainActivity.this, BoardNewActivity.class);
                startActivity(intent);
            }
        });

        board_fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               //transaction.replace(R.id.board_container, (Fragment) Board_frag_search).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.board_container, (Fragment) FragmentBoardSearch).addToBackStack(null).commit();

            }
        });

    }//oncreate()

   private void showfabMenu() {
        isFabOpen = true;
        board_fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        board_fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        board_fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
   }

   private void closefabMenu() {
        isFabOpen = false;
        board_fab1.animate().translationY(0);
        board_fab2.animate().translationY(0);
        board_fab3.animate().translationY(0);
   }
}