package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.UsersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class StudyGroupController extends UsersController {

    @Autowired
    MessagesService messageService;

    @GetMapping("/{gID}")
    public String studyGroupPage(@PathVariable int groupID){
        return "customer-group-view";
    }

}
