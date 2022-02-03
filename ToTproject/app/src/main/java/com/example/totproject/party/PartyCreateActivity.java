package com.example.totproject.party;

import android.app.Activity;
import android.os.Bundle;

import com.example.totproject.R;

public class PartyCreateActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_act_createparty);
        OpenpartyListFragment openparty_list_frag = new OpenpartyListFragment();




    }
}
