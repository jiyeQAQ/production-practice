package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class Tags extends DataSupport {
    private int id;
    private int userCode;
    private int tagDate;
    private String tagType;
    private String tagContent;

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagDate() {
        return tagDate;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public void setTagDate(int tagDate) {
        this.tagDate = tagDate;
    }
}
