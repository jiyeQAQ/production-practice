package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BodyTemperature extends DataSupport {
    private int id;
    private int userCode;
    private int bodyTemperatureTestDate;
    private String bodyTemperatureTestLocation;
    private int bodyTemperature;
    private int bodyTemperatureTestToolNumber;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public int getBodyTemperatureTestToolNumber() {
        return bodyTemperatureTestToolNumber;
    }

    public int getBodyTemperatureTestDate() {
        return bodyTemperatureTestDate;
    }

    public String getBodyTemperatureTestLocation() {
        return bodyTemperatureTestLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setBodyTemperature(int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setBodyTemperatureTestDate(int bodyTemperatureTestDate) {
        this.bodyTemperatureTestDate = bodyTemperatureTestDate;
    }

    public void setBodyTemperatureTestLocation(String bodyTemperatureTestLocation) {
        this.bodyTemperatureTestLocation = bodyTemperatureTestLocation;
    }

    public void setBodyTemperatureTestToolNumber(int bodyTemperatureTestToolNumber) {
        this.bodyTemperatureTestToolNumber = bodyTemperatureTestToolNumber;
    }
}
