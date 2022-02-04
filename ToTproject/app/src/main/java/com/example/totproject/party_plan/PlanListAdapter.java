package com.example.totproject.party_plan;

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
    public PlanListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.partyplan_frag_planlist_item, parent , false);
        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanListAdapter.Viewholder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgv_plan;
        TextView tv_writer, tv_plan_name, tv_date, tv_time;
        LinearLayout lin_plan_click;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            //imgv_plan = itemView.findViewById(R.id.imgv_party);
            tv_writer = itemView.findViewById(R.id.tv_writer);
            tv_plan_name = itemView.findViewById(R.id.tv_plan_name);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);

        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull PlanListAdapter.Viewholder holder, int position){
            //내용 바꾸기 처리
            //holder.imgv_plan.setImage    //@@@@@@@@@@@이미지 어캐바꾸더라??
            holder.tv_writer.setText( list.get(position).getWriter() +"" );
            holder.tv_plan_name.setText( list.get(position).getPlan_name() +"" );
            holder.tv_date.setText( list.get(position).getDate() +"" );
            holder.tv_time.setText( list.get(position).getTime() +"" );


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




}//planListAdapter()
