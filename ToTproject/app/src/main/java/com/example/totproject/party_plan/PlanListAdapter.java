package com.example.totproject.party_plan;

import android.content.Context;
import android.content.Intent;
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

public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.Viewholder> {
    Context context;
    ArrayList<PlanlistDTO> list;
    LayoutInflater inflater;


    public PlanListAdapter(Context context, ArrayList<PlanlistDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.partyplan_frag_planlist_item, parent , false);
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
        ImageView imgv_plan;
        TextView tv_plan_writer, tv_plan_name, tv_startdate, tv_starttime;
        LinearLayout lin_plan_click;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            //imgv_plan = itemView.findViewById(R.id.imgv_party);
            lin_plan_click = itemView.findViewById(R.id.lin_plan_click);
            tv_plan_writer = itemView.findViewById(R.id.tv_plan_writer);
            tv_plan_name = itemView.findViewById(R.id.tv_plan_name);
            tv_startdate = itemView.findViewById(R.id.tv_startdate);
            tv_starttime = itemView.findViewById(R.id.tv_starttime);

        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull Viewholder holder, int position){
            //내용 바꾸기 처리
            //holder.imgv_plan.setImage    //@@@@@@@@@@@이미지 어캐바꾸더라??
            holder.tv_plan_writer.setText( list.get(position).getPlan_writer() +"" );
            holder.tv_plan_name.setText( list.get(position).getPlan_name() +"" );
            holder.tv_startdate.setText( list.get(position).getPlan_startdate() +"" );
            holder.tv_starttime.setText( list.get(position).getPlan_starttime() +"" );


            holder.lin_plan_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Detail로 이동 , Detail에서 추가 수정 삭제.                 @@클릭시 이동 참조용
                    Intent intent = new Intent(context, PlanMainActivity.class);
                    intent.putExtra("dto" , list.get(position));
                    intent.putExtra("tabcode",2);
                    // intent.putExtra("id" , list.get(position).getId());
                    context.startActivity(intent);
                }
            });

        }

    }




}//planListAdapter()
