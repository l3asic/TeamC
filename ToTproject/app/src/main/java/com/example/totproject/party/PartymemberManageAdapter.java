package com.example.totproject.party;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.common.VO.MemberDTO;

import java.util.ArrayList;


public class PartymemberManageAdapter extends RecyclerView.Adapter<PartymemberManageAdapter.Viewholder> {
    Context context;
    ArrayList<MemberDTO> list;
    LayoutInflater inflater;

    public PartymemberManageAdapter(Context context, ArrayList<MemberDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.party_act_membermanage_item , parent , false);
        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgv_member_pic;
        TextView tv_member_nick;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            //imgv_member_pic = itemView.findViewById(R.id.imgv_member_pic);
            tv_member_nick = itemView.findViewById(R.id.tv_member_nick);



        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull Viewholder holder, int position){
            //내용 바꾸기 처리
            //holder.imgv_member_pic.setImage    //@@@@@@@@@@@이미지 어캐바꾸더라??
            holder.tv_member_nick.setText( list.get(position).getMember_nick() +"" );


        }

    }



}//PartyListAdapter()
