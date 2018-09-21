package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class BodyHeight extends DataSupport {
    private int id;
    private int userCode;
    private int bodyHeight;
    private int bodyHeightTestToolNumber;
    private int bodyHeightTestDate;

    public int getUserCode() {
        return userCode;
    }

    public int getId() {
        return id;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public int getBodyHeightTestToolNumber() {
        return bodyHeightTestToolNumber;
    }

    public int getBodyHeightTestDate() {
        return bodyHeightTestDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public void setBodyHeightTestDate(int bodyHeightTestDate) {
        this.bodyHeightTestDate = bodyHeightTestDate;
    }

    public void setBodyHeightTestToolNumber(int bodyHeightTestToolNumber) {
        this.bodyHeightTestToolNumber = bodyHeightTestToolNumber;
    }
}
