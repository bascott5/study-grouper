package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.group_access.GroupAccessService;
import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.UserService;
import com.csc340.study_grouper.users.instructor.InstructorService;
import com.csc340.study_grouper.users.student.StudentService;
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
    UserService userService;

    @Autowired
    GroupAccessService groupAccessService;

    @GetMapping("/instructor/{gID}")
    public String instructorStudyGroupPage(Model model, @PathVariable int gID){
        model.addAttribute("instructor", userService.getUserByID(0));
      model.addAttribute("courses", studyGroupService.getStudyGroupByGroupAccess(0));
        model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
        model.addAttribute("messages", messageService.userMessageJoin(gID));
        return "provider-view/provider-group-view";
    }

    @GetMapping("/student/{gID}")
    public String studentStudyGroupPage(Model model, @PathVariable int gID){
      model.addAttribute("student", userService.getUserByID(2));;
      model.addAttribute("courses", studyGroupService.getStudyGroupByGroupAccess(2));
      model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
      model.addAttribute("messages", messageService.userMessageJoin(gID));
      return "customer-view/customer-group-view";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("student", userService.getUserByID(2));
        model.addAttribute("courses", studyGroupService.getStudyGroupByGroupAccess(2));
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(""));

        return "customer-view/find-group";
    }

    @PostMapping("/search")
    public String searchStudyGroups(String query, Model model) {
      model.addAttribute("student", userService.getUserByID(2));
      model.addAttribute("courses", studyGroupService.getStudyGroupByGroupAccess(2));
      model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(query));

      return "customer-view/find-group";
    }

    @GetMapping("/group-description/{groupID}")
    public String groupDescription(@PathVariable int groupID, Model model) {
      model.addAttribute("student", userService.getUserByID(2));
      model.addAttribute("courses", studyGroupService.getStudyGroupByGroupAccess(2));
      model.addAttribute("groupName", studyGroupService.getStudyGroupAndInstructorById(groupID).getGroupName());
      model.addAttribute("groupID", studyGroupService.getStudyGroupAndInstructorById(groupID).getGroupID());
      model.addAttribute("description", studyGroupService.getStudyGroupAndInstructorById(groupID).getDescription());

      return "customer-view/group-description";
  }

  @PostMapping("/join/{groupID}")
  public String joinGroup(@PathVariable int groupID) {
      groupAccessService.addStudentToGroup(2, groupID);

      return "redirect:/group/student/" + groupID;
  }
}
