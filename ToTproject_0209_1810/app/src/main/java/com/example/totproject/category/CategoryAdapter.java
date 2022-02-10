package com.example.totproject.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.totproject.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    Context context; // <- foreGround  == frontGround
                     // ,  ↑ BackGround ( Context )==생성자
    ArrayList<CategoryVO> list;
    LayoutInflater inflater;
    View.OnClickListener listener;
    //GridAdapter <= FragmentGrid.Class(java) 생성해보기
    public CategoryAdapter(Context context, ArrayList<CategoryVO> list , View.OnClickListener listener) {
        this.context = context;
        this.list = list;
        //this.inflater = inflater;←만들어서 넘겨준거 세팅, ↓직접 만들기
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(null != listener)
            this.listener = listener;
    }

    public CategoryAdapter(Context context, ArrayList<CategoryVO> list) {
        this.context = context;
        this.list = list;
        //this.inflater = inflater;←만들어서 넘겨준거 세팅, ↓직접 만들기
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //커스터마이징이 가장 많이 되는 부분
    //직접 GridView에 보여지는 Layout처리를 해야함. java<->xml
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder viewHolder;
        if (convertView == null){//아직 초기 디자인이 없는상태의 view라면
            convertView =            //layout        , parent , 제어권 false
                    inflater.inflate(R.layout.category_frag_grildlist_item_list,parent ,false);
            viewHolder = new GridViewHolder();
            viewHolder.category_img_tour = convertView.findViewById(R.id.category_img_tour);
            viewHolder.category_tv_tourname = convertView.findViewById(R.id.category_tv_tourname);
            viewHolder.category_tv_like = convertView.findViewById(R.id.category_tv_like);
            viewHolder.category_tv_comment = convertView.findViewById(R.id.category_tv_comment);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (GridViewHolder) convertView.getTag();
        }
        //if(list.get(position).getImgresId() == 1)
        viewHolder.category_tv_tourname.setText(list.get(position).getBoard_title());
        viewHolder.category_tv_comment.setText(list.get(position).getBoard_replly_able());
        convertView.setOnClickListener(listener);

        //viewHolder.imgv1.setImageResource(list.get(position).getImgresId());
        /*viewHolder.category_img_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });*/
        return convertView;
    }
    //ViewHolder <- 위젯들을 하나로 묶은 클래스를 만들고 사용.
    //Imagev1 , tv1 , tv2 (Class)
    public class GridViewHolder{
        public ImageView category_img_tour;
        public TextView category_tv_tourname, category_tv_like, category_tv_comment;
    }

}
