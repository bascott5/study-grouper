package com.csc340.study_grouper.users.instructor;

import com.csc340.study_grouper.study_groups.StudyGroup;
import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get mapping for the page where a instructor can make a group
     * @return create-group html in instructor-view
     */
    @GetMapping("/create-group/{pID}")
    public String createGroup(@PathVariable int pID, Model model){
        model.addAttribute("instructor", userService.getUserByID(pID));
        return "provider-view/create-group";
    }

    @PostMapping("/create-group")
    public String postGroup(StudyGroup group){
        groupService.save(group);
        return "redirect:/instructor/home/"+group.getCreatorID();
    }




    /**
     * Get mapping for the instructor specific account page
     * @return account html in instructor-view
     */
    @GetMapping("/account/{uID}")
    public String account(@PathVariable int uID, Model model){
        model.addAttribute("user", userService.getUserByID(uID));
        model.addAttribute("courses", groupService.findByCreatorId(uID).orElse(null));
        return "provider-view/account";
    }


    @GetMapping("/home/{pID}")
    public String home(Model model, @PathVariable int pID){
        model.addAttribute("instructor", userService.getUserByID(pID));
        model.addAttribute("courses", groupService.findByCreatorId(pID).orElse(null));
        return "provider-view/provider-home";
    }

    @GetMapping("/statistics")
    public String providerStats() {
        return "instructor-view/statistics";
    }
//
//    @PostMapping("/delete-group")
//    public String delete
}
