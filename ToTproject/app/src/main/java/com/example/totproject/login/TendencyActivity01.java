package com.example.totproject.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.totproject.R;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.KakaoMapActivity;
import com.example.totproject.common.kwkCommonAsk;
import com.example.totproject.main.MainActivity;
import com.google.gson.Gson;

import net.daum.mf.map.api.MapPoint;

import java.io.InputStream;

public class TendencyActivity01 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup mbti_tour, mbti_activity, mbti_festival, mbti_solo, mbti_couple;
    RadioButton mbti_tour_rad1, mbti_tour_rad2, mbti_tour_rad3, mbti_tour_rad4, mbti_tour_rad5, mbti_activity_rad1, mbti_activity_rad2, mbti_activity_rad3, mbti_activity_rad4, mbti_activity_rad5, mbti_festival_rad1, mbti_festival_rad2, mbti_festival_rad3, mbti_festival_rad4, mbti_festival_rad5, mbti_solo_rad1, mbti_solo_rad2, mbti_solo_rad3, mbti_solo_rad4, mbti_solo_rad5, mbti_couple_rad1, mbti_couple_rad2, mbti_couple_rad3, mbti_couple_rad4, mbti_couple_rad5;

    Button tend_btn_skip, tend_btn_next;
    TendDTO dto = new TendDTO();

    double lac=0;
    double loc=0;

    public final int MAP_REQ = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendency_activity_01);
        Toast.makeText(this, "성향입력시 위치정보가 저장됩니다.", Toast.LENGTH_SHORT).show();

        // 위치 권한 설정
        checkDangerousPermissions();
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);     //GPS 사용?
        
        // 위치 권한 확인
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location =  manager.getLastKnownLocation(LocationManager.GPS_PROVIDER) == null ? manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) : manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)  ;
        lac = location.getLatitude();   // 위도 저장
        loc = location.getLongitude();  // 경도 저장




        mbti_tour = findViewById(R.id.mbti_tour);
        mbti_activity = findViewById(R.id.mbti_activity);
        mbti_festival = findViewById(R.id.mbti_festival);
        mbti_solo = findViewById(R.id.mbti_solo);
        mbti_couple = findViewById(R.id.mbti_couple);

        mbti_tour_rad1 = findViewById(R.id.mbti_tour_rad1);
        mbti_tour_rad2 = findViewById(R.id.mbti_tour_rad2);
        mbti_tour_rad3 = findViewById(R.id.mbti_tour_rad3);
        mbti_tour_rad4 = findViewById(R.id.mbti_tour_rad4);
        mbti_tour_rad5 = findViewById(R.id.mbti_tour_rad5);
        mbti_tour_rad1.setTag(1);
        mbti_tour_rad2.setTag(2);
        mbti_tour_rad3.setTag(3);
        mbti_tour_rad4.setTag(4);
        mbti_tour_rad5.setTag(5);

        mbti_activity_rad1 = findViewById(R.id.mbti_activity_rad1);
        mbti_activity_rad2 = findViewById(R.id.mbti_activity_rad2);
        mbti_activity_rad3 = findViewById(R.id.mbti_activity_rad3);
        mbti_activity_rad4 = findViewById(R.id.mbti_activity_rad4);
        mbti_activity_rad5 = findViewById(R.id.mbti_activity_rad5);
        mbti_activity_rad1.setTag(1);
        mbti_activity_rad2.setTag(2);
        mbti_activity_rad3.setTag(3);
        mbti_activity_rad4.setTag(4);
        mbti_activity_rad5.setTag(5);

        mbti_festival_rad1 = findViewById(R.id.mbti_festival_rad1);
        mbti_festival_rad2 = findViewById(R.id.mbti_festival_rad2);
        mbti_festival_rad3 = findViewById(R.id.mbti_festival_rad3);
        mbti_festival_rad4 = findViewById(R.id.mbti_festival_rad4);
        mbti_festival_rad5 = findViewById(R.id.mbti_festival_rad5);
        mbti_festival_rad1.setTag(1);
        mbti_festival_rad2.setTag(2);
        mbti_festival_rad3.setTag(3);
        mbti_festival_rad4.setTag(4);
        mbti_festival_rad5.setTag(5);

        mbti_solo_rad1 = findViewById(R.id.mbti_solo_rad1);
        mbti_solo_rad2 = findViewById(R.id.mbti_solo_rad2);
        mbti_solo_rad3 = findViewById(R.id.mbti_solo_rad3);
        mbti_solo_rad4 = findViewById(R.id.mbti_solo_rad4);
        mbti_solo_rad5 = findViewById(R.id.mbti_solo_rad5);
        mbti_solo_rad1.setTag(1);
        mbti_solo_rad2.setTag(2);
        mbti_solo_rad3.setTag(3);
        mbti_solo_rad4.setTag(4);
        mbti_solo_rad5.setTag(5);

        mbti_couple_rad1 = findViewById(R.id.mbti_couple_rad1);
        mbti_couple_rad2 = findViewById(R.id.mbti_couple_rad2);
        mbti_couple_rad3 = findViewById(R.id.mbti_couple_rad3);
        mbti_couple_rad4 = findViewById(R.id.mbti_couple_rad4);
        mbti_couple_rad5 = findViewById(R.id.mbti_couple_rad5);
        mbti_couple_rad1.setTag(1);
        mbti_couple_rad2.setTag(2);
        mbti_couple_rad3.setTag(3);
        mbti_couple_rad4.setTag(4);
        mbti_couple_rad5.setTag(5);

        tend_btn_skip = findViewById(R.id.tend_btn_skip);
        tend_btn_next = findViewById(R.id.tend_btn_next);


        mbti_tour.setOnCheckedChangeListener(this);
        mbti_activity.setOnCheckedChangeListener(this);
        mbti_festival.setOnCheckedChangeListener(this);
        mbti_solo.setOnCheckedChangeListener(this);
        mbti_couple.setOnCheckedChangeListener(this);

        tend_btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity01.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tend_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TendencyActivity01.this, TendencyActivity02.class);
                dto.setMbti_x(lac);
                dto.setMbti_y(loc);
                intent.putExtra("TendDTO", dto);
                startActivity(intent);
                finish();
            }
        });







    }// oncreate()








    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton rdo_btn = findViewById(radioGroup.getCheckedRadioButtonId());

        if (radioGroup.getId() == R.id.mbti_tour) {
            dto.setMbti_tour((Integer) rdo_btn.getTag());
            Toast.makeText(TendencyActivity01.this, rdo_btn.getTag() + "", Toast.LENGTH_SHORT).show();
        } else if (radioGroup.getId() == R.id.mbti_activity) {
            dto.setMbti_activity((Integer) rdo_btn.getTag());
            Toast.makeText(TendencyActivity01.this, rdo_btn.getTag() + "", Toast.LENGTH_SHORT).show();
        } else if (radioGroup.getId() == R.id.mbti_festival) {
            dto.setMbti_festival((Integer) rdo_btn.getTag());
            Toast.makeText(TendencyActivity01.this, rdo_btn.getTag() + "", Toast.LENGTH_SHORT).show();
        } else if (radioGroup.getId() == R.id.mbti_solo) {
            dto.setMbti_solo((Integer) rdo_btn.getTag());
            Toast.makeText(TendencyActivity01.this, rdo_btn.getTag() + "", Toast.LENGTH_SHORT).show();
        } else if (radioGroup.getId() == R.id.mbti_couple) {
            dto.setMbti_couple((Integer) rdo_btn.getTag());
            Toast.makeText(TendencyActivity01.this, rdo_btn.getTag() + "", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}



