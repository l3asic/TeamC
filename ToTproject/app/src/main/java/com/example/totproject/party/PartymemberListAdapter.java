package com.example.totproject.party;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.totproject.R;

import java.util.ArrayList;

public class PartymemberListAdapter  extends BaseAdapter {
    //private static final String TAG = "tv1";
    Context context; // <- foreGround  == frontGround
    // ,  ↑ BackGround ( Context )==생성자
    ArrayList<PartymemberListDTO> list;
    LayoutInflater inflater;
    //GridAdapter <= FragmentGrid.Class(java) 생성해보기
    public PartymemberListAdapter(Context context, ArrayList<PartymemberListDTO> list) {
        this.context = context;
        this.list = list;
        //this.inflater = inflater;←만들어서 넘겨준거 세팅, ↓직접 만들기
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addItem(ArrayList<PartymemberListDTO> list){
        this.list = list;
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
                    inflater.inflate(R.layout.party_frag_partyjoin_member_item,parent ,false);
            viewHolder = new GridViewHolder();
            viewHolder.imgv_member_pic = convertView.findViewById(R.id.imgv_member_pic);
            viewHolder.tv_member_nick = convertView.findViewById(R.id.tv_member_nick);


            convertView.setTag(viewHolder);
        }else{
            viewHolder = (GridViewHolder) convertView.getTag();
        }
        //if(list.get(position).getImgresId() == 1)
        viewHolder.tv_member_nick.setText(list.get(position).getMemberid());
        //viewHolder.imgv1.setImageResource(list.get(position).getImgresId());


        return convertView;
    }
    //ViewHolder <- 위젯들을 하나로 묶은 클래스를 만들고 사용.
    //Imagev1 , tv1 , tv2 (Class)
    public class GridViewHolder{
        public ImageView imgv_member_pic;
        public TextView tv_member_nick;
    }

}

