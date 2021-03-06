package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.login.TendencyActivity;
import com.example.totproject.party.PartyCreateActivity;
import com.example.totproject.party.PartyMainActivity;
import com.example.totproject.whosepageactivity.WhosePage00Activity;
import com.example.totproject.R;
import com.example.totproject.common.VO.MemberDTO;
import com.example.totproject.common.statics.Logined;
import com.example.totproject.login.JoinActivity;
import com.example.totproject.login.LoginActivity;
import com.example.totproject.login.SplashActivity;
import com.example.totproject.login.TendencyActivity01;
import com.example.totproject.mainburgeractivity.MainBurger00Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //https://salix97.tistory.com/72
  //  BottomNavigationView bottom_nav;
    BottomNavigationBar bottom_nav;
    int main_container;
    Button main_btn_burger;
    Toolbar toolbar;
    ImageView cancel;
    ImageView main_burger_imgv_circle;  // ???????????? ??????
   // TextView main_tv_acttitle;
   FloatingNavigationView nav_view;
    LinearLayout afterLogin, main_burger_myboard, main_burger_myscrap, main_burger_myparty;
    FragmentManager manager = getSupportFragmentManager();
    String[] mainColors = {

            "#2BA0DA",
            "#885CD0",
            "#FF2E841B",
            "#232344",
            "#551122"
    };
    public int reqGcode = 1004;

    CommonAsk commonAsk;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getHashKey();
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setTitle("?????? ??????");
        setSupportActionBar(toolbar);

        main_container = R.id.main_container;
        Fragment01HomeTab mainTab_frag = new Fragment01HomeTab(MainActivity.this, manager);
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab(MainActivity.this, manager);
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();
        Fragment05IotTab iotTab_frag = new Fragment05IotTab();
        Fragment00Empty empty_frag = new Fragment00Empty();
        //  getSupportFragmentManager().beginTransaction().replace(R.id.main_container, mainTab_frag).commit();
        /* =================================== ???????????? =================================== */
       // main_tv_acttitle = findViewById(R.id.main_tv_acttitle);
        ChangeFrament(main_container, mainTab_frag, "?????? ??????");




        /* ================================= ???????????? findView ================================= */
        nav_view = findViewById(R.id.main_burger_view);
        nav_view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mainColors[0])));
        View nav_headerview = nav_view.getHeaderView(0);
        nav_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav_view.open();
            }
        });
        /* ===================================================================================== */

        // ???????????? ????????????-==========================================================
        bottom_nav = findViewById(R.id.main_nav);
        bottom_nav.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if (position == 0) {
                    ChangeFrament(main_container, mainTab_frag, "?????? ??????");
                } else if (position == 1) {
                    ChangeFrament(main_container, categoryTab_frag, "????????? ??????");

                } else if (position == 2) {
                    ChangeFrament(main_container, boardTab_frag, "???????????????");
                } else if (position == 3) {
                    ChangeFrament(main_container, partyTab_frag, "??????");
                } else if (position == 4) {
                    ChangeFrament(main_container, iotTab_frag, "????????? ??????");
                }
                toolbar.setBackgroundColor(Color.parseColor(mainColors[position]));
                nav_view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mainColors[position])));
                getWindow().setStatusBarColor(Color.parseColor(mainColors[position]));

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        bottom_nav.addItem(new BottomNavigationItem(R.drawable.icon_home,"Home").setActiveColor(mainColors[0]));
        bottom_nav.addItem(new BottomNavigationItem(R.drawable.icon_category,"Category").setActiveColor(Color.parseColor(mainColors[1])));
        bottom_nav.addItem(new BottomNavigationItem(R.drawable.icon_board,"Board").setActiveColor(Color.parseColor(mainColors[2])));
        bottom_nav.addItem(new BottomNavigationItem(R.drawable.icon_party,"Party").setActiveColor(Color.parseColor(mainColors[3])));
        bottom_nav.addItem(new BottomNavigationItem(R.drawable.icon_iot_bag,"IoT").setActiveColor(Color.parseColor(mainColors[4])));
        bottom_nav.initialise();
        bottom_nav.setFirstSelectedPosition(0);
        bottom_nav.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        //============================================

        /* ================================================================================ */

        /* =================================== ???????????? ?????? ================================================ */

          //   DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);

     //   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
      //          this, drawer, toolbar,
      //          R.string.navigation_drawer_open,
       //         R.string.navigation_drawer_close
      //  );
      //  drawer.addDrawerListener(toggle);
        /* =================================================================================================== */



        /* ====================================================================== */

        /* ========================= ???????????? ????????? ========================= */

        /* ==================================================================================== */


        /* ============================== ???????????? ?????? ========================================= */
        /* ========== ???????????? ===================================================== = ========== */
        LinearLayout main_burger_mbti;
        TextView main_burger_tv_logout = nav_headerview.findViewById(R.id.main_burger_tv_logout);


        // ???????????? ?????? ?????????
        main_burger_tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                SharedPreferences.Editor spEditor = auto.edit();
                spEditor.clear();
                spEditor.commit();
                goSplash();
            }
        });

        // mbti ?????? ??????????????? ??????
        main_burger_mbti = nav_headerview.findViewById(R.id.main_burger_mbti);
        if (Logined.member_id == null) {
            main_burger_mbti.setVisibility(View.GONE);
        }
        main_burger_mbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivity(TendencyActivity.class);
            }
        });




        main_burger_imgv_circle= nav_headerview.findViewById(R.id.main_burger_imgv_circle);

        if (Logined.picture_filepath != null) {
            Glide.with(MainActivity.this).load(Logined.picture_filepath).into(main_burger_imgv_circle);
            //Glide.with(context).load(list.get(position).getPicture_filepath()).into(board_user_reply_img_profile);
        }else {
            Glide.with(MainActivity.this).load(R.drawable.logo_tot).into(main_burger_imgv_circle);
        }
        /* ========== = ===================================================== ???????????? ========== */

        main_burger_imgv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDangerousPermissions();
                Intent imageIntent = new Intent();
                imageIntent.setType("image/*");
                imageIntent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(imageIntent,"????????? ??? ??????"), reqGcode);

            }
        });
        //android:visibility="invisible"


        main_burger_myboard = nav_headerview.findViewById(R.id.main_burger_myboard);
        main_burger_myscrap = nav_headerview.findViewById(R.id.main_burger_myscrap);
        main_burger_myparty = nav_headerview.findViewById(R.id.main_burger_myparty);

        main_burger_myboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWhosePage(1);
                 toastCheck();
            }
        });
        main_burger_myscrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWhosePage(2);
                 toastCheck();
            }
        });
        main_burger_myparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, PartyMainActivity.class);
                 intent.putExtra("tabcode",3);
                 startActivity(intent);
            }
        });


        TextView main_burger_tv_login = nav_headerview.findViewById(R.id.main_burger_tv_login);
        if (Logined.isLogined == true) { //???????????? ??? ????????????
            // main_burger_tv_login.setText("??????????????????.???????????????");
            main_burger_tv_login.setText(Logined.member_id);
        }


        main_burger_tv_login.setOnClickListener(new View.OnClickListener() {    // ????????? ???????????????
            @Override
            public void onClick(View v) {
                if (Logined.isLogined != true) {    // ????????? ????????? ???????????? ?????? ????????????
                    /* =================================== ????????????????????? =================== */
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else { //????????? ??? ????????????
                    /* =================================== ?????????????????? ??????? =================== */
                }

            }
        });

        TextView main_burger_tv_join = nav_headerview.findViewById(R.id.main_burger_tv_join);

        main_burger_tv_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
                finish();
            }
        });
        afterLogin = nav_headerview.findViewById(R.id.main_burger_afterlogin);
        if(Logined.isLogined==true){    //????????? ?????????
            /* =================================== ??????4???on ????????????off ????????????on =================== */
            afterLogin.setVisibility(View.VISIBLE);
            main_burger_tv_join.setVisibility(View.GONE);
            main_burger_tv_logout.setVisibility(View.VISIBLE);
        }else{  //
            /* =================================== ????????????????????? =================== */

        }
        /* ===================================================================================== */


        /* =================================== ???????????? =================================== */
        Menu nav_menu = nav_view.getMenu();
        FloatingNavigationView bottom_nav2;
        bottom_nav2 = findViewById(R.id.main_burger_view);
        bottom_nav2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                int id = item.getItemId();
                String tabText = (String) item.getTitle();
                String title = item.getTitle().toString();
                if (id == R.id.mainnav_notice) {
                    ChangeActivity(MainBurger00Activity.class, 1, tabText);
                } else if (id == R.id.mainnav_customer) {
                    ChangeActivity(MainBurger00Activity.class, 2, tabText);
                } else if (id == R.id.mainnav_policy) {
                    ChangeActivity(MainBurger00Activity.class, 3, tabText);
                } else if (id == R.id.mainnav_version) {
                    Date date = new Date();
                    Toast.makeText(MainActivity.this, "???????????? ?????? : " + date, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        /* ================================================================================ */


    }//onCreate()


    /* =================================== ????????? ======================= */


    // ?????? ?????? ?????????
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1004){
            Toast.makeText(MainActivity.this, "????????? ???????????? ??????.", Toast.LENGTH_SHORT).show();
            Uri galleryUri = data.getData();
            Logined.picture_filepath = getPathFromURI(galleryUri);
            changeUserPic();
            Glide.with(MainActivity.this).load(galleryUri).into(main_burger_imgv_circle);

        }
    }

    // ?????? ?????? ??????
    private void changeUserPic() {
        commonAsk = new CommonAsk("android/cmh/changeUserPic");
        commonAsk.params.add(new CommonAskParam("member_id",Logined.member_id));
        commonAsk.fileParams.add(new CommonAskParam("picture_filepath",Logined.picture_filepath));

        InputStream in = CommonMethod.excuteAsk(commonAsk);


    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cusor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cusor.moveToFirst()) {
            int column_index = cusor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cusor.getString(column_index);
        }
        return res;
    }



    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "?????? ??????", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "?????? ??????", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "?????? ?????? ?????????.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);   //????????? ????????? ???????????????
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " ????????? ?????????.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " ????????? ???????????? ??????.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }





    /* =================================== ?????? ??????????????? =================================== */
    public void titleTextChange(TextView textView, String titleText) {
        textView.setText(titleText);
    }

    /* =================================== view?????? + ??????????????? ?????? ===========-------======================== */
    public void ChangeFrament(int container, Fragment fragment, String titleText) {
        getSupportFragmentManager().beginTransaction().replace(container,fragment).addToBackStack(null).commit();
        toolbar.setTitle(titleText);

    }

    public void ChangeActivity(Class nextAct, int tabcode) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode", tabcode);
        // intent.putExtra("tabText",tabText);
        startActivity(intent);
        finish();
    }

    public void ChangeActivity(Class nextAct, int tabcode, String tabText) {
        Intent intent = new Intent(MainActivity.this, nextAct);
        intent.putExtra("tabcode", tabcode);
        intent.putExtra("tabText", tabText);
        startActivity(intent);
        finish();
    }

    public void ChangeActivity(Class nextClass) {
        Intent intent = new Intent(MainActivity.this, nextClass);
        startActivity(intent);
        finish();
    }

    public void goSplash() {
        Intent intent = new Intent(MainActivity.this, SplashActivity.class);

        startActivity(intent);
        finish();
    }

    /* ============================== ???????????? ???????????? ?????? ============---================== */
    private long backKeyPressedTime = 0;

    @Override
    public void onBackPressed() {
        if (nav_view.isOpened()) {
            nav_view.close();
        } else {

            Object ac = getSupportFragmentManager().getFragments().get(0).getClass();
            if (ac.equals(Fragment01HomeTab.class) || ac.equals(Fragment02CategoryTab.class) ||
                    ac.equals(Fragment03BoardTab.class) || ac.equals(Fragment04PartyTab.class) || ac.equals(Fragment05IotTab.class)) {
                if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                    backKeyPressedTime = System.currentTimeMillis();
                    Toast.makeText(this, "\'??????\' ????????? ?????? ??? ???????????? ???????????????.", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                    finish();
                }
            } else {
                manager.popBackStack();
            }
        }
    }
    /* ======================================================================== */

    public void goWhosePage(int tabCode){
    Intent intent = new Intent(MainActivity.this, WhosePage00Activity.class);
    intent.putExtra("tabCode",tabCode);
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMember_id(Logined.member_id);
        memberDTO.setPicture_filepath(Logined.picture_filepath);
    intent.putExtra("memberDTO",memberDTO);
    startActivity(intent);}

    public void toastCheck(){
        Toast.makeText(this, "toastCheck", Toast.LENGTH_SHORT).show();
    }
    public void toastCheck(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }



}