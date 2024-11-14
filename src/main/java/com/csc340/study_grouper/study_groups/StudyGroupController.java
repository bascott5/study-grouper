package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class StudyGroupController {

    @Autowired
    MessagesService messageService;

    @Autowired
    StudyGroupService studyGroupService;

    @Autowired
    InstructorService instructorService;

    @GetMapping("/{gID}")
    public String studyGroupPage(@PathVariable int groupID){
        return "student-group-view";
    }

    @GetMapping("/search/{query}")
    public String searchStudyGroups(@PathVariable String query, Model model) {
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(query));

        return "student-view/find-group";
    }
}
