package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BloodGlucose extends DataSupport {
    //--血糖下限0 上限333，单位mmol/L，精确到0.1--真实值除以10//
    //--date 为18XXXXXXXX//
    private int id;
    private int userCode;
    private int bloodGlucoseTestDate;
    private String bloodGlucoseTestCondition;
    private int bloodGlucose;
    private int bloodGlucoseTestToolNumber;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getBloodGlucose() {
        return bloodGlucose;
    }

    public int getBloodGlucoseTestToolNumber() {
        return bloodGlucoseTestToolNumber;
    }

    public String getBloodGlucoseTestCondition() {
        return bloodGlucoseTestCondition;
    }

    public int getBloodGlucoseTestDate() {
        return bloodGlucoseTestDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setBloodGlucose(int bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public void setBloodGlucoseTestCondition(String bloodGlucosetestCondition) {
        this.bloodGlucoseTestCondition = bloodGlucosetestCondition;
    }

    public void setBloodGlucoseTestDate(int bloodGlucoseTestDate) {
        this.bloodGlucoseTestDate = bloodGlucoseTestDate;
    }

    public void setBloodGlucoseTestToolNumber(int bloodGlucoseTestToolNumber) {
        this.bloodGlucoseTestToolNumber = bloodGlucoseTestToolNumber;
    }
}
