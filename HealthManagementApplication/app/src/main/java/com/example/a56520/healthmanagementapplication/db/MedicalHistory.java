package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class MedicalHistory extends DataSupport {
    private int id;
    private int userCode;
    private int medicalHistoryDate;
    private String medicalHistoryPicUri;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getMedicalHistoryDate() {
        return medicalHistoryDate;
    }

    public String getMedicalHistoryPicUri() {
        return medicalHistoryPicUri;
    }

    public void setMedicalHistoryDate(int medicalHistoryDate) {
        this.medicalHistoryDate = medicalHistoryDate;
    }

    public void setMedicalHistoryPicUri(String medicalHistoryPicUri) {
        this.medicalHistoryPicUri = medicalHistoryPicUri;
    }
}
