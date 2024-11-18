package com.csc340.study_grouper.group_access;

import com.csc340.study_grouper.study_groups.StudyGroup;
import jakarta.persistence.*;

@Entity
@Table(name = "groupaccess")
public class GroupAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int group_access_ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="groupID")
    private StudyGroup groupID;

    @Column(nullable = false)
    private int userID;

    /**
     * Constructor with all values
     * @param group_access_ID
     * @param groupID
     * @param userID
     */
    public GroupAccess(int group_access_ID, StudyGroup groupID, int userID){
        this.group_access_ID = group_access_ID;
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(StudyGroup groupID, int userID){
        this.groupID = groupID;
        this.userID = userID;
    }

    public GroupAccess(){}

    public StudyGroup getGroupID() {
        return groupID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setGroupID(StudyGroup groupID) {
        this.groupID = groupID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
