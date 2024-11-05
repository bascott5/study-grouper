package com.csc340.study_grouper.users;

public enum AccountType {
    STUDENT("student"),
    INSTRUCTOR("instructor"),
    ADMIN("admin");

    private final String accountType;

    AccountType(String accountType){
        this.accountType=accountType;
    }

    public String getAccountType(){
        return this.accountType;
    }

}
