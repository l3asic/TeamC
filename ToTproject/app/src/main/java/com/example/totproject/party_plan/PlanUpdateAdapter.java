package com.example.totproject.party_plan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;

import java.util.ArrayList;

public class PlanUpdateAdapter extends RecyclerView.Adapter<PlanUpdateAdapter.Viewholder>  {
    Context context;
    ArrayList<PlanInfoDTO> list;
    LayoutInflater inflater;


    public PlanUpdateAdapter(Context context, ArrayList<PlanInfoDTO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public PlanUpdateAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.partyplan_act_updateplan_item, parent , false);
        return new PlanUpdateAdapter.Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanUpdateAdapter.Viewholder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        EditText edt_partyplan_time, edt_partyplan_content, edt_partyplan_content_detail;
        LinearLayout lin_click_update_content;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            lin_click_update_content = itemView.findViewById(R.id.lin_click_update_content);
            edt_partyplan_time = itemView.findViewById(R.id.edt_partyplan_time);
            edt_partyplan_content = itemView.findViewById(R.id.edt_partyplan_content);
            edt_partyplan_content_detail = itemView.findViewById(R.id.edt_partyplan_content_detail);

        }
        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull PlanUpdateAdapter.Viewholder holder, int position){
            //내용 바꾸기 처리
            //holder.imgv_plan.setImage    //@@@@@@@@@@@이미지 어캐바꾸더라??
            holder.edt_partyplan_time.setText( list.get(position).getPlandetail_time() +"" );
            holder.edt_partyplan_content.setText( list.get(position).getPlandetail_content() +"" );
            holder.edt_partyplan_content_detail.setText( list.get(position).getPlandetail_content_detail() +"" );



            holder.lin_click_update_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Detail로 이동 , Detail에서 추가 수정 삭제.                 @@클릭시 이동 참조용
//                    Intent intent = new Intent(context, PlanMainActivity.class);
//                    intent.putExtra("dto" , list.get(position));
//                    intent.putExtra("tabcode",2);
//                    // intent.putExtra("id" , list.get(position).getId());
//                    context.startActivity(intent);
                }
            });

        }

    }




}//planListAdapter()