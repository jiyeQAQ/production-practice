package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class HeartRate extends DataSupport {
    private int id;
    private int userCode;
    private int heartRate;
    private int heartTateTestToolNumber;
    private String heartRateTestLocation;
    private int heartRateTestDate;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getHeartTateTestToolNumber() {
        return heartTateTestToolNumber;
    }

    public int getHeartRateTestDate() {
        return heartRateTestDate;
    }

    public String getHeartRateTestLocation() {
        return heartRateTestLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setHeartRateTestDate(int heartRateTestDate) {
        this.heartRateTestDate = heartRateTestDate;
    }

    public void setHeartRateTestLocation(String heartRateTestLocation) {
        this.heartRateTestLocation = heartRateTestLocation;
    }

    public void setHeartTateTestToolNumber(int heartTateTestToolNumber) {
        this.heartTateTestToolNumber = heartTateTestToolNumber;
    }
}
