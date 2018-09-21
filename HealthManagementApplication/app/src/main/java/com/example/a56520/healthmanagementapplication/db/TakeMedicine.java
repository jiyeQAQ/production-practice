package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class TakeMedicine extends DataSupport {
    private int id;
    private int userCode;
    private int takeMedicineDate;
    private String medicineName;
    private float medicineAmount;
    private String medicineUnit;
    private int medicinePicUri;

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

    public float getMedicineAmount() {
        return medicineAmount;
    }

    public int getMedicinePicUri() {
        return medicinePicUri;
    }

    public int getTakeMedicineDate() {
        return takeMedicineDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineAmount(float medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setMedicinePicUri(int medicinePicUri) {
        this.medicinePicUri = medicinePicUri;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public void setTakeMedicineDate(int takeMedicineDate) {
        this.takeMedicineDate = takeMedicineDate;
    }
}
