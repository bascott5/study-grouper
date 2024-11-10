package com.csc340.study_grouper.study_groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to perform queries on studyGroups table in the database
 * @author Adam Cichoski
 */
@Service
public class StudyGroupService {

    @Autowired
    StudyGroupRepository repository;

    public List<StudyGroup> getAllStudyGroups(){
        return repository.findAll();
    }

    StudyGroup getStudyGroupByID(int groupID){
        return repository.findById(groupID).orElse(null);
    }

    public List<StudyGroup> searchStudyGroups(String query) { return repository.search(query); }
}
