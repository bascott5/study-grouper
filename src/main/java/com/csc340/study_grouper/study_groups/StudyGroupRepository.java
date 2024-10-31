package com.csc340.study_grouper.study_groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Integer>{

    @Query(value = "SELECT * FROM studyGroups WHERE creatorID = creatorID", nativeQuery = true)
    List<StudyGroup> findByCreatorID(int creatorID);

}
