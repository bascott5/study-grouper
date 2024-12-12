package com.csc340.study_grouper.group_access;

import com.csc340.study_grouper.study_groups.StudyGroup;
import com.csc340.study_grouper.users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "groupaccess")
public class GroupAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int group_access_ID;

    @ManyToOne
    @JoinColumn(name = "groupID")
    StudyGroup groupID;

    @ManyToOne
    @JoinColumn(name="uID")
    User userID;

    /**
     * Constructor with all values
     * @param group_access_ID
     * @param groupID
     * @param userID
     */
    public GroupAccess(int group_access_ID, StudyGroup groupID, User userID){
        this.group_access_ID = group_access_ID;
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(StudyGroup groupID, User userID){
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(){}

    public int getGroup_access_ID() {
        return group_access_ID;
    }

    public StudyGroup getGroupID() {
        return groupID;
    }

    public User getUserID() {
        return this.userID;
    }

    public void setGroupID(StudyGroup groupID) {
        this.groupID = groupID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
}
