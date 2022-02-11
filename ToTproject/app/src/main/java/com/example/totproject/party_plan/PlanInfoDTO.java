package com.example.totproject.party_plan;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanInfoDTO implements Serializable {

    private String plandetail_date;
    private String plandetail_time;
    private int plan_sn;
    private String plandetail_content;
    private String plandetail_content_detail;
    private ArrayList<String> subList ;

    public ArrayList<String> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<String> subList) {
        this.subList = subList;
    }

    public PlanInfoDTO(String plandetail_date, String plandetail_time, int plan_sn, String plandetail_content, String plandetail_content_detail) {
        this.plandetail_date = plandetail_date;
        this.plandetail_time = plandetail_time;
        this.plan_sn = plan_sn;
        this.plandetail_content = plandetail_content;
        this.plandetail_content_detail = plandetail_content_detail;
    }

    public String getPlandetail_date() {
        return plandetail_date;
    }

    public void setPlandetail_date(String plandetail_date) {
        this.plandetail_date = plandetail_date;
    }

    public String getPlandetail_time() {
        return plandetail_time;
    }

    public void setPlandetail_time(String plandetail_time) {
        this.plandetail_time = plandetail_time;
    }

    public int getPlan_sn() {
        return plan_sn;
    }

    public void setPlan_sn(int plan_sn) {
        this.plan_sn = plan_sn;
    }

    public String getPlandetail_content() {
        return plandetail_content;
    }

    public void setPlandetail_content(String plandetail_content) {
        this.plandetail_content = plandetail_content;
    }

    public String getPlandetail_content_detail() {
        return plandetail_content_detail;
    }

    public void setPlandetail_content_detail(String plandetail_content_detail) {
        this.plandetail_content_detail = plandetail_content_detail;
    }
}