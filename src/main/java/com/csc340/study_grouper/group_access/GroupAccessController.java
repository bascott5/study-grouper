package com.csc340.study_grouper.group_access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group-access")
public class GroupAccessController {

    @Autowired
    GroupAccessService service;

    @GetMapping("/{accessID}")
    public GroupAccess findByAccessId(@RequestParam int accessID){
        return service.findById(accessID);
    }

    @GetMapping("/user/{uID}")
    public List<GroupAccess> findByUserId(@RequestParam int uID){
        return service.findByUserId(uID);
    }

    @GetMapping("/group/{groupID}")
    public List<GroupAccess> findByGroupId(@RequestParam int groupID){
        return service.findByGroupId(groupID);
    }

    @PostMapping("/add-group-access")
    public List<GroupAccess> addNewGroupAccess(@RequestBody GroupAccess groupAccess){
        return service.addGroupAccess(groupAccess);
    }

    @DeleteMapping("/delete/{gID}")
    public List<GroupAccess> deleteGroupAccess(@RequestParam int groupAccessID){
        return service.delete(groupAccessID);
    }
}
