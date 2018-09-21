package com.example.a56520.healthmanagementapplication.Adapter;

public class DiscomfortData {
    private String discomfortType;
    private int discomfortTypeImageId;


    public DiscomfortData(String discomfortType,int discomfortTypeImageId){
        this.discomfortType=discomfortType;
        this.discomfortTypeImageId = discomfortTypeImageId;
    }

    public String getDiscomfortType() {
        return discomfortType;
    }

    public int getDiscomfortTypeImageId() {
        return discomfortTypeImageId;
    }
}
