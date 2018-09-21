package com.example.a56520.healthmanagementapplication.Adapter;

public class ShowGraphicsAndTextData {
    private String tag[],imageUri[];
    private String dataType;
    private int imageId[],date,dataTypeFlag;
    //---------------------------dataType只允许取值  饮食，药物，病历---------------------------//
    public ShowGraphicsAndTextData(String dataType,int date,String[]imageUri,String[] tag){
        this.dataType = dataType;
        this.date = date;
        this.imageUri = imageUri;
        this.tag = tag;

        if(dataType.equals("饮食")){
            dataTypeFlag =1;
        }else if(dataType.equals("药物")){
            dataTypeFlag=2;
        }else if(dataType.equals("病历")){
            dataTypeFlag=3;
        }
    }

    public ShowGraphicsAndTextData(String dataType,int date,int[] imageId,String[] tag){
        this.dataType = dataType;
        this.date = date;
        this.imageId = imageId;
        this.tag = tag;

        if(dataType.equals("饮食")){
            dataTypeFlag =1;
        }else if(dataType.equals("药物")){
            dataTypeFlag=2;
        }else if(dataType.equals("病历")){
            dataTypeFlag=3;
        }
    }

    public String[] getTag() {
        return tag;
    }

    public void setImageUri(String[] imageUri) {
        this.imageUri = imageUri;
    }

    public String getDataType() {
        return dataType;
    }

    public int getDate() {
        return date;
    }

    public int getDataTypeFlag() {
        return dataTypeFlag;
    }

    public int[] getImageId() {
        return imageId;
    }

    public String[] getImageUri() {
        return imageUri;
    }
}
