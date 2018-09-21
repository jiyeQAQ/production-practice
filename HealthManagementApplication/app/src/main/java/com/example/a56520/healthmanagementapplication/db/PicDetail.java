package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class PicDetail extends DataSupport {
    private int id;
    private int userCode;
    private int picNumber;
    private String picUri;
    private int picUpdateDate;
    private String picTag;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getPicNumber() {
        return picNumber;
    }

    public String getpicUri() {
        return picUri;
    }

    public String getPicTag() {
        return picTag;
    }

    public int getPicUpdateDate() {
        return picUpdateDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setPicNumber(int picNumber) {
        this.picNumber = picNumber;
    }

    public void setpicUri(String picUri) {
        this.picUri = picUri;
    }

    public void setPicTag(String picTag) {
        this.picTag = picTag;
    }

    public void setPicUpdateDate(int picUpdateDate) {
        this.picUpdateDate = picUpdateDate;
    }
}
