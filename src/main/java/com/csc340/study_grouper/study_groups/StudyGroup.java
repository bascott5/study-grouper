package com.csc340.study_grouper.study_groups;

import jakarta.persistence.*;

@Entity
@Table(name="studyGroups")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int groupID;

    @Column(nullable = false)
    int creatorID;

    @Column(nullable=false)
    String groupName;

    /**
     * Constructor for all column values in the study groups table
     * @param groupID
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int groupID, int creatorID, String groupName){
        this(creatorID, groupName);
        this.groupID = groupID;
    }

    /**
     * Constructor for only required values that are not auto generated
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int creatorID, String groupName){
        this.creatorID = creatorID;
        this.groupName = groupName;
    }

    /**
     * Basic empty constructor
     */
    public StudyGroup(){}

    public int getGroupID() {
        return groupID;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
