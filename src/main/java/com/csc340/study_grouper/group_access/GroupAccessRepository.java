package com.csc340.study_grouper.group_access;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupAccessRepository extends JpaRepository<GroupAccess, Integer> {

    @Query(value = "SELECT g.* FROM groupaccess g " +
            "LEFT JOIN study_groups s ON g.groupid = s.groupid " +
            "WHERE g.uID = :userID AND s.deleted = 'n'", nativeQuery = true)
    List<GroupAccess> findByUserID (int userID);

    @Query(value = "SELECT g.* FROM groupaccess g " +
            "LEFT JOIN study_groups s ON g.groupid = s.groupid " +
            "WHERE g.groupID = :groupID AND s.deleted = 'n'", nativeQuery = true)
    List<GroupAccess> findByGroupID (int groupID);

    @Query(value = "SELECT * FROM groupaccess " +
            "WHERE groupid = :groupID AND uID = :uID;", nativeQuery = true)
    Optional<GroupAccess> findByMatchPair(int groupID, int uID);

}
