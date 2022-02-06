package com.example.totproject.zzchaminhwan;

import java.io.Serializable;
import java.util.Date;

public class NoticeVO implements Serializable {
    private String title;
    private String writedate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }
}
