package com.example.totproject.common;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.totproject.main.MainActivity;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class CommonMethod {
    static InputStream in = null;
    public static InputStream excuteAsk(AsyncTask<String,String,InputStream> ask){


        try {
            in = ask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return in;
    }

    // 메인 액티비티로 이동
    public static void goMain(Context context){
        Intent intent = new Intent(context , MainActivity.class);
        context.startActivity(intent);
    }//goMain()






}
