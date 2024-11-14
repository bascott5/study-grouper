package com.csc340.study_grouper.study_groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyGroupAndInstructorRepository extends JpaRepository<StudyGroupAndInstructor, Integer> {

    @Query(value = "SELECT sg.groupid, sg.group_name, sg.description, u.first_name, u.last_name FROM study_groups sg LEFT JOIN users u ON u.uid=sg.creatorid AND sg.group_name LIKE :query;", nativeQuery = true)
    List<StudyGroupAndInstructor> search(String query);
}
