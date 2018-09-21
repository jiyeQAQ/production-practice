package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class ContactInformation extends DataSupport {
    private int id;
    private int userCode;
    private String emergencyName;
    private String emergencyRelation;
    private int emergencyNumber;
    private String permanentAddress;
    private String permanentAddressTag;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public int getEmergencyNumber() {
        return emergencyNumber;
    }

    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getPermanentAddressTag() {
        return permanentAddressTag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public void setEmergencyNumber(int emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public void setEmergencyRelation(String emergencyRelation) {
        this.emergencyRelation = emergencyRelation;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setPermanentAddressTag(String permanentAddressTag) {
        this.permanentAddressTag = permanentAddressTag;
    }

}
