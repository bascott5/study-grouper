package com.csc340.study_grouper.users.customer;

import com.csc340.study_grouper.group_access.GroupAccessService;
import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    UserService userService;

    @Autowired
    StudyGroupService groupService;

    @Autowired
    GroupAccessService groupAccessService;

    @GetMapping("/account")
    public String account(Model model){
        User student = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", groupAccessService.findByUserId(student.getuID()));

      return "customer-view/account";
    }

    @GetMapping("/biology")
    public String biologyChat(){
        return  "customer-view/biology";
    }

    @GetMapping("/chemistry")
    public String chemistryChat(){
        return "customer-view/chemistry";
    }

    @GetMapping("/computer-architecture")
    public String computerArchChat(){
        return "customer-view/computer-architecture";
    }

    @GetMapping("/physics")
    public String physicsChat(){
        return "customer-view/physics";
    }

    @GetMapping("/software-engineering")
    public String seChat(){
        return "customer-view/software-engineering";
    }

    @GetMapping("/group-description")
    public String groupDescription(Model model){
        User student = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", groupAccessService.findByUserId(student.getuID()));

      return "customer-view/group-description";
    }

    @GetMapping("/home")
    public String home(Model model) {
        User student = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
      model.addAttribute("student", student);
      model.addAttribute("courses", groupAccessService.findByUserId(student.getuID()));

      return "customer-view/customer-home";
    }

    @GetMapping("/write-review")
    public String review(Model model) {
        User student = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("student", student);
        model.addAttribute("courses", groupAccessService.findByUserId(student.getuID()));

      return "customer-view/chat-settings";
    }
}
