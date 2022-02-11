package com.example.totproject.zzchaminhwan;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.main.MainActivity;
import com.example.totproject.zzchaminhwan.VO.NoticeVO;
import com.example.totproject.zzchaminhwan.VO.OneOneEmailVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;

public class MainBurger02ServiceFg0203OneOneEmailFg extends Fragment {

    EditText name, email, tel, title, content, password;
    Button cancel, submit;
    Context context;
    FragmentManager manager;

    String getname, getemail, gettel, gettitle, getcontent, getpassword;
    String isCase;
    LinearLayout ifHide01, ifHide02;

    public MainBurger02ServiceFg0203OneOneEmailFg(Context context, FragmentManager manager, String isCase) { //컨텍슽르르 메인에서부터 가져옴
        this.context = context;
        this.manager = manager;
        this.isCase = isCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.zzz_main_burger02_service_fg_0203_oneoneemail, container, false);

        name = v.findViewById(R.id.main_burger_service_oneoneemail_edt_name);
        email = v.findViewById(R.id.main_burger_service_oneoneemail_edt_email);
        tel = v.findViewById(R.id.main_burger_service_oneoneemail_edt_tel);
        title = v.findViewById(R.id.main_burger_service_oneoneemail_edt_title);
        content = v.findViewById(R.id.main_burger_service_oneoneemail_edt_content);
        password = v.findViewById(R.id.main_burger_service_oneoneemail_edt_password);

        cancel = v.findViewById(R.id.main_burger_service_oneoneemail_btn_cancel);
        submit = v.findViewById(R.id.main_burger_service_oneoneemail_btn_submit);

        ifHide01 = v.findViewById(R.id.main_burger_service_oneoneemail_ifhide01);
        ifHide02 = v.findViewById(R.id.main_burger_service_oneoneemail_ifhide02);
        if ("OneOne".equals(isCase)) {
            Toast.makeText(context, "로그인정보 자동입력 + ( 입력불가 or 아예숨겨버리기 )", Toast.LENGTH_SHORT).show();
            isCaseText(name);
            isCaseText(email);
            isCaseText(tel);
            isCaseText(password);
            //isCaseHide(ifHide01);
            //isCaseHide(ifHide02);
        } else if ("Email".equals(isCase)) {
            Toast.makeText(context, "수동입력", Toast.LENGTH_SHORT).show();
        }


        vo.setName(getText(name, getname));
        vo.setEmail(getText(email, getemail));
        vo.setTel(getText(tel, gettel));
        vo.setTitle(getText(title, gettitle));
        vo.setContent(getText(content, getcontent));
        vo.setPassword(getText(password, getpassword));


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "취소버튼 눌림", Toast.LENGTH_SHORT).show();
                manager.popBackStack();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "확인버튼 눌림 - DB연동 해야함", Toast.LENGTH_SHORT).show();
                ;//db연결(vo);
insertVs(vo);

            }
        });
        return v;

    }

    /**/
    CommonAsk commonAsk;
    Gson gson = new Gson();
    OneOneEmailVO vo = new OneOneEmailVO();

    public OneOneEmailVO insertVs(OneOneEmailVO vo) {
        commonAsk = new CommonAsk("android/cmh/insertVS");

        commonAsk.params.add(new CommonAskParam("vo", gson.toJson(vo)));
        //파일은 안주므로 주석  commonAsk.fileParams.add(new CommonAskParam("file", img_filepath));
        InputStream in = CommonMethod.excuteAsk(commonAsk);



        if (vo != null) {
            Toast.makeText(context, "db insert 성공", Toast.LENGTH_SHORT).show();
            manager.popBackStack();

        } else {
            Toast.makeText(context, "오류발생 ", Toast.LENGTH_SHORT).show();

        }
        return vo;
    }
    /**/

    public void isCaseText(TextView textView) {
        textView.setEnabled(true);
        textView.setText("ChaMinHwan");
        //textView.setText(logInvo.get.(append(textView) )); <ㅡ 이런거 안되면 이상한 고집부리지말고 걍 하드코딩하면됨 민환쨩 화이팅 간바레~ 앙 기모링~!
        textView.setBackgroundColor(Color.GRAY);
    }

    public void isCaseHide(LinearLayout linearLayout) {
        linearLayout.setVisibility(View.INVISIBLE);
    }

    public String getText(TextView textView, String getText) {
        getText = textView.getText() + "";
        return getText;
    }


}