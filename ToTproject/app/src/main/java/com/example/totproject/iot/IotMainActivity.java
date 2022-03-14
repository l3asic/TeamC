package com.example.totproject.iot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.party.PartyListDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IotMainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 3;
    public BluetoothAdapter mBluetoothAdapter = null;
    Set<BluetoothDevice> bluetooth_device;
    int mPairedDeviceCount;
    BluetoothDevice mRemoteDevice;
    BluetoothSocket mSocket;
    InputStream mInputStream;
    OutputStream mOutputStream;
    Thread mWorkerThread;
    int readBufferPositon;      //버퍼 내 수신 문자 저장 위치
    byte[] readBuffer;      //수신 버퍼
    byte mDelimiter = 10;

    IntentFilter stateFilter;
    // 연결되었는가
    int isConnect = 0;
    int isContinue = 0;
    int connCount = 0;
    // 일정시간마다 실행
    CountDownTimer CDT;

    TextView textView;
    ImageView imgv_iot_bticon, imgv_iot_onoff;
    LinearLayout lin_iot_back, lin_iot_onoff, lin_iot_beep, lin_iot_detail;

    // 켜져있는 상태인지 꺼져있는 상태인지 0꺼짐, 1 켜짐
    public static int on_off = -1;


    // 위경도
    double loc, lac;

    // 날짜, 시간
    String get_day, get_time;

    // 디비 연결용
    CommonAsk commonAsk;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iot_act_main);

        lin_iot_back = findViewById(R.id.lin_iot_back);
        lin_iot_onoff = findViewById(R.id.lin_iot_onoff);
        imgv_iot_onoff = findViewById(R.id.imgv_iot_onoff);
        lin_iot_beep = findViewById(R.id.lin_iot_beep);
        lin_iot_detail = findViewById(R.id.lin_iot_detail);




        // 현상태 체크하고 세팅
        checkIoT();
        if(on_off == 1){
            imgv_iot_onoff.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2BA0DA")));
        }else if(on_off == 0){
            imgv_iot_onoff.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#999999")));
        }
        lin_iot_detail.setVisibility(View.GONE);



        




        // 뒤로가기 버튼 클릭시
        lin_iot_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // @@ 세이프 모드 온 오프 버튼 클릭시
        lin_iot_onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //iotOnOffSet(); 이걸 왜 실행하지?

                // 켜져 있는 상태면 끄기
                if (on_off == 1){
                    on_off = 0;
                    iotOnOffSet();
                    Toast.makeText(IotMainActivity.this, "껐습니다.", Toast.LENGTH_SHORT).show();
                    imgv_iot_onoff.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#999999")));


                    return;
                    // 꺼져있는 상태면 켜기
                }else if(on_off == 0){
                    on_off = 1;
                    iotOnOffSet();
                    Toast.makeText(IotMainActivity.this, "켰습니다.", Toast.LENGTH_SHORT).show();
                    imgv_iot_onoff.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2BA0DA")));
                    return;
                    // 둘다 아니라면
                }else{
                    Toast.makeText(IotMainActivity.this, "작동불가 값 없거나 실패", Toast.LENGTH_SHORT).show();
                    imgv_iot_onoff.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#999999")));
                    return;

                }


            }
        });

        // @@@@소리신호 보내기
        lin_iot_beep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IotMainActivity.this, "소리 신호 보냄 임시", Toast.LENGTH_SHORT).show();
            }
        });





        // 블루투스 영역

        // On 상태라면 동작?
        if(on_off == 1){
            checkDangerousPermissions();
            textView = findViewById(R.id.textView);
            imgv_iot_bticon = findViewById(R.id.imgv_iot_bticon);
            bluetooth_device = new HashSet<>();

            // 리시버 등록
            regiserRec();

            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();   //블루투스 adapter 획득
            boolean isStart = mBluetoothAdapter.startDiscovery(); //블루투스 기기 검색 시작
            Log.d("main", "onCreate: isStart " + isStart);

            CDT = new CountDownTimer(60 * 1000, 15000) {
                public void onTick(long millisUntilFinished) {
                    //textView.append("시간안에 들어옴... : isConnect"+ isConnect + " => isContinue : " + isContinue + "\n");
                    connCount++;
                    if(connCount >= 3 && isContinue == 1){
                        isContinue = 0;
                        connCount = 0;
                    }
                    //반복실행할 구문
                    if(isConnect == 0 && isContinue == 0){
                        mBluetoothAdapter.startDiscovery(); //블루투스 기기 검색 시작
                        isContinue = 1;
                        textView.setText("블루투스 연결을 시도합니다...");
                    }

                }
                public void onFinish() {
                    //마지막에 실행할 구문
                    CDT.start();
                }
            }.start();
        }

        //CDT.start(); //CountDownTimer 실행
        //CDT.cancel();// 타이머 종료
    }   //oncreate()

    public void regiserRec(){
        stateFilter = new IntentFilter();
        stateFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED); //BluetoothAdapter.ACTION_STATE_CHANGED : 블루투스 상태변화 액션
        stateFilter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
        stateFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED); //연결 확인
        stateFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED); //연결 끊김 확인
        stateFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        stateFilter.addAction(BluetoothDevice.ACTION_FOUND);    //기기 검색됨
        stateFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);   //기기 검색 시작
        stateFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);  //기기 검색 종료
        stateFilter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
        registerReceiver(mBluetoothStateReceiver, stateFilter);
    }

    BroadcastReceiver mBluetoothStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();   //입력된 action
            //Toast.makeText(context, "받은 액션 : "+action , Toast.LENGTH_SHORT).show();
            //Log.d("Bluetooth action", action);
            //textView.append("받은 액션 : " + action + "\n" );
            final BluetoothDevice device =   intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String name = null;
            if (device != null) {
                name = device.getName();    //broadcast를 보낸 기기의 이름을 가져온다.
            }
            if(on_off == 1){
                switch (action){
                    case BluetoothAdapter.ACTION_STATE_CHANGED: //블루투스의 연결 상태 변경
                        final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                        switch(state) {
                            case BluetoothAdapter.STATE_OFF:

                                break;
                            case BluetoothAdapter.STATE_TURNING_OFF:

                                break;
                            case BluetoothAdapter.STATE_ON:

                                break;
                            case BluetoothAdapter.STATE_TURNING_ON:

                                break;
                        }

                        break;
                    case BluetoothDevice.ACTION_ACL_CONNECTED:  //블루투스 기기 연결
                        isConnect = 1;
                        Log.d("Bluetooth", "ACTION_ACL_CONNECTED");
                        textView.setText("블루투스 연결 됨" );
                        imgv_iot_bticon.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2BA0DA")));



                        // 사용자 위치 저장 영역
                        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);     //GPS 사용?

                        // 위치 권한 확인
                        if (ActivityCompat.checkSelfPermission(IotMainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(IotMainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        }
                        Location location =  manager.getLastKnownLocation(LocationManager.GPS_PROVIDER) == null ? manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) : manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)  ;
                        lac = location.getLatitude();   // 위도 저장
                        loc = location.getLongitude();  // 경도 저장

                        // 시간 저장 영역
                        get_day = getDayOrTime("yyyy-MM-dd");
                        get_time = getDayOrTime("hh:mm:ss");


                        // 시간, 위경도 디비 저장
                        IotDTO dto = new IotDTO(Logined.member_id, lac, loc, get_day, get_time,1);

                        saveIot(dto);








                        break;
                    case BluetoothDevice.ACTION_BOND_STATE_CHANGED:

                        break;
                    case BluetoothDevice.ACTION_ACL_DISCONNECTED:   //블루투스 기기 끊어짐
                        isConnect = 0;
                        Log.d("Bluetooth", "ACTION_ACL_DISCONNECTED");
                        textView.setText("블루투스 끊김" );
                        imgv_iot_bticon.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#999999")));

                        // 위치정보 보이게
                        lin_iot_detail.setVisibility(View.VISIBLE);

                        // 서버에 사용자 위치를 보내준다
                        // 서버에서는 받은 위치와 시간(서버 시간)를 데이터베이스에 저장한다

                        // 사용자 위치 저장 영역
//                    LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);     //GPS 사용?
//
//                    // 위치 권한 확인
//                    if (ActivityCompat.checkSelfPermission(IotMainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(IotMainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                        return;
//                    }
//                    Location location =  manager.getLastKnownLocation(LocationManager.GPS_PROVIDER) == null ? manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) : manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)  ;
//                    lac = location.getLatitude();   // 위도 저장
//                    loc = location.getLongitude();  // 경도 저장


                        break;

                    case BluetoothAdapter.ACTION_DISCOVERY_STARTED: //블루투스 기기 검색 시작

                        break;
                    case BluetoothDevice.ACTION_FOUND:  //블루투스 기기 검색 됨, 블루투스 기기가 근처에서 검색될 때마다 수행됨
                        String device_name = device.getName();
                        //textView.append("받은 액션 : " + "ACTION_FOUND : " + device_name + "\n" );
                        String device_Address = device.getAddress();
                        //textView.append("받은 액션 : " + "ACTION_FOUND : " + device_Address + "\n" );

                        //Log.d("Bluetooth Name: ", device_name);
                        //Log.d("Bluetooth Mac Address: ", device_Address);

                        //본 함수는 블루투스 기기 이름의 앞글자가 "hanul301"으로 시작하는 기기만을 검색하는 코드이다
                        if(device_name != null && device_name.length() > 2){
                            Log.d("Bluetooth Name: ", device_name);
                            Log.d("Bluetooth Mac Address: ", device_Address);
                            if(device_name.substring(0,3).equals("TOT")){
                                bluetooth_device.add(device);
                            }
                        }
                        break;
                    case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:    //블루투스 기기 검색 종료
                        Log.d("Bluetooth", "Call Discovery finished");
                        //textView.append("받은 액션 : " + "ACTION_DISCOVERY_FINISHED:: " + "\n" );

                        isContinue = 0;
                        StartBluetoothDeviceConnection();   //원하는 기기에 연결
                        break;
                    case BluetoothDevice.ACTION_PAIRING_REQUEST:

                        break;
                }
            }
            //입력된 action에 따라서 함수를 처리한다


        }
    };

    // 블루투스 연결 끊길시 디비에 정보 저장
    private void saveIot(IotDTO dto) {
        commonAsk = new CommonAsk("android/iot/saveIot");
        commonAsk.params.add(new CommonAskParam("dto",gson.toJson(dto)));
        CommonMethod.excuteAsk(commonAsk);
    }

    private String getDayOrTime(String pattern) {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        String get_temp = dateFormat.format(date);

        return get_temp;

    }

    public void StartBluetoothDeviceConnection() {
        //Bluetooth connection start
        if (bluetooth_device.size() == 0) {
            Toast.makeText(this, "There is no device", Toast.LENGTH_SHORT).show();
        }

        // 기기 이름을 선택한 경우 선택한 기기 이름과 같은 블루투스 객체를 찾아서 연결을 시도한다
        for (BluetoothDevice bt_device : bluetooth_device) {
            if (bt_device.getName().contains("TOT")) {
                Log.d("Bluetooth Connect", bt_device.getName());
                connectToSelectedDevice(bt_device);  //해당하는 블루투스 객체를 이용하여 연결 시도
                Log.d("Bluetooth Connect", "ConnectBluetoothDevice");
                break;
            }
        }


    }
    void connectToSelectedDevice(BluetoothDevice selectedDevice) {
        // BluetoothDevice 원격 블루투스 기기를 나타냄.
        mRemoteDevice = selectedDevice;
        // java.util.UUID.fromString : 자바에서 중복되지 않는 Unique 키 생성.
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

        try {
            // 소켓 생성, RFCOMM 채널을 통한 연결.
            // createRfcommSocketToServiceRecord(uuid) : 이 함수를 사용하여 원격 블루투스 장치와
            //                                           통신할 수 있는 소켓을 생성함.
            // 이 메소드가 성공하면 스마트폰과 페어링 된 디바이스간 통신 채널에 대응하는
            //  BluetoothSocket 오브젝트를 리턴함.
            mSocket = mRemoteDevice.createRfcommSocketToServiceRecord(uuid);
            mSocket.connect(); // 소켓이 생성 되면 connect() 함수를 호출함으로써 두기기의 연결은 완료된다.

            // 데이터 송수신을 위한 스트림 얻기.
            // BluetoothSocket 오브젝트는 두개의 Stream을 제공한다.
            // 1. 데이터를 보내기 위한 OutputStrem
            // 2. 데이터를 받기 위한 InputStream
            mOutputStream = mSocket.getOutputStream();
            mInputStream = mSocket.getInputStream();

            // 데이터 수신 준비.
            //beginListenForData();

        } catch (Exception e) { // 블루투스 연결 중 오류 발생
            Toast.makeText(getApplicationContext(),
                    "블루투스 연결 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
//            finish();  // App 종료
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        //regiserRec();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 리시버 해제
        //unregisterReceiver(mBluetoothStateReceiver);
    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
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


    // 기본 설정 체크
    private int checkIoT() {

        commonAsk = new CommonAsk("android/iot/checkIoT");
        commonAsk.params.add(new CommonAskParam("member_id", Logined.member_id));
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try {
            on_off = gson.fromJson(new InputStreamReader(in), new TypeToken<Integer>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return on_off;
    }


    // @@ IoT 켜고 끄기 용
    public int iotOnOffSet(){

        commonAsk = new CommonAsk("android/iot/iotOnOffSet");
        commonAsk.params.add(new CommonAskParam("member_id", Logined.member_id));
        commonAsk.params.add(new CommonAskParam("on_off", on_off+""));
        InputStream in = CommonMethod.excuteAsk(commonAsk);


        try {
            on_off = gson.fromJson(new InputStreamReader(in), new TypeToken<Integer>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return on_off;



    }//iotOnOffSet()



}