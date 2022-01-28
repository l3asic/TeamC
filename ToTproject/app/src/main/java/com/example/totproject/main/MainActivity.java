package com.example.totproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.totproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_nav;
    int container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_main);

        bottom_nav = findViewById(R.id.main_nav);
        container = R.id.container;
        Fragment01MainTab mainTab_frag = new Fragment01MainTab();
        Fragment02CategoryTab categoryTab_frag = new Fragment02CategoryTab();
        Fragment03BoardTab boardTab_frag = new Fragment03BoardTab();
        Fragment04PartyTab partyTab_frag = new Fragment04PartyTab();





        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.bot_home){
                    ChangeFrament(container, mainTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_category){
                    ChangeFrament(container, categoryTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_board) {
                    ChangeFrament(container, boardTab_frag);
                    return true;
                }else if(item.getItemId() == R.id.bot_party) {
                    ChangeFrament(container, partyTab_frag);
                    return true;
                }
                //One day we have to make that the IotTab@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //fking i can't typing Korean;;;


                return false;
            }
        });




    }//onCreate()

    public void ChangeFrament(int container, Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
    }

}