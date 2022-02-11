package com.example.totproject.common;

import java.io.Serializable;

public class MemberDTO implements Serializable {
   private String id, pw, name, tel;

    public MemberDTO(String id, String pw, String name, String tel) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.tel = tel;
    }

    public MemberDTO(String id, String pw) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
