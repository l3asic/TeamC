package com.example.totproject.login;

public class MemberDTO  {
    private String member_id, member_pw, member_name,
            member_nick, member_gender, member_tel, member_email;

    public MemberDTO(String member_id, String member_pw, String member_name
            , String member_nick, String member_gender, String member_tel, String member_email) {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.member_name = member_name;
        this.member_nick = member_nick;
        this.member_gender = member_gender;
        this.member_tel = member_tel;
        this.member_email = member_email;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_nick() {
        return member_nick;
    }

    public void setMember_nick(String member_nick) {
        this.member_nick = member_nick;
    }

    public String getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(String member_gender) {
        this.member_gender = member_gender;
    }

    public String getMember_tel() {
        return member_tel;
    }

    public void setMember_tel(String member_tel) {
        this.member_tel = member_tel;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }
}
