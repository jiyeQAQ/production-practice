package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BloodOxygen extends DataSupport {
    private int id;
    private int userCode;
    private int bloodOxygen;
    private int bloodTestToolNumber;
    private int bloodTestDate;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getBloodOxygen() {
        return bloodOxygen;
    }

    public int getBloodTestDate() {
        return bloodTestDate;
    }

    public int getBloodTestToolNumber() {
        return bloodTestToolNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setBloodOxygen(int bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public void setBloodTestDate(int bloodTestDate) {
        this.bloodTestDate = bloodTestDate;
    }

    public void setBloodTestToolNumber(int bloodTestToolNumber) {
        this.bloodTestToolNumber = bloodTestToolNumber;
    }

}
