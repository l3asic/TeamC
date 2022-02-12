package com.example.totproject.common;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;


import com.example.totproject.main.MainActivity;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class CommonMethod {
    static InputStream in = null;
    public static InputStream excuteAsk(   AsyncTask<String,String,InputStream> ask){


        try {
            in = ask.execute().get(); //집에서하면 항상 여기서고장남
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return in;
    }







}
