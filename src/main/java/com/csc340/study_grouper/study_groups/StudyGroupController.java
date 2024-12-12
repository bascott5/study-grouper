package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.group_access.GroupAccessService;
import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import com.csc340.study_grouper.users.instructor.InstructorService;
import com.csc340.study_grouper.users.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("instructor", instructor);
        model.addAttribute("courses", groupAccessService.findByUserId(instructor.getuID()));
        model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
        model.addAttribute("messages", messageService.findOrderedGroupMessages(gID));
        return "provider-view/provider-group-view";
    }

    @GetMapping("/student/{gID}")
    public String studentStudyGroupPage(Model model, @PathVariable int gID){
        User student = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", groupAccessService.findByUserId(student.getuID()));
        model.addAttribute("selectedCourse", studyGroupService.getStudyGroupByID(gID));
        model.addAttribute("messages", messageService.findOrderedGroupMessages(gID));
        return "customer-view/customer-group-view";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", user);
        model.addAttribute("courses", groupAccessService.findByUserId(user.getuID()));
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups());

        return "customer-view/find-group";
    }

    @PostMapping("/post-search")
    public String searchStudyGroups(String query, Model model) {
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", user);
        model.addAttribute("courses", studyGroupService.getStudyGroupsByUserID(user.getuID()));
        model.addAttribute("studyGroups", studyGroupService.searchStudyGroups(query));
        return "customer-view/find-group";
    }

    @GetMapping("/group-description/{groupID}")
    public String groupDescription(@PathVariable int groupID, Model model) {
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", user);
        model.addAttribute("instructor", studyGroupService.getStudyGroupByID(groupID).getCreatorID());
        model.addAttribute("courses", groupAccessService.findByUserId(user.getuID()));
        model.addAttribute("groupID", groupID);
        model.addAttribute("groupName", studyGroupService.getStudyGroupByID(groupID).getGroupName());
        model.addAttribute("description", studyGroupService.getStudyGroupByID(groupID).description);
        return "customer-view/group-description";
    }

    @PostMapping("/join/{uID}/{groupID}")
    public String joinGroup(@PathVariable int uID, @PathVariable int groupID) {
        groupAccessService.save(studyGroupService.getStudyGroupByID(groupID), userService.getUserByID(uID));
        return "redirect:/group/student/" + groupID;
  }

     @GetMapping("/group-settings/{gID}")
     public String groupSettings(@PathVariable int gID, Model model){
         User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
         model.addAttribute("instructor", instructor);
         model.addAttribute("courses", groupAccessService.findByUserId(instructor.getuID()));
         model.addAttribute("group", studyGroupService.getStudyGroupByID(gID));
        // model.addAttribute("students", groupAccessService.findByGroupId(gID));
        return "provider-view/group-settings";
     }

    @PostMapping("/update-group")
    public String updateGroup(StudyGroup group){
        studyGroupService.save(group);
        return "redirect:/group/instructor/"+group.getGroupID();
    }

    @GetMapping("/delete/{groupID}")
    public String deleteGroup(@PathVariable int groupID){
        studyGroupService.delete(groupID);
        return "redirect:/instructor/home";
    }

}
