package com.example.totproject.category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.VO.PictureVO;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<PictureVO> list;

    public final String IP = "http://192.168.0.195";
    final String HTTPIP = IP;//IP
    final String SVRPATH = "/tot/"; //
    String mapping ;
    private String postUrl ;//

    public PagerAdapter(Context context , ArrayList<PictureVO> list) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.category_frag_detail_pager_item , parent , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindSliderImage(list.get(position).getPicture_filepath());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.category_deatail_pager_img);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        public void bindSliderImage(String imageURL) {
//            Glide.with(context)
//                    .load(imageURL)
//                    .into(imageView);
            Bundle bundle = new Bundle();
            int position = bundle.getInt("board_sn");

            Glide.with(context)
                    .load(IP+SVRPATH+ list.get(position).getPicture_filepath())
                    .into(imageView);
        }
    }
}
