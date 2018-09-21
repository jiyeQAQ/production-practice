package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {

    private int id;
    private int userCode;
    private String userName;
    private String userSex;
    private int userBirth;
    private int userIdNumber;

    public int getId(){
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public int getUserBirth() {
        return userBirth;
    }

    public int getUserIdNumber() {
        return userIdNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserBirth(int userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserIdNumber(int userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

}
