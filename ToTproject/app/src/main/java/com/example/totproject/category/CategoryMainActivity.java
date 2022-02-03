package com.example.totproject.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.totproject.R;

import java.util.ArrayList;

public class CategoryMainActivity extends AppCompatActivity {
    //GridView gridView;
    int tabcode;
    TextView category_main_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_act_main_new);

        category_main_tv = findViewById(R.id.category_main_tv);

        Fragment02CategoryGridView categoryGridView = new Fragment02CategoryGridView();
        category_main_tv.setText(getIntent().getStringExtra("tabText"));

        Intent getIntent = getIntent();
        tabcode = getIntent.getIntExtra("tabcode",0);

        if(tabcode == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.cate_container, categoryGridView).commit();
            // 관광지시 출력연계

        }else if (tabcode ==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.cate_container, categoryGridView).commit();
            // 액티비티시 출력연계

        }else if (tabcode ==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.cate_container, categoryGridView).commit();
            // 지역축제시 출력연계

        }






        /*ArrayList<GridDTO> list = new ArrayList<>();

        for(int i=0; i < 10; i++){
            GridDTO dto = new GridDTO();
            dto.setBoard_title("제목"+i);
            dto.setBoard_content("내용"+i);
            dto.setBoard_read_cnt(i);
            dto.setBoard_reviewepath(i);


            list.add(dto);
        }
        GridAdapter adapter = new GridAdapter(CategoryMainActivity.this,list);
        gridView = findViewById(R.id.gridv);

        gridView.setAdapter(adapter);*/
    }
}