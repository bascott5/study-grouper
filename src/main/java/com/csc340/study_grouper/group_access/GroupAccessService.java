package com.csc340.study_grouper.group_access;

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


    public List<GroupAccess> findAll(){
        return repo.findAll();
    }
    public GroupAccess findById(int accessID){
        return repo.findById(accessID).orElse(null);
    }
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

    /**
     * Saves a new group access to the database
     * @param groupAccess
     * @return all group accesses
     */
    public List<GroupAccess> addGroupAccess(GroupAccess groupAccess){
        repo.save(groupAccess);
        return findAll();
    }

    public List<GroupAccess> delete(int groupAccessID){
        repo.delete(findById(groupAccessID));
        return findAll();
    }
}
