package com.csc340.study_grouper.study_groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyGroupAndInstructorRepository extends JpaRepository<StudyGroupAndInstructor, Integer> {

  @Query(value = "SELECT sg.groupID, sg.group_name, sg.description, u.first_name, u.last_name FROM study_groups sg " +
          "INNER JOIN users u ON sg.creatorID=u.uID " +
          "WHERE sg.group_name LIKE %:query% OR sg.description LIKE %:query% OR CONCAT(u.first_name,\" \", u.last_name) LIKE %:query% ", nativeQuery = true)
  List<StudyGroupAndInstructor> search(String query);
}
