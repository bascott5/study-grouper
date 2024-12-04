package com.csc340.study_grouper.group_access;

import com.csc340.study_grouper.study_groups.StudyGroup;
import jakarta.persistence.*;

@Entity
@Table(name = "groupaccess")
public class GroupAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int group_access_ID;

    @Column(nullable = false)
    private int groupID;

    @Column(nullable = false)
    private int userID;

    /**
     * Constructor with all values
     * @param group_access_ID
     * @param groupID
     * @param userID
     */
    public GroupAccess(int group_access_ID, int groupID, int userID){
        this.group_access_ID = group_access_ID;
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(int groupID, int userID){
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(){}

    public int getGroupID() {
        return groupID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
