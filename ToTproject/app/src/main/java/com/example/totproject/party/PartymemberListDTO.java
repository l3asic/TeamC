package com.example.totproject.party;

public class PartymemberListDTO {
    private String memberid;
    private int picture_filepath;

    public PartymemberListDTO(String memberid, int picture_filepath) {
        this.memberid = memberid;
        this.picture_filepath = picture_filepath;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public int getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(int picture_filepath) {
        this.picture_filepath = picture_filepath;
    }
}
