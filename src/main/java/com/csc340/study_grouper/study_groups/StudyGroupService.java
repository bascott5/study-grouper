package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.group_access.GroupAccess;
import com.csc340.study_grouper.group_access.GroupAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service to perform queries on studyGroups table in the database
 * @author Adam Cichoski
 */
@Service
public class StudyGroupService {

    @Autowired
    GroupAccessRepository groupAccessRepository;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @Autowired
    StudyGroupAndInstructorRepository studyGroupAndInstructorRepository;

    public List<StudyGroup> getAllStudyGroups(){
        return studyGroupRepository.findAll();
    }

    public StudyGroup getStudyGroupByID(int groupID){
        return studyGroupRepository.findById(groupID).orElse(null);
    }

    public Optional<List<StudyGroup>> findByCreatorId(int uID){
        return studyGroupRepository.findByCreatorID(uID);
    }

    public List<StudyGroupAndInstructor> searchStudyGroups(String query) { return studyGroupAndInstructorRepository.search(query); }

    public StudyGroupAndInstructor getStudyGroupAndInstructorById(int groupId) { return studyGroupAndInstructorRepository.getById(groupId); }

    public List<StudyGroup> getStudyGroupByGroupAccess(int pID) {
        List<GroupAccess> accessGroups = groupAccessRepository.findByUserID(pID);
        List<StudyGroup> studyGroups = new ArrayList<>();
        for (int i = 0; i < accessGroups.size(); i++) {
          studyGroups.add(studyGroupRepository.findById(accessGroups.get(i).getGroupID().getGroupID()).orElse(null));
        }

        return studyGroups;
    }
}
