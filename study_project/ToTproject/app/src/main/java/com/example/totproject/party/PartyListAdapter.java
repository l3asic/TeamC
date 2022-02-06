package com.example.totproject.party;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;

public class PartyListAdapter extends RecyclerView.Adapter<PartyListAdapter.Viewholder> {
    Context context;
    ArrayList<PartyListDTO> list;
    LayoutInflater inflater;

    public PartyListAdapter(Context context, ArrayList<PartyListDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public PartyListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.party_frag_openpartylist_item , parent , false);
        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartyListAdapter.Viewholder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgv_party;
        TextView tv_party_name , tv_party_detail, tv_party_tag1, tv_party_tag2, tv_party_tag3;
        LinearLayout lin_party_click;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            //imgv_party = itemView.findViewById(R.id.imgv_party);
            tv_party_name = itemView.findViewById(R.id.tv_party_name);
            tv_party_detail = itemView.findViewById(R.id.tv_party_detail);
            tv_party_tag1 = itemView.findViewById(R.id.tv_party_tag1);
            tv_party_tag2 = itemView.findViewById(R.id.tv_party_tag2);
            tv_party_tag3 = itemView.findViewById(R.id.tv_party_tag3);

        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull Viewholder holder, int position){
            //내용 바꾸기 처리
            //holder.imgv_party.setImage    //@@@@@@@@@@@이미지 어캐바꾸더라??
            holder.tv_party_name.setText( list.get(position).getParty_name() +"" );
            holder.tv_party_detail.setText( list.get(position).getParty_detail() +"" );
            holder.tv_party_tag1.setText( list.get(position).getParty_tag1() +"" );
            holder.tv_party_tag2.setText( list.get(position).getParty_tag2() +"" );
            holder.tv_party_tag3.setText( list.get(position).getParty_tag3() +"" );

//            holder.lin_party_click.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//
//                    //Detail로 이동 , Detail에서 추가 수정 삭제.                 @@클릭시 이동 참조용
//                    Intent intent = new Intent(context, DetailActivity.class);
//                    intent.putExtra("vo" , list.get(position));
//                    // intent.putExtra("id" , list.get(position).getId());
//                    context.startActivity(intent);
//                }
//            });

        }

    }



}//PartyListAdapter()
