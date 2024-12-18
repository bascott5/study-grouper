package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.users.User;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="studyGroups")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int groupID;

    @ManyToOne
    @JoinColumn(name="creatorID")
    public User creatorID;

    @Column(name="groupName", nullable=false)
    public String groupName;

    @Column(name="description")
    public String description;

    @Column(name="deleted")
    @ColumnDefault("'n'")
    public Character deleted;


    public static final Character DELETED_YES = 'y';
    public static final Character DELETED_NO = 'n';

    /**
     * Constructor for all column values in the study groups table
     * @param groupID
     * @param creatorID
     * @param groupName
     */
    public StudyGroup(int groupID, User creatorID, String groupName, String description, Character deleted){
        this(creatorID, groupName, description);
        this.groupID = groupID;
        this.description = description;
        this.deleted = deleted;
    }

    public StudyGroup(User creatorID, String groupName, String description, Character deleted){
        this.creatorID = creatorID;
        this.groupName = groupName;
        this.description = description;
        this.deleted=deleted;
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

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){this.description=description;}

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }
}
