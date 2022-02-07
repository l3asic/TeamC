package com.example.totproject.party;

public class PartymemberListDTO {
    private String memberid;
    private int picture_filepath;
    private String member_nick;
    private String party_sn;

    public PartymemberListDTO(String memberid, int picture_filepath, String member_nick, String party_sn) {
        this.memberid = memberid;
        this.picture_filepath = picture_filepath;
        this.member_nick = member_nick;
        this.party_sn = party_sn;
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

    public String getMember_nick() {
        return member_nick;
    }

    public void setMember_nick(String member_nick) {
        this.member_nick = member_nick;
    }

    public String getParty_sn() {
        return party_sn;
    }

    public void setParty_sn(String party_sn) {
        this.party_sn = party_sn;
    }
}
