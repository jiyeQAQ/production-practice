package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class Discomfort extends DataSupport {
    private int id;
    private int userCode;
    private int discomfortDate;
    private int discomfortType;
    private String discomfortDetail;

    public int getId() {
        return id;
    }

    public int getDiscomfortDate() {
        return discomfortDate;
    }

    public int getDiscomfortType() {
        return discomfortType;
    }

    public int getUserCode() {
        return userCode;
    }

    public String getDiscomfortDetail() {
        return discomfortDetail;
    }

    public void setDiscomfortDate(int discomfortDate) {
        this.discomfortDate = discomfortDate;
    }

    public void setDiscomfortDetail(String discomfortDetail) {
        this.discomfortDetail = discomfortDetail;
    }

    public void setDiscomfortType(int discomfortType) {
        this.discomfortType = discomfortType;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

}
