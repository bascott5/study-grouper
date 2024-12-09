package com.csc340.study_grouper.group_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAccessRepository extends JpaRepository<GroupAccess, Integer> {

    @Query(value = "SELECT * FROM groupaccess WHERE uID = :userID", nativeQuery = true)
    List<GroupAccess> findByUserID (int userID);

    @Query(value = "SELECT * FROM groupaccess WHERE groupID = :groupID", nativeQuery = true)
    List<GroupAccess> findByGroupID (int groupID);
}
