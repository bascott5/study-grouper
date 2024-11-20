package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to perform queries on studyGroups table in the database
 * @author Adam Cichoski
 */
@Service
public class StudyGroupService {

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @Autowired
    UserRepository userRepository;

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

    public List<StudyGroup> getStudyGroupsByUserID(int uid) { return studyGroupRepository.findByUID(uid); }

    public StudyGroup joinStudyGroupByID(StudyGroup group, int uid) {
      return studyGroupRepository.save(group);
    }

    public Optional<User> findGoupCreator(int gID){
        return userRepository.findGroupCreator(gID);
    }

    public void save(StudyGroup group){
        studyGroupRepository.save(group);
    }
}
