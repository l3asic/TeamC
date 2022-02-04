package com.example.totproject.party;

public class PartyListDTO {
    private int picture_filepath;
    private String party_sn;
    private String party_private;
    private String party_name;
    private String party_detail;
    private String party_tag1;
    private String party_tag2;
    private String party_tag3;

    public PartyListDTO(int picture_filepath, String party_sn, String party_private, String party_name, String party_detail, String party_tag1, String party_tag2, String party_tag3) {
        this.picture_filepath = picture_filepath;
        this.party_sn = party_sn;
        this.party_private = party_private;
        this.party_name = party_name;
        this.party_detail = party_detail;
        this.party_tag1 = party_tag1;
        this.party_tag2 = party_tag2;
        this.party_tag3 = party_tag3;
    }

    public int getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(int picture_filepath) {
        this.picture_filepath = picture_filepath;
    }

    public String getParty_sn() {
        return party_sn;
    }

    public void setParty_sn(String party_sn) {
        this.party_sn = party_sn;
    }

    public String getParty_private() {
        return party_private;
    }

    public void setParty_private(String party_private) {
        this.party_private = party_private;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getParty_detail() {
        return party_detail;
    }

    public void setParty_detail(String party_detail) {
        this.party_detail = party_detail;
    }

    public String getParty_tag1() {
        return party_tag1;
    }

    public void setParty_tag1(String party_tag1) {
        this.party_tag1 = party_tag1;
    }

    public String getParty_tag2() {
        return party_tag2;
    }

    public void setParty_tag2(String party_tag2) {
        this.party_tag2 = party_tag2;
    }

    public String getParty_tag3() {
        return party_tag3;
    }

    public void setParty_tag3(String party_tag3) {
        this.party_tag3 = party_tag3;
    }
}