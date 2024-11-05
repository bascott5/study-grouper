package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.UsersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class StudyGroupController{
    @Autowired
    StudyGroupService service;

    @GetMapping("/all")
    public List<StudyGroup> getAllGroups(){
        return service.getAllStudyGroups();
    }

    @GetMapping("/{gID}")
    public StudyGroup getStudyGroupById(@PathVariable int gID){
        return service.getStudyGroupByID(gID);
    }

    @PostMapping("/add-group")
    public List<StudyGroup> addStudyGroup(@RequestBody StudyGroup group){
        service.addStudyGroup(group);
        return getAllGroups();
    }

    @PutMapping("/update-group/{gID}")
    public StudyGroup updateStudent(@RequestBody StudyGroup group, @PathVariable int gID){
        return service.updateStudyGroup(group, gID);
    }

    @DeleteMapping("/delete/{gID}")
    public List<StudyGroup> deleteGroup(@PathVariable int gID){
        service.deleteGroup(gID);
        return getAllGroups();
    }


}
