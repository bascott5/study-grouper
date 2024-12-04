package com.csc340.study_grouper.study_groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Integer>{

    @Query(value = "SELECT * FROM study_groups WHERE creatorID = :creatorID", nativeQuery = true)
    Optional<List<StudyGroup>> findByCreatorID(int creatorID);

    @Query(value = "SELECT * FROM study_groups WHERE creatorid = :uid;", nativeQuery = true)
    List<StudyGroup> findByUID(int uid);

    @Query(value = "INSERT INTO study_groups (groupid, creatorid, group_name, description, uid) VALUES (:groupID, :creatorID, :groupName, :description, :uid);", nativeQuery = true)
    StudyGroup joinGroup(int groupID, int creatorID, String groupName, String description, int uid);

    @Query(value= "SELECT s.* FROM study_groups s " +
            "LEFT JOIN users u ON s.creatorID = u.uID " +
            "WHERE s.group_name LIKE %:query% OR s.groupID LIKE %:query% OR s.description LIKE %:query% " +
            "OR u.first_name LIKE %:query% OR u.last_name LIKE %:query% " +
            "ORDER BY s.groupID", nativeQuery = true)
    List<StudyGroup> search(String query);
}
