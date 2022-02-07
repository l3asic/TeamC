package com.example.totproject.zzchaminhwan;

//Recycler Adapter 마스터 ==> veiwPager2 ==>(Recycler Adapter )
//viewpager <가로만됨 > viewpager2 세로도됨.
//ViewHolder를 강제한다. ( 우리가 xml에 만들어놓은 위젯의 묶음이 되는 클래스 )
// Imageview , TextView <-묶어놓은 클래스를 반드시 만들고 이벤트 핸들링을 여기서해라.

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totproject.R;
import com.example.totproject.zzchaminhwan.NoticeVO;

import java.util.ArrayList;


public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
//2.아이템마다 보여줄 정보를 가지고있는 DTO를 하나로 묶은 Collection 구조를 받을수있게
//필드로 선언 , LayoutInflater 사용을 위한 준비를 함. <-(1).Activity로부터 받아옴(Context)
    //(2) static으로 있는 getApplicationContext로 사용 <- 지원안하는 기능들도있음 ↑
    //context<- 토스트를 띄우기 , LayoutInflater만들기 , 등등 화면에 떠있는 객체에서
    //할수있는 기능들을 처리할수가있다. (일반 클래스에도 context를 넘기면 화면 제어를 할수가있음)
    //RecAdapter<- 일반 클래스임

    //메인에서 넘겨 받을 필드griddto
    Context context;
    ArrayList<NoticeVO> list;
    LayoutInflater inflater;
    /*View.OnClickListener listener;*/
    //생성자 메소드를 만듬 ↑ 세개를 입력받거나 또는 두개를 입력받아서 LayoutInflater까지 null이 아니게 ..
    //생성자 메소드 호출해보기 . ( RecyclerActivity )

    public NoticeAdapter(Context context, ArrayList<NoticeVO> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //액티비티의 소스 줄을 조금 줄일수가있음.
        //context 자체를 받아왔기때문에 context를 이용하는것이 메모리에 더 효율적이다.
    }//NoticeAdapter


    //3.화면을 인플레이트 시킨다. ( 리사이클러의 아이템 하나마다 붙을 xml을 연결시킨다 )
    // xml 로 연결시킨 view자체를 Viewholder에 넘겨줌 ( == ViewHolder에서는 view를 통해서 find )
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.zzz_main_burger01_notice_fg_item, parent, false);
        //1. ViewHolder holder = new ViewHolder(itemview);
        // return holder;
        return new ViewHolder(itemview);
    }//onCreateViewHolder

    //4. 아이템이 ↑ 세팅되고 나서의 처리를 의미함↓
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }//onBindViewHolder

    //5.↓ 총 아이템의 갯수를 지정함.
    @Override
    public int getItemCount() {
        return list.size();
    }//getItemCount


    //1. RecyclerView.ViewHolder 상속을 받은 클래스 ViewHolder를 만들어줌
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, writedate; //xml에 있는 위젯들을 전역변수로 선언.
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notice_title);
            writedate = itemView.findViewById(R.id.notice_writedate);
        }

        //ItemView세팅되고 나서 list <-> item.xml 연결해서 세팅하는부분
        public void bind(@NonNull ViewHolder holder, int position) {
            //내용 바꾸기 처리
            holder.title.setText(list.get(position).getTitle() + "");
            holder.writedate.setText(list.get(position).getWritedate() + "");


            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Detail로 이동 , Detail에서 추가 수정 삭제.
                    Intent intent = new Intent(context, MainBurger01NoticeFgDetail.class);
                    intent.putExtra("vo", list.get(position));
                    // intent.putExtra("id" , list.get(position).getId());
                    context.startActivity(intent);//
                }
            });


        }
    }//ViewHolder
}
