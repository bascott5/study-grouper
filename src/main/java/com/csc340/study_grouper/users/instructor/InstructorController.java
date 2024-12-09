package com.csc340.study_grouper.users.instructor;

import com.csc340.study_grouper.group_access.GroupAccess;
import com.csc340.study_grouper.group_access.GroupAccessService;
import com.csc340.study_grouper.study_groups.StudyGroup;
import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This controller is used for mapping instructor account pages
 */
@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    UserService userService;

    @Autowired
    StudyGroupService groupService;

    @Autowired
    GroupAccessService groupAccessService;

    /**
     * Get mapping for the page where a instructor can make a group
     * @return create-group html in instructor-view
     */
    @GetMapping("/create-group")
    public String createGroup(Model model){
        User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        int pID = instructor.getuID();
        model.addAttribute("instructor", userService.getUserByID(pID));
        model.addAttribute("courses", groupAccessService.findByUserId(instructor.getuID()));
        return "provider-view/create-group";
    }

    @PostMapping("/create-group")
    public String postGroup(StudyGroup group){
        User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        groupService.save(group);
        groupAccessService.save(group, instructor);
        return "redirect:/instructor/home";
    }

    /**
     * Get mapping for the instructor specific account page
     * @return account html in instructor-view
     */
    @GetMapping("/account")
    public String account(Model model){
        User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        int uID = instructor.getuID();
        model.addAttribute("instructor", instructor);
        model.addAttribute("courses", groupAccessService.findByUserId(instructor.getuID()));
        return "provider-view/account";
    }

    @GetMapping("/home")
    public String home(Model model){
        User instructor = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("instructor", instructor);
        model.addAttribute("courses", groupAccessService.findByUserId(instructor.getuID()));
        return "provider-view/provider-home";
    }

    @GetMapping("/statistics")
    public String providerStats() {
        return "instructor-view/statistics";
    }

}
