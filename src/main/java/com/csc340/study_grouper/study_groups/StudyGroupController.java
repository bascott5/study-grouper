package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(""));

        return "customer-view/find-group";
    }

    @PostMapping("/search")
    public String searchStudyGroups(String query, Model model) {
      model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(query));

      return "customer-view/find-group";
    }

    @GetMapping("/group-description/{groupID}")
    public String groupDescription(@PathVariable int groupID, Model model) {
      model.addAttribute("groupName", studyGroupService.getStudyGroupAndInstructorById(groupID).getGroupName());
      model.addAttribute("description", studyGroupService.getStudyGroupAndInstructorById(groupID).getDescription());

      return "customer-view/group-description";
  }
}
