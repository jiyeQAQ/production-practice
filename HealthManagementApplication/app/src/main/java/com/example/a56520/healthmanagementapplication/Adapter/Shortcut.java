package com.example.a56520.healthmanagementapplication.Adapter;

public class Shortcut {
    private String shortcutName;
    private int shortcutImageId;
    private String shortcutDataName1;
    private String shortcutDataName2;
    private int shortcutDataNumber1;
    private int shortcutDataNumber2;
    private int shortcutDateNumber;
    private String shortcutDataUnit1;
    private String shortcutDataUnit2;
    private String tag;
    private String type;

    public Shortcut(String shortcutName,int shortcutImageId,int shortcutDateNumber,
                    String shortcutDataName1,int shortcutDataNumber1,String shortcutDataUnit1,
                    String shortcutDataName2,int shortcutDataNumber2,String shortcutDataUnit2,
                    String tag,String type){
        this.type = type;
        this.tag = tag;
        this.shortcutName = shortcutName;
        this.shortcutImageId = shortcutImageId;
        this.shortcutDateNumber = shortcutDateNumber;
        this.shortcutDataName1 = shortcutDataName1;
        this.shortcutDataName2 = shortcutDataName2;
        this.shortcutDataNumber1 = shortcutDataNumber1;
        this.shortcutDataNumber2 = shortcutDataNumber2;
        this.shortcutDataUnit1 = shortcutDataUnit1;
        this.shortcutDataUnit2 = shortcutDataUnit2;
    }
    public Shortcut(String shortcutName,int shortcutImageId,int shortcutDateNumber,
                    String shortcutDataName1,int shortcutDataNumber1,String shortcutDataUnit1,
                    String shortcutDataName2,int shortcutDataNumber2,String shortcutDataUnit2,
                    String tag){
        this.type = "MEASURABLE_DATA";
        this.tag = tag;
        this.shortcutName = shortcutName;
        this.shortcutImageId = shortcutImageId;
        this.shortcutDateNumber = shortcutDateNumber;
        this.shortcutDataName1 = shortcutDataName1;
        this.shortcutDataName2 = shortcutDataName2;
        this.shortcutDataNumber1 = shortcutDataNumber1;
        this.shortcutDataNumber2 = shortcutDataNumber2;
        this.shortcutDataUnit1 = shortcutDataUnit1;
        this.shortcutDataUnit2 = shortcutDataUnit2;
    }


    public Shortcut(String shortcutName,int shortcutImageId,int shortcutDateNumber,
                    String shortcutDataName1,int shortcutDataNumber1,String shortcutDataUnit1,
                    String tag,String type){
        this.type=type;
        this.tag=tag;
        this.shortcutName = shortcutName;
        this.shortcutImageId = shortcutImageId;
        this.shortcutDateNumber = shortcutDateNumber;
        this.shortcutDataName1 = shortcutDataName1;
        this.shortcutDataNumber1 = shortcutDataNumber1;
        this.shortcutDataUnit1 = shortcutDataUnit1;
    }

    public Shortcut(String shortcutName,int shortcutImageId,int shortcutDateNumber,
                    String shortcutDataName1,int shortcutDataNumber1,String shortcutDataUnit1,
                    String tag){
        this.type= "MEASURABLE_DATA";
        this.tag=tag;
        this.shortcutName = shortcutName;
        this.shortcutImageId = shortcutImageId;
        this.shortcutDateNumber = shortcutDateNumber;
        this.shortcutDataName1 = shortcutDataName1;
        this.shortcutDataNumber1 = shortcutDataNumber1;
        this.shortcutDataUnit1 = shortcutDataUnit1;
    }
    public Shortcut(String shortcutName,int shortcutImageId,String tag){
        this.type="PICTURE";
        this.tag=tag;
        this.shortcutName=shortcutName;
        this.shortcutImageId=shortcutImageId;
    }

    public String getType() {
        return type;
    }

    public int getShortcutDataNumber1() {
        return shortcutDataNumber1;
    }

    public int getShortcutDataNumber2() {
        return shortcutDataNumber2;
    }

    public int getShortcutDateNumber() {
        return shortcutDateNumber;
    }

    public int getShortcutImageId() {
        return shortcutImageId;
    }

    public String getShortcutDataName1() {
        return shortcutDataName1;
    }

    public String getShortcutDataName2() {
        return shortcutDataName2;
    }

    public String getShortcutDataUnit1() {
        return shortcutDataUnit1;
    }

    public String getShortcutDataUnit2() {
        return shortcutDataUnit2;
    }

    public String getShortcutName() {
        return shortcutName;
    }

    public String getTag() {
        return tag;
    }
}
