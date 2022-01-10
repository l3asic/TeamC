package com.example.newlastproject.customer;

import android.content.Context;

import com.example.newlastproject.async.AskParam;
import com.example.newlastproject.async.CommonAsk;
import com.example.newlastproject.async.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerDAO {
    CommonAsk service ;
    Context context;
    Gson gson = new Gson();
    public ArrayList<CustomerVO> list(){
        service = new CommonAsk("list.cu");
        InputStream in = CommonMethod.excuteAsk(service);
        ArrayList<CustomerVO> list  = new ArrayList<>();
        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<CustomerVO> >(){}.getType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
    public ArrayList<CustomerVO> list(String search){
        service = new CommonAsk("list.cu");
        service.params.add(new AskParam("search" , search));
        InputStream in = CommonMethod.excuteAsk(service);
        ArrayList<CustomerVO> list  = new ArrayList<>();
        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<CustomerVO> >(){}.getType());
        }catch (Exception e){
          e.printStackTrace();
        }
        return  list;
    }
    public void delete(String id){
        service = new CommonAsk("delete.cu");
        service.params.add(new AskParam("id", id));
        CommonMethod.excuteAsk(service);
    }

    public void edit(CustomerVO vo) {
        String str = gson.toJson(vo);
        service = new CommonAsk("update.cu");
        service.params.add(new AskParam("vo",str));
        CommonMethod.excuteAsk(service);
        //CustomerVO vott = gson.fromJson(dto,CustomerVO.class);
    }

    //DAO , COMMON 공통으로 사용할 클래스로 이동.
    public String rtnString(InputStream inputStream)  {
        try{


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while( (line = reader.readLine()) != null  ){
                stringBuilder.append( line + "\n");
            }

            return stringBuilder.toString();
        }catch (IOException e){

        }
        return "";
    }
}
