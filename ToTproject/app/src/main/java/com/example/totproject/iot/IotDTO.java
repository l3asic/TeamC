package com.example.totproject.iot;

import java.io.Serializable;

public class IotDTO implements Serializable {

    String member_id;
    double iot_x, iot_y;
    String iot_day, iot_time;
    int iot_onoff;

    public IotDTO(String member_id, double iot_x, double iot_y, String iot_day, String iot_time, int iot_onoff) {
        this.member_id = member_id;
        this.iot_x = iot_x;
        this.iot_y = iot_y;
        this.iot_day = iot_day;
        this.iot_time = iot_time;
        this.iot_onoff = iot_onoff;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public double getIot_x() {
        return iot_x;
    }

    public void setIot_x(double iot_x) {
        this.iot_x = iot_x;
    }

    public double getIot_y() {
        return iot_y;
    }

    public void setIot_y(double iot_y) {
        this.iot_y = iot_y;
    }

    public String getIot_day() {
        return iot_day;
    }

    public void setIot_day(String iot_day) {
        this.iot_day = iot_day;
    }

    public String getIot_time() {
        return iot_time;
    }

    public void setIot_time(String iot_time) {
        this.iot_time = iot_time;
    }

    public int getIot_onoff() {
        return iot_onoff;
    }

    public void setIot_onoff(int iot_onoff) {
        this.iot_onoff = iot_onoff;
    }
}

