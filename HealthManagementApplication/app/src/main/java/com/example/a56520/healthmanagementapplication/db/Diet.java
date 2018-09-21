package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class Diet extends DataSupport {
    private int id;
    private int userCode;
    private int dietDate;
    private int picNumber;

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getId() {
        return id;
    }

    public int getDietDate() {
        return dietDate;
    }

    public int getPicNumber() {
        return picNumber;
    }

    public void setDietDate(int dietDate) {
        this.dietDate = dietDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPicNumber(int picNumber) {
        this.picNumber = picNumber;
    }
}
