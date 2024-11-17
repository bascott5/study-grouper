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
     * @return create-group html in provider-view
     */
    @GetMapping("/create-group/{pID}")
    public String createGroup(Model model, @PathVariable int pID){
      model.addAttribute("instructor", userService.getUserByID(pID));
      model.addAttribute("courses", groupService.findByCreatorId(pID).orElse(null));
      return "provider-view/create-group";
    }

    /**
     * Get mapping for the group settings where a instructor can view student student statistics
     * @return group-settings html in provider-view
     */
    @GetMapping("/group-settings/{pID}")
    public String groupSettings(Model model, @PathVariable int pID){
      model.addAttribute("instructor", userService.getUserByID(pID));
      model.addAttribute("courses", groupService.findByCreatorId(pID).orElse(null));
      return "provider-view/group-settings";
    }

    /**
     * Get mapping for the instructor specific account page
     * @return account html in provider-view
     */
    @GetMapping("/account/{pID}")
    public String account(Model model, @PathVariable int pID){
      model.addAttribute("instructor", userService.getUserByID(pID));
      model.addAttribute("courses", groupService.findByCreatorId(pID).orElse(null));
      return "provider-view/account";
    }

    /**
     * Displays the instructor view of a biology chat room
     * @return biology html in provider-view
     */
    @GetMapping("/biology")
    public String biology(){
        return "provider-view/biology";
    }

    /**
     * Displays the instructor view of a chemistry chat room
     * @return chemistry html in provider-view
     */
    @GetMapping("/chemistry")
    public String chem(){
        return "provider-view/chemistry";
    }

    /**
     * Displays the instructor view of a computer architecture chat room
     * @return computer architecture html in provider-view
     */
    @GetMapping("/computer-architecture")
    public String compArch(){
        return "provider-view/computer-architecture";
    }

    /**
     * Displays the instructor view of a physics chat room
     * @return physics html in provider-view
     */
    @GetMapping("/physics")
    public String physics(){
        return "provider-view/physics";
    }

    /**
     * Displays the instructor view of a software engineering chat room
     * @return software engineering html in provider-view
     */
    @GetMapping("/software-engineering")
    public String softEng(){
        return "provider-view/software-engineering";
    }

    @GetMapping("/home/{pID}")
    public String home(Model model, @PathVariable int pID){
        model.addAttribute("instructor", userService.getUserByID(pID));
        model.addAttribute("courses", groupService.findByCreatorId(pID).orElse(null));
        return "provider-view/provider-home";
    }

    @GetMapping("/statistics")
    public String providerStats() {
        return "provider-view/statistics";
    }
}
