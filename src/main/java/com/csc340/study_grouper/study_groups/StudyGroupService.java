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

    public List<StudyGroup> findAllStudyGroups(){
        return repository.findAll();
    }

    public StudyGroup findStudyGroupByID(int groupID){
        return repository.findById(groupID).orElse(null);
    }

    public List<StudyGroup> findByCreatorId(int creatorID){return repository.findByCreatorID(creatorID);}
}
