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
}
