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

    @Query(value = "SELECT * FROM study_groups WHERE uid = :uid;", nativeQuery = true)
    List<StudyGroup> findByUID(int uid);

    @Query(value = "INSERT INTO study_groups (groupid, creatorid, group_name, description, uid) VALUES (:group.groupid, :group.creatorid, :group.group_name, :group.description, :uid);", nativeQuery = true)
    StudyGroup joinGroup(StudyGroup group, int uid);
}
