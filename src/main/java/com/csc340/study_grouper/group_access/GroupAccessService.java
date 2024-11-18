package com.csc340.study_grouper.group_access;

import com.csc340.study_grouper.study_groups.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class GroupAccessService {

    @Autowired
    GroupAccessRepository repo;

    @Autowired
    StudyGroupService studyGroupService;

    /**
     * Returns everything from the groupaccess table
     * @return
     */
    public List<GroupAccess> findAllAccessLists(){
        return repo.findAll();
    }

    /**
     * Returns all groups that a user is in
     * @param userID
     * @return
     */
    public List<GroupAccess> findByUserId(int userID){
        return repo.findByUserID(userID);
    }

    /**
     * Returns all users in a group
     * @param groupID
     * @return
     */
    public List<GroupAccess> findByGroupId(int groupID){
        return repo.findByGroupID(groupID);
    }

    public void addStudentToGroup(int uid, int groupID) {
      GroupAccess member = new GroupAccess(studyGroupService.getStudyGroupByID(groupID), uid);
      repo.save(member);
    }
}
