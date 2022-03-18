package com.example.totproject.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class TendencyAdapter extends RecyclerView.Adapter<TendencyAdapter.ViewHolder> {
    Context context;
    ArrayList<String> list;
    LayoutInflater inflater;
    public  TendDTO dto = new TendDTO();
    public TendencyAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        manualInput();
    }
    void manualInput(){
        list = new ArrayList<>();
        list.add("관광지 선호도");
        list.add("액티비티 선호도");
        list.add("축제 참여 선호도");
        list.add("1인여행 선호도");
        list.add("커플여행 선호도");
        list.add("친구(2~3인)여행 선호도");
        list.add("4인이상(단체) 여행 선호도");
        list.add("정적/동적 여행 선호여부\n(아주좋음-정적, 매우싫음-동적)");
        list.add("여행 경비 아낌 정도\n(아주좋음-저비용 , 매우싫음-고비용)");
        list.add("인도어 아웃도어 선호도\n (매우 좋음-인도어 , 매우싫음-아웃도어)");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.recv_tendency_item, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    public TendDTO getDto() {
        return dto;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioGroup mbti_rdo_group;
        TextView tv_mbti_q;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mbti_rdo_group = itemView.findViewById(R.id.mbti_rdo_group);
            tv_mbti_q = itemView.findViewById(R.id.tv_mbti_q);
        }

        public void bind(ViewHolder holder, int position) {
            holder.tv_mbti_q.setText(list.get(position));
            holder.mbti_rdo_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton btn = group.findViewById(checkedId);
                    int value = btn.getTag() == null ? 0 : Integer.parseInt(btn.getTag()+"");
                    if(position == 0 ){
                        dto.setMbti_tour(value);
                    }else if(position == 1 ){
                        dto.setMbti_activity(value);
                    }else if(position == 2 ){
                        dto.setMbti_festival(value);
                    }else if(position == 3 ){
                        dto.setMbti_solo(value);
                    }else if(position == 4 ){
                        dto.setMbti_couple(value);
                    }else if(position == 5 ){
                        dto.setMbti_buddys(value);
                    }else if(position == 6 ){
                        dto.setMbti_family(value);
                    }else if(position == 7 ){
                        dto.setMbti_price(value);
                    }else if(position == 8 ){
                        dto.setMbti_sd(value);
                    }else if(position == 9 ){
                        dto.setMbti_io(value);
                    }
                }
            });
        }
    }


}
