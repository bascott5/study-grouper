package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UsersController;
import com.csc340.study_grouper.users.provider.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        return "customer-group-view";
    }

    @GetMapping("/search/{query}")
    public String searchStudyGroups(@PathVariable String query, Model model) {
        List<StudyGroup> studyGroups = studyGroupService.searchStudyGroups(query);
        User[] instructors = new User[studyGroups.size()];

        for (int i = 0; i < studyGroups.size(); i++) {
            instructors[i] = instructorService.getProviderById(studyGroups.get(i).getGroupID());
        }

        model.addAttribute("studyGroups", studyGroups);
        return "customer-view/find-group";
    }
}
