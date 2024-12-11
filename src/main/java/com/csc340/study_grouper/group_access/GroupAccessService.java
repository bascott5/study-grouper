package com.csc340.study_grouper.group_access;

import com.csc340.study_grouper.study_groups.StudyGroup;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class GroupAccessService {

    @Autowired
    GroupAccessRepository repo;

    @Autowired
    UserRepository userRepository;
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

    public Optional<List<User>> getUsersInGroupAccessList(int gID){
        return userRepository.findUsersInGroupAccess(gID);
    }

    public void save (StudyGroup gID, User uID) {
        if (!findByUserId(uID.getuID()).isEmpty() && !findByGroupId(gID.getGroupID()).isEmpty()) {
            return;
        }

        GroupAccess groupAccess = new GroupAccess(gID, uID);
        repo.save(groupAccess);
    }
}
