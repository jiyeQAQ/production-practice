package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class ToolDetail extends DataSupport {
    private int id;
    private int userCode;
    private int toolNumber;
    private int toolPicNumber;
    private String toolTag;
    private int toolUpdateDate;
    private String toolName;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getToolNumber() {
        return toolNumber;
    }

    public int getToolPicNumber() {
        return toolPicNumber;
    }

    public String getToolName() {
        return toolName;
    }

    public String getToolTag() {
        return toolTag;
    }

    public int getToolUpdateDate() {
        return toolUpdateDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public void setToolNumber(int toolNumber) {
        this.toolNumber = toolNumber;
    }

    public void setToolPicNumber(int toolPicNumber) {
        this.toolPicNumber = toolPicNumber;
    }

    public void setToolTag(String toolTag) {
        this.toolTag = toolTag;
    }

    public void setToolUpdateDate(int toolUpdateDate) {
        this.toolUpdateDate = toolUpdateDate;
    }
}
