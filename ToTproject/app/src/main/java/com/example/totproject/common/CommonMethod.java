package com.example.totproject.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.totproject.R;
import com.example.totproject.party.MyPartyInfoActivity;
import com.example.totproject.party.PartyMainActivity;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class CommonMethod {
    static InputStream in = null;

    public static InputStream excuteAsk(AsyncTask<String, String, InputStream> ask) {


        try {
            in = ask.execute().get(); //집에서하면 항상 여기서고장남
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return in;
    }


    // 테스트용
    // 커스텀 다이얼로그 예 아니오 버전
    public View CustomDialogYesOrNo(Context context, View fromview) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,
                R.style.AlertDialogTheme);

        View view= LayoutInflater.from(context).inflate(
                R.layout.common_alert_yes_or_no_item,
                (LinearLayout)fromview.findViewById(R.id.layout_alert)
        );

        //다이얼로그 텍스트 설정
        builder.setView(view);
        ((TextView)view.findViewById(R.id.texttitle)).setText("※ 주의");
        ((TextView)view.findViewById(R.id.textmessage)).setText("정말 파티를 해산 하시겠어요?");
        ((TextView)view.findViewById(R.id.btn_dialog_yes)).setText("네");
        ((TextView)view.findViewById(R.id.btn_dialog_no)).setText("아니요");

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);   //화면밖 터치시 다이얼로그 종료방지

        //네 클릭시
        view.findViewById(R.id.btn_dialog_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();  //알럿창 닫기

            }
        });

        //아니요 클릭시
        view.findViewById(R.id.btn_dialog_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();  //알럿창 닫기
            }
        });

        //다이얼로그 형태 지우기
        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();

        return view;



    }//CustomDialogYesOrNo()





}//CommonMethod()
