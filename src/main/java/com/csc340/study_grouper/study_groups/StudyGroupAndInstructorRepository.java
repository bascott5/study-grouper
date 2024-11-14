package com.csc340.study_grouper.study_groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyGroupAndInstructorRepository extends JpaRepository<StudyGroupAndInstructor, Integer> {

  @Query(value = "SELECT groupid, group_name, description, first_name, last_name from study_groups sg NATURAL JOIN users u WHERE u.uid=sg.creatorid AND sg.creatorid = :creatorId", nativeQuery = true)
  StudyGroupAndInstructor getById(int creatorId);

  @Query(value = "SELECT groupid, group_name, description, first_name, last_name from study_groups sg NATURAL JOIN users u WHERE u.uid=sg.creatorid AND sg.group_name LIKE :query;", nativeQuery = true)
  List<StudyGroupAndInstructor> search(String query);
}
