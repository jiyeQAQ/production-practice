package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class UserAccount extends DataSupport {
    private int id;
    private int userCode;
    private String userAccount;
    private String userPassword;
    private int userPhoneNumber;
    private String userNickname;
    private int userPicNumber;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public int getUserPicNumber() {
        return userPicNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setUserPicNumber(int userPicNumber) {
        this.userPicNumber = userPicNumber;
    }

}

