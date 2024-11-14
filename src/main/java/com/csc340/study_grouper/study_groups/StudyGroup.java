package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.users.User;
import jakarta.persistence.*;

@Entity
@Table(name="studyGroups")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="groupID")
    int groupID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="uID")
    User creatorID;

    @Column(name="groupName", nullable=false)
    String groupName;

    @Column
    String description;

    /**
     * Constructor for all column values in the study groups table
     * @param groupID
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int groupID, User creatorID, String groupName, String description){
        this(creatorID, groupName, description);
        this.groupID = groupID;
        this.description = description;
    }

    /**
     * Constructor for only required values that are not auto generated
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(User creatorID, String groupName, String description){
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

    public User getCreatorID() {
        return creatorID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setCreatorID(User creatorID) {
        this.creatorID = creatorID;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
