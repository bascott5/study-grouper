package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.users.User;
import jakarta.persistence.*;

@Entity
@Table(name="studyGroups")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="groupID")
    public int groupID;

    @Column(nullable = false)
    public int creatorID;

    @Column(name="groupName", nullable=false)
    public String groupName;

    @Column
    String description;

    /**
     * Constructor for all column values in the study groups table
     * @param groupID
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int groupID, int creatorID, String groupName, String description){
        this(creatorID, groupName, description);
        this.groupID = groupID;
        this.description = description;
    }

    /**
     * Constructor for only required values that are not auto generated
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int creatorID, String groupName, String description){
        this.creatorID = creatorID;
        this.groupName = groupName;
        this.description = description;
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
