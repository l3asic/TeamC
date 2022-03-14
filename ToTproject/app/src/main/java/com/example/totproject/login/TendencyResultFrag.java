package com.example.totproject.login;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonAskParam;
import com.example.totproject.common.CommonMethod;
import com.example.totproject.common.statics.Logined;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class TendencyResultFrag extends Fragment {
    private RadarChart radarChart;

    String[] labels = new String[10];
    TendDTO dto ;
    String[] mbtiString = new String[5];
    String[] mbtiStringva = new String[6];
    ImageView tendency_imgv;
    TextView tendency_tv , tendencyname_tv;
    int imgv_res;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_tendency_result, container, false);
        radarChart =  rootView.findViewById(R.id.mapsearchdetail_radar_chart);
        tendency_imgv =  rootView.findViewById(R.id.tendency_imgv);
        tendency_tv =  rootView.findViewById(R.id.tendency_tv);
        tendencyname_tv =  rootView.findViewById(R.id.tendencyname_tv);

        dto = selectTend();
        setMbtiString1(dto.getMbti_activity() ,dto.getMbti_festival() , dto.getMbti_tour());
        setMbtiString2(dto.getMbti_solo() ,dto.getMbti_couple() , dto.getMbti_buddys() , dto.getMbti_family());

        makeChart();
        tendencyname_tv.setText("나의 성향은 ? "  + mbtiStringva[5] + "\n\n\n");
        tendency_imgv.setImageResource(imgv_res);
        for (int i = 0 ; i< mbtiString.length; i ++){
            tendencyname_tv.append( mbtiString[i] + "");
        }
        tendency_tv.append("\n");
        for (int i = 0 ; i< mbtiStringva.length-1; i ++){
            tendency_tv.append( mbtiString[i] + " : " + mbtiStringva[i] + "");
        }
        rootView.findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(0);
            }
        });
        return rootView;
    }
    void setMbtiString2( int data1 , int data2, int data3, int data4) {
        if (data1 > data2 && data1 > data3 && data1 > data4) {
            mbtiString[1] = "S";
            mbtiStringva[1] = "혼자가 좋음#";
        } else if (data2 > data1 && data2 > data3 && data2 > data4) {
            mbtiString[1] = "C";
            mbtiStringva[1] = "연인이 좋음#";
        } else if (data3 > data1 && data3 > data2 && data3 > data4) {
            mbtiString[1] = "D";
            mbtiStringva[1] = "친구들이 좋음# ";
        } else if (data4 > data1 && data4 > data2 && data4 > data3) {
            mbtiString[1] = "F";
            mbtiStringva[1] = "단체가 좋음#";
        } else {
            mbtiStringva[1] = "인원은 상관 없음#";
            mbtiString[1] = "N";
        }
    }

    void setMbtiString1( int data1 , int data2, int data3){
        if(data1 > data2 && data1 > data3) {
            mbtiString[0] = "A";
            mbtiStringva[0] = "액티비티를 즐김#";
            mbtiStringva[5] = "목숨걸고 열기구를 타는 기린";
            imgv_res = R.drawable.tendencya;
        }
        else if(data2 > data1 && data2 > data3) {
            mbtiString[0] = "F";
            mbtiStringva[0] = " 축제를 즐김#";
            imgv_res = R.drawable.tendencyf;
            mbtiStringva[5] = "축제를 즐기는 여우";
        }
        else if(data3 > data1 && data3 > data2) {
            mbtiString[0] = "T";
            mbtiStringva[0] = " 관광을 즐김#";
            imgv_res = R.drawable.tendencyt;
            mbtiStringva[5] = "광관지를 즐기는 고양이";
        }
        else {
            mbtiString[0] = "N";
            mbtiStringva[0] = " 모든 여행을 즐김#";
            mbtiStringva[5] = "호불호 없는 달팽이";
            imgv_res = R.drawable.tendencyn;
        }
    }

    Gson gson = new Gson();
    public TendDTO selectTend(){

        CommonAsk commonAsk = new CommonAsk("tend_list");
        commonAsk.params.add(new CommonAskParam("member_id", Logined.member_id));
        InputStream in = CommonMethod.excuteAsk(commonAsk);
        try {

             dto   = gson.fromJson(new InputStreamReader(in), TendDTO.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private ArrayList<RadarEntry> dataTravel(){
        labels[0] = "액티비티";
        labels[1] = "축제";
        labels[2] = "관광";
        ArrayList<RadarEntry> dataVals = new ArrayList<>();


        dataVals.add(new RadarEntry(dto.getMbti_activity()));
        dataVals.add(new RadarEntry(dto.getMbti_festival()));
        dataVals.add(new RadarEntry(dto.getMbti_tour()));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        return  dataVals;
    }
    private ArrayList<RadarEntry> dataPeople(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        labels[3] = "1인여행";
        labels[4] = "커플여행";
        labels[5] = "2~3인여행";
        labels[6] = "단체 여행";

        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(dto.getMbti_solo()));
        dataVals.add(new RadarEntry(dto.getMbti_couple()));
        dataVals.add(new RadarEntry(dto.getMbti_buddys()));
        dataVals.add(new RadarEntry(dto.getMbti_family()));

        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));

        return  dataVals;
    }

    private ArrayList<RadarEntry> dataEtc(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));
        dataVals.add(new RadarEntry(0,""));

        String label = "";
        if(dto.getMbti_price() > 70){
            mbtiString[2]="R";
            label = "고비용 선호";
            mbtiStringva[2] = "돈 펑펑 씀#";
        }
        else if(dto.getMbti_price() == 70){
            mbtiString[2]="N";
            mbtiStringva[2] = "돈 적당히 씀#";
            label = "보통 선호";
        }
        else if(dto.getMbti_price() < 70){
            mbtiString[2]="P";
            mbtiStringva[2] = "돈 아껴 씀#";
            label = "저비용 선호";
        }
        dataVals.add(new RadarEntry(dto.getMbti_price(),label));
        labels[7] = label;


        if(dto.getMbti_sd() > 70) {
            label = "정적 여행 선호";
            mbtiStringva[3] = "정적 여행#";
            mbtiString[3]="S";
        }
        if(dto.getMbti_sd() == 70){
            label = "평범한 여행 선호";
            mbtiStringva[3] = "평범한 여행#";
            mbtiString[3]="N";
        }
        if(dto.getMbti_sd() < 70){
            label = "역동적인 여행 선호";
            mbtiStringva[3] = "역동적인 여행#";
            mbtiString[3]="D";
        }
        dataVals.add(new RadarEntry(dto.getMbti_sd(),label));
        labels[8] = label;


        if(dto.getMbti_io() > 70){
            label ="인도어 선호";
            mbtiStringva[4] = "인도어 여행#";
            mbtiString[4]="-I";
        }
        if(dto.getMbti_io() == 70){
            label ="상관없음 ";
            mbtiStringva[4] = " ";
            mbtiString[4]="-N";
        }
        if(dto.getMbti_io() < 70) {
            label ="아웃도어 선호";
            mbtiStringva[4] = "아웃도어 여행";
            mbtiString[4]="-O";
        }
        dataVals.add(new RadarEntry(dto.getMbti_io(),label));
        labels[9] = label;
        return  dataVals;
    }


    private void makeChart(){
        radarChart.animateXY(1400, 1400, Easing.EaseInOutQuad);
        radarChart.setWebColor(Color.LTGRAY);
        radarChart.setWebColorInner(Color.LTGRAY);
        radarChart.setWebAlpha(100);
        ArrayList<RadarDataSet> dataSetList = new ArrayList<>();
        dataSetList.add(  new RadarDataSet(dataTravel(), "여행 성향"));
        dataSetList.add(  new RadarDataSet(dataPeople(), "여행 인원 선호도"));
        dataSetList.add(  new RadarDataSet(dataEtc(), "여행 성격"));

        RadarData data = new RadarData();
        for(int i= 0 ; i < dataSetList.size() ; i ++){

            int colors = 0;
            if(i==0) colors = Color.BLUE;
            if(i==1) colors = Color.YELLOW;
            if(i==2) colors = Color.GREEN;
            dataSetList.get(i).setColor(colors);
            dataSetList.get(i).setFillColor(colors);
            dataSetList.get(i).setDrawFilled(true);
            dataSetList.get(i).setFillAlpha(70);
            dataSetList.get(i).setLineWidth(2f);
            dataSetList.get(i).setValueTextSize(10f);
            dataSetList.get(i).setValueTextColor(Color.BLACK );
            dataSetList.get(i).setDrawHighlightCircleEnabled(true);
            dataSetList.get(i).setDrawHighlightIndicators(false);
            data.addDataSet(dataSetList.get(i));

        }


        XAxis xAxis = radarChart.getXAxis();
        xAxis.setTextSize(10f);
        xAxis.setYOffset(6f);
        xAxis.setXOffset(6f);
        xAxis.setAxisMaxValue(80);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        xAxis.setAxisMaxValue(100);
        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMaximum(100);
        yAxis.setAxisMaxValue(80);
        yAxis.setTextSize(0f);

        Legend l = radarChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setTextSize(20f);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.BLACK);
        radarChart.setWebColorInner(Color.BLACK);
        radarChart.setWebColor(Color.BLACK);
        radarChart.setWebLineWidth(2f);
        radarChart.setData(data);
        radarChart.getData().setHighlightEnabled(true);
        Description description = new Description();
        description.setText(" ");
        radarChart.setDescription(description);
        radarChart.invalidate();

    }
    void changeFragment(int frag){
        TendencyActivity activity = (TendencyActivity) getActivity();
        activity.changeFragment(frag);
    }

}