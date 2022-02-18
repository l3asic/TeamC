package com.example.totproject.main.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.main.VO.ReplyVO;

import java.util.ArrayList;
import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.Viewholder> {
    //xml로 만들어놓은 아이템을 붙이기위한 LayoutInfler <- Context
    Context context;
    List<ReplyVO> list;
    LayoutInflater inflater;
    View.OnClickListener listener;
    FragmentManager manager;

    public ReplyAdapter(Context context, ArrayList<ReplyVO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }//NoticeAdapter

    public ReplyAdapter(Context context, List<ReplyVO> list, FragmentManager manager) {
        this.manager = manager;
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (null != listener)
            this.listener = listener;

    }//NoticeAdapter
    public ReplyAdapter(Context context, List<ReplyVO> list) {
        //       this.manager = manager;
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (null != listener)
            this.listener = listener;

    }//NoticeAdapter


    //화면을 인플레이트 시키는 작업을 하기.
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.zzz_boardtab_frag_detail_item_reply, parent, false);
        //1. ViewHolder holder = new ViewHolder(itemview);
        // return holder;
        return new Viewholder(itemView);
    }//onCreateViewHolder

    //4. 아이템이 ↑ 세팅되고 나서의 처리를 의미함↓
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.bind(holder, position, manager);
    }//onBindViewHolder

    //5.↓ 총 아이템의 갯수를 지정함.
    @Override
    public int getItemCount() {
        return list.size();
    }//getItemCount


    //1. RecyclerView.ViewHolder 상속을 받은 클래스 ViewHolder를 만들어줌
    public class Viewholder extends RecyclerView.ViewHolder {
        TextView  board_user_reply_member_id, board_user_reply_reply_content, board_user_reply_writedate;
        ImageView board_user_reply_img_profile;
        int board_sn;
                LinearLayout board_user_list_item;

                ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            board_user_reply_member_id = itemView.findViewById(R.id.board_user_reply_member_id);
            board_user_reply_reply_content = itemView.findViewById(R.id.board_user_reply_reply_content);
            board_user_reply_writedate = itemView.findViewById(R.id.board_user_reply_writedate);
            board_user_reply_img_profile = itemView.findViewById(R.id.board_user_reply_imgv_profile);


            board_user_list_item = itemView.findViewById(R.id.board_user_list_item);

        }

        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull Viewholder holder, int position, FragmentManager manager) {
            /* ============================== 해당 홀더 board_sn ============================== */
            holder.board_sn = list.get(position).getReply_sn();
            /* ====================================================================== */

            /* ============================== TextView 세팅 ============================== */

           // holder.board_user_reply_img_profile.setText(list.get(position).getPicture_filepath() + "");
            holder.board_user_reply_member_id.setText(list.get(position).getMember_id()+ "");
            holder.board_user_reply_reply_content.setText(list.get(position).getReply_content() + "");
            holder.board_user_reply_writedate.setText(list.get(position).getReply_writedate()+ "");
            /* ====================================================================== */




        }
    }//ViewHolder
}
