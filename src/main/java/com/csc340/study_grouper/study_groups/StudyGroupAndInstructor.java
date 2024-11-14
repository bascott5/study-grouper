package com.csc340.study_grouper.study_groups;

import jakarta.persistence.*;

@Entity
@Table(name = "studyGroups")
@SecondaryTable(name = "users")
public class StudyGroupAndInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int groupID;

    @Column(nullable=false)
    String groupName;

    @Column(nullable = true)
    String description;

    @Column(table = "users", nullable=false)
    String first_name;

    @Column(table = "users", nullable=false)
    String last_name;

    public StudyGroupAndInstructor(int groupID, String groupName, String description, String first_name, String last_name) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.description = description;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public StudyGroupAndInstructor() {}

  public int getGroupID() {
    return groupID;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getDescription() {
    return description;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }
}
