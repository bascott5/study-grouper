package com.csc340.study_grouper.users.instructor;

import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/create-group")
    public String createGroup(){
        return "instructor-view/create-group";
    }

    /**
     * Get mapping for the group settings where a instructor can view student student statistics
     * @return group-settings html in instructor-view
     */
    @GetMapping("/group-settings")
    public String groupSettings(){
        return "instructor-view/group-settings";
    }

    /**
     * Get mapping for the instructor specific account page
     * @return account html in instructor-view
     */
    @GetMapping("/account")
    public String account(){
        return "instructor-view/account";
    }

    /**
     * Displays the instructor view of a biology chat room
     * @return biology html in instructor-view
     */
    @GetMapping("/biology")
    public String biology(){
        return "instructor-view/biology";
    }

    /**
     * Displays the instructor view of a chemistry chat room
     * @return chemistry html in instructor-view
     */
    @GetMapping("/chemistry")
    public String chem(){
        return "instructor-view/chemistry";
    }

    /**
     * Displays the instructor view of a computer architecture chat room
     * @return computer architecture html in instructor-view
     */
    @GetMapping("/computer-architecture")
    public String compArch(){
        return "instructor-view/computer-architecture";
    }

    /**
     * Displays the instructor view of a physics chat room
     * @return physics html in instructor-view
     */
    @GetMapping("/physics")
    public String physics(){
        return "instructor-view/physics";
    }

    /**
     * Displays the instructor view of a software engineering chat room
     * @return software engineering html in instructor-view
     */
    @GetMapping("/software-engineering")
    public String softEng(){
        return "instructor-view/software-engineering";
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
}
