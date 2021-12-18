package com.example.test_account.conn;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestConn extends AsyncTask<String,String,String> {
    String getData;
    String name;
    private static final String TAG = "common";
    HttpClient httpClient;//접속을 위한객체
    HttpPost httpPost; //url을 담을 객체
    MultipartEntityBuilder builder;//파라메터,파일 등등을 보내기위한 객체
    final String HTTPIP = "http://192.168.0.35";//IP
    final String SVRPATH = "/01.Middle/"; //
    private String postUrl ;
    private String mapping;




    public TestConn(String mapping, String getData, String name) { //name:식별값
        this.name = name;
        this.getData = getData;
        this.mapping = mapping;
    }

    @Override
    protected String doInBackground(String... strings) {
        //반복되는 소스가 어디서부터 어디까지 생기고
        //어떻게하면 줄일수있을까?
        //무조건 InputStream으로 무조건 return을 받음.

        postUrl = HTTPIP + SVRPATH + mapping;
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        ///===========================================
        builder.addTextBody(name , getData ,
                ContentType.create("Multipart/related" , "UTF-8"));
        //==================================================
        httpClient = AndroidHttpClient.newInstance("Android");
        //conn , ps<-// ps( sql ) , ps.setInt , ps.setString
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());//파라메터를 추가할수있는부분.
        InputStream in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(in != null){

        }
        return null;
    }
}

