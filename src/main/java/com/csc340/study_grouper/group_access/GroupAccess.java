package com.csc340.study_grouper.group_access;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "groupaccess")
public class GroupAccess {

    @Column(nullable = false)
    private int groupID;

    @Column(nullable = false)
    private int userID;

    public GroupAccess(int groupID, int userID){
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(){}

    public int getGroupID() {
        return groupID;
    }

    public int getUserID() {
        return userID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
