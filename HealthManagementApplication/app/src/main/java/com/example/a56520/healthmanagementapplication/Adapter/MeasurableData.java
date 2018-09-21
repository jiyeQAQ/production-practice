package com.example.a56520.healthmanagementapplication.Adapter;

public class MeasurableData {

    private int toolNumber,date,bloodGlucose,bloodOxygen,systolicPressure,diastolicPressure,
            bodyWeight,bodyTemperature,heartRate,tag,range;
    private int testDate[],testResult1[],testResult2[];
    //-------dataType为中文，分别有  血压，血糖，血氧，体重，心率，体温-----------//
    //-------date格式为18XXXXXXXX--------------------------------------------//
    //----------李俊负责完善此处----------------------------//
    //--血压下限0 上限300，单位mmHg，精确到个位-//
    //--血糖下限0 上限333，单位mmol/L，精确到0.1--真实值除以10//
    //--血氧下限0 上限100，单位%，精确到个位-//
    //--体重下限0 上限100000，单位mmHg，精确到0.01---真实值除以100-//
    //--心率下限0 上限300，单位次/分钟，精确到个位-//
    //--体温下限0 上限1000，单位℃，精确到0.1--真实值除以10---//
    //---//
    //---//
    //---//
    //---//
    //---//
    //---//
    private String dataType;

    public MeasurableData(String dataType,int dataNumber,int date,int toolNumber){
        this.dataType = dataType;
        this.date = date;
        this.toolNumber = toolNumber;
        this.tag = 1;
        if(dataType.equals("血糖")){
            this.bloodGlucose = dataNumber;
        }else if (dataType.equals("血氧")){
            this.bloodOxygen = dataNumber;
        }else if (dataType.equals("体重")){
            this.bodyWeight = dataNumber;
        }else if (dataType.equals("体温")){
            this.bodyTemperature = dataNumber;
        }else if (dataType.equals("心率")){
            this.heartRate = dataNumber;
        }
    }

    public MeasurableData(String dataType,int dataNumber1,int dataNumber2,int date,int toolNumber){
        this.dataType = dataType;
        this.date = date;
        this.tag = 2;
        this.toolNumber = toolNumber;
        this.systolicPressure = dataNumber1;
        this.diastolicPressure = dataNumber2;
    }

    public MeasurableData(String dataType,int range,int[] testDate,int[] testResult1){
        this.tag =3;
        this.range = range;
        this.dataType = dataType;
        this.testDate = testDate;
        this.testResult1 = testResult1;
//        for(int i =0;i<testDate.length;i++){
//            this.testDate[i] = testDate[i];
//        }
//        for(int i=0;i<testResult1.length;i++){
//            this.testResult1[i]=testResult1[i];
//        }
    }

    public MeasurableData(String dataType,int range,int[] testDate,int[] testResult1,
                          int[] testResult2){
        this.tag = 3;
        this.range = range;
        this.dataType = dataType;
        this.testDate = testDate;
        this.testResult1 = testResult1;
        this.testResult2 = testResult2;
//        for(int i =0;i<testDate.length;i++){
//            this.testDate[i] = testDate[i];
//        }
//        for(int i=0;i<testResult1.length;i++){
//            this.testResult1[i]=testResult1[i];
//        }
//        for (int i =0;i<testResult2.length;i++){
//            this.testResult2[i]=testResult2[i];
//        }

    }

    public void setTestDate(int[] testDate) {
        this.testDate = testDate;
    }

    public void setTestResult1(int[] testResult1) {
        this.testResult1 = testResult1;
    }

    public void setTestResult2(int[] testResult2) {
        this.testResult2 = testResult2;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public int[] getTestDate() {
        return testDate;
    }

    public int[] getTestResult1() {
        return testResult1;
    }

    public int[] getTestResult2() {
        return testResult2;
    }

    public int getTag() {
        return tag;
    }

    public int getDate() {
        return date;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getBloodGlucose() {
        return bloodGlucose;
    }

    public int getBloodOxygen() {
        return bloodOxygen;
    }

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public int getBodyWeight() {
        return bodyWeight;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getToolNumber() {
        return toolNumber;
    }

    public String getDataType() {
        return dataType;
    }
}
