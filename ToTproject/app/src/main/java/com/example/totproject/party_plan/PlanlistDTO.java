package com.example.totproject.party_plan;

public class PlanlistDTO {
    private int picture_filepath;
    private String writer;
    private String plan_name;
    private String date;
    private String time;

    public PlanlistDTO(int picture_filepath, String writer, String plan_name, String date, String time) {
        this.picture_filepath = picture_filepath;
        this.writer = writer;
        this.plan_name = plan_name;
        this.date = date;
        this.time = time;
    }

    public int getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(int picture_filepath) {
        this.picture_filepath = picture_filepath;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
