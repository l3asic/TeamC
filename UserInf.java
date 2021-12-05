package com.example.test03_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserInf extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.UserInf);
		// ↑ 디자인 로딩이 완료가 되고나서 위젯을 찾는다.
		TextView tv_id = findViewById(R.id.tv_id);
		TextView tv_pw = findViewById(R.id.tv_pw);
		TextView tv_name = findViewById(R.id.tv_name);
		TextView tv_age = findViewById(R.id.tv_age);
		TextView tv_addr = findViewById(R.id.tv_addr);
		TextView tv_nick = findViewById(R.id.tv_nick);

		// MainActivity Intent=> SubActivity
		Intent itt = getIntent(); // 모델

//        String test = itt.getStringExtra("test");
//        int testInt = itt.getIntExtra("testint" , -1);

		DTO dto = (DTO) itt.getSerializableExtra("dto");

//        tv2.setText(test + testInt);

		tv_id.setText(dto.id);
		tv_pw.setText(dto.pw);
		tv_name.setText(dto.name);
		tv_age.setText(dto.age);
		tv_addr.setText(dto.addr);
		tv_nick.setText(dto.nick);
		
		tv_id.append(dto.id);
		tv_pw.append(dto.pw);
		tv_name.append(dto.name);
		tv_age.append(dto.age);
		tv_addr.append(dto.addr);
		tv_nick.append(dto.nick);

	}
}
