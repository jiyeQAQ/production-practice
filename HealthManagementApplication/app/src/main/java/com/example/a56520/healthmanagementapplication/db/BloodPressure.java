package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BloodPressure extends DataSupport {
    private int id;
    private int userCode;
    private int bloodPressureTestDate;
    private int systolicPressure;
    private int diastolicPressure;
    private int bloodPressureTestToolNumber;
    private String bloodPressureTestLocation;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getBloodPressureTestDate() {
        return bloodPressureTestDate;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getBloodPressureTestToolNumber() {
        return bloodPressureTestToolNumber;
    }

    public String getBloodPressureTestLocation() {
        return bloodPressureTestLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setBloodPressureTestDate(int bloodPressureTestDate) {
        this.bloodPressureTestDate = bloodPressureTestDate;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setBloodPressureTestLocation(String bloodPressureTestLocation) {
        this.bloodPressureTestLocation = bloodPressureTestLocation;
    }

    public void setBloodPressureTestToolNumber(int bloodPressureTestToolNumber) {
        this.bloodPressureTestToolNumber = bloodPressureTestToolNumber;
    }

}

