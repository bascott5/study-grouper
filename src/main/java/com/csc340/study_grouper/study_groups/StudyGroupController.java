package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.group_access.GroupAccessService;
import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.User;
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
    InstructorService instructorService;

    @Autowired
    UserService userService;

    @Autowired
    GroupAccessService groupAccessService;

    @GetMapping("/instructor/{gID}")
    public String instructorStudyGroupPage(Model model, @PathVariable int gID){
        int pID = studyGroupService.getStudyGroupByID(gID).getCreatorID().getuID();
        model.addAttribute("instructor", userService.getUserByID(pID));
        model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(pID));
        model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
        model.addAttribute("messages", messageService.findOrderedGroupMessages(gID));
        return "provider-view/provider-group-view";
    }

    @GetMapping("/student/{gID}")
    public String studentStudyGroupPage(Model model, @PathVariable int gID){
      model.addAttribute("student", userService.getUserByID(2));;
      model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(2));
      model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
      model.addAttribute("messages", messageService.findOrderedGroupMessages(gID));
      return "customer-view/customer-group-view";
    }

    @GetMapping("/search/{uID}")
    public String searchPage(@PathVariable int uID, Model model) {
        model.addAttribute("student", userService.getUserByID(uID));
        model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(uID));
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups());

        return "customer-view/find-group";
    }

    @PostMapping("/post-search/{uID}")
    public String searchStudyGroups(@PathVariable int uID, String query, Model model) {
      model.addAttribute("student", userService.getUserByID(uID));
      model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(uID));
      model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(query));
      return "customer-view/find-group";
    }

    @GetMapping("/group-description/{uID}/{groupID}")
    public String groupDescription(@PathVariable int uID, @PathVariable int groupID, Model model) {
      model.addAttribute("student", userService.getUserByID(uID));
      model.addAttribute("instructor", studyGroupService.getStudyGroupByID(groupID).getCreatorID());
      model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(uID));
      model.addAttribute("groupID", groupID);
      model.addAttribute("groupName", studyGroupService.getStudyGroupByID(groupID).getGroupName());
      model.addAttribute("description", studyGroupService.getStudyGroupByID(groupID).description);
      return "customer-view/group-description";
    }

    @PostMapping("/join/{uID}/{groupID}")
    public String joinGroup(@PathVariable int uID, @PathVariable int groupID) {
        groupAccessService.save(groupID, uID);

        return "redirect:/group/student/" + groupID;
  }

     @GetMapping("/group-settings/{gID}")
     public String groupSettings(@PathVariable int gID, Model model){
        model.addAttribute("instructor", studyGroupService.findGroupCreator(gID).orElse(null));
        model.addAttribute("group", studyGroupService.getStudyGroupByID(gID));
        model.addAttribute("students", groupAccessService.getUsersInGroupAccessList(gID).orElse(null));
        return "provider-view/group-settings";
     }

    @PostMapping("/update-group")
    public String updateGroup(StudyGroup group){
        studyGroupService.save(group);
        return "redirect:/group/instructor/"+group.getGroupID();
    }

}
