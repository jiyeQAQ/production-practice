package com.example.a56520.healthmanagementapplication.db;

import org.litepal.crud.DataSupport;

public class GuardianShip extends DataSupport {
    private int id;
    private int userCode;
    private int guardianNumber1;
    private int guardianNumber2;
    private int personUnderGuardianshipNubmer1;
    private int personUnderGuardianshipNumber2;

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getGuardianNumber1() {
        return guardianNumber1;
    }

    public int getGuardianNumber2() {
        return guardianNumber2;
    }

    public int getPersonUnderGuardianshipNubmer1() {
        return personUnderGuardianshipNubmer1;
    }

    public int getPersonUnderGuardianshipNumber2() {
        return personUnderGuardianshipNumber2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setGuardianNumber1(int guardianNumber1) {
        this.guardianNumber1 = guardianNumber1;
    }

    public void setGuardianNumber2(int guardianNumber2) {
        this.guardianNumber2 = guardianNumber2;
    }

    public void setPersonUnderGuardianshipNubmer1(int personUnderGuardianshipNubmer1) {
        this.personUnderGuardianshipNubmer1 = personUnderGuardianshipNubmer1;
    }

    public void setPersonUnderGuardianshipNumber2(int personUnderGuardianshipNumber2) {
        this.personUnderGuardianshipNumber2 = personUnderGuardianshipNumber2;
    }

}
