package com.example.totproject.mainburgeractivity.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.common.VO.BoardCommonVO;
import com.example.totproject.mainburgeractivity.MainBurger01NoticeFgDetailFg;


import java.util.ArrayList;
import java.util.List;

public class NoticeAdapter extends BaseExpandableListAdapter {
    //xml로 만들어놓은 아이템을 붙이기위한 LayoutInfler <- Context
    Context context;
    List<BoardCommonVO> list;
    LayoutInflater inflater;
    FragmentManager manager;
    public NoticeAdapter(Context context, ArrayList<BoardCommonVO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }//NoticeAdapter
    public NoticeAdapter(Context context, List<BoardCommonVO> list, FragmentManager manager) {
        this.manager = manager;
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }//NoticeAdapter


    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return  list.get(groupPosition).getBoard_content();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.mainburger01_notice_fg_item, parent, false);
            holder  = new GroupViewHolder(convertView);
            holder.bind(holder,groupPosition);
            convertView.setTag(holder);
        }else{
            holder = (GroupViewHolder) convertView.getTag();
        }

        if (isExpanded) {
            holder.layout.setBackgroundColor(Color.parseColor("#FFDBDCE8"));
        } else {
            holder.layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SubViewHolder holder ;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.mainburger01_notice_fg_item_sub, parent, false);
            holder  = new SubViewHolder(convertView);
            holder.bind(holder,groupPosition);
            convertView.setTag(holder);
        }else{
            holder = (SubViewHolder) convertView.getTag();
        }

        if (isLastChild) {
            holder.layout.setBackgroundColor(Color.parseColor("#FFDBDCE8"));
        } else {
            holder.layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



    public class GroupViewHolder{
        View itemView;
        TextView title, writedate;
        int board_sn;
        LinearLayout layout;
        public GroupViewHolder(@NonNull View  itemView) {
            this.itemView = itemView;
            title = itemView.findViewById(R.id.notice_title);
            writedate = itemView.findViewById(R.id.notice_writedate);
            layout = itemView.findViewById(R.id.group_linear);
        }
        public void bind(@NonNull GroupViewHolder holder, int position){
            holder.title.setText(list.get(position).getBoard_title() + "" );
            holder.writedate.setText(list.get(position).getBoard_date_create() + "");
            holder.board_sn = list.get(position).getBoard_sn();
        }
    }
    public class SubViewHolder{
        View itemView;
        TextView notice_content;
        LinearLayout layout;
        public SubViewHolder(@NonNull View  itemView) {
            this.itemView = itemView;
            notice_content = itemView.findViewById(R.id.notice_content);
            layout = itemView.findViewById(R.id.sub_linear);
        }
        public void bind(@NonNull SubViewHolder holder, int position){
            holder.notice_content.setText(list.get(position).getBoard_content() + "" );
        }
    }
}
