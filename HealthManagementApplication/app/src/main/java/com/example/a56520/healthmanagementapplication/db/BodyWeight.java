package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BodyWeight extends DataSupport {
    private int id;
    private int userCode;
    private int bodyWeight;
    private int bodyWeightTestToolNumber;
    private int bodyWeightTestDate;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getBodyWeight() {
        return bodyWeight;
    }

    public int getBodyWeightTestToolNumber() {
        return bodyWeightTestToolNumber;
    }

    public int getBodyWeightTestDate() {
        return bodyWeightTestDate;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setBodyWeightTestDate(int bodyWeightTestDate) {
        this.bodyWeightTestDate = bodyWeightTestDate;
    }

    public void setBodyWeightTestToolNumber(int bodyWeightTestToolNumber) {
        this.bodyWeightTestToolNumber = bodyWeightTestToolNumber;
    }
}
