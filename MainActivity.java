package com.example.test03_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	EditText edit_id, edit_pw, edit_name, edit_age, edit_addr, edit_nick;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crt_acc);

		btn = findViewById(R.id.btn);

		edit_id = findViewById(R.id.edit_id);
		edit_pw = findViewById(R.id.edit_pw);
		edit_name = findViewById(R.id.edit_name);
		edit_age = findViewById(R.id.edit_age);
		edit_addr = findViewById(R.id.edit_addr);
		edit_nick = findViewById(R.id.edit_nick);

		;

		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 암시적(묵시) , 명시적
				// 명시적 인텐트 , 정확한 위치를 알고있을때 사용.★★★
				// ex) 액티비티 (회원가입) 회원의 정보들 (itent) -> 액티비티(로그인) -> itent
				// 묵시 ex) 액티비티 -> 외부 서비스(전화걸기 , naverWeb ....)
				Intent itt = new Intent(MainActivity.this, UserInf.class);
				// intent를 지금위치와 이동할 위치를 지정을하고 초기화.
//				itt.putExtra("test", "내용");
//				itt.putExtra("testint", 1);
				// intent에 key , value를 통해서 보내줄 데이터를 넣어둠.

				DTO dto = new DTO(edt_id.getText(), edit_pw.getText(), edit_name.getText(), edit_age.getText(),
						edit_addr.getText(), edt_id.getText());
//				DTO dto = new DTO("ID", "pw", "이름", 20, "집주소", "닉네임");
				// 객체를 생성해서 intent에 담음
				itt.putExtra("dto", dto);

				startActivity(itt);

			}
		});
	}
}