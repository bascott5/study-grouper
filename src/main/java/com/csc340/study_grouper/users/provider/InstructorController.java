package com.csc340.study_grouper.users.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This controller is used for mapping provider account pages
 */
@Controller
@RequestMapping("/provider")
public class InstructorController {

    /**
     * Get mapping for the page where a provider can make a group
     * @return create-group html in provider-view
     */
    @GetMapping("/create-group")
    public String createGroup(){
        return "provider-view/create-group";
    }

    /**
     * Get mapping for the group settings where a provider can view student customer statistics
     * @return group-settings html in provider-view
     */
    @GetMapping("/group-settings")
    public String groupSettings(){
        return "provider-view/group-settings";
    }

    /**
     * Get mapping for the provider specific account page
     * @return account html in provider-view
     */
    @GetMapping("/account")
    public String account(){
        return "provider-view/account";
    }

    /**
     * Displays the provider view of a biology chat room
     * @return biology html in provider-view
     */
    @GetMapping("/biology")
    public String biology(){
        return "provider-view/biology";
    }

    /**
     * Displays the provider view of a chemistry chat room
     * @return chemistry html in provider-view
     */
    @GetMapping("/chemistry")
    public String chem(){
        return "provider-view/chemistry";
    }

    /**
     * Displays the provider view of a computer architecture chat room
     * @return computer architecture html in provider-view
     */
    @GetMapping("/computer-architecture")
    public String compArch(){
        return "provider-view/computer-architecture";
    }

    /**
     * Displays the provider view of a physics chat room
     * @return physics html in provider-view
     */
    @GetMapping("/physics")
    public String physics(){
        return "provider-view/physics";
    }

    /**
     * Displays the provider view of a software engineering chat room
     * @return software engineering html in provider-view
     */
    @GetMapping("/software-engineering")
    public String softEng(){
        return "provider-view/software-engineering";
    }

    @GetMapping("/home")
    public String home(){
        return "provider-view/provider-home";
    }

    @GetMapping("/statistics")
    public String providerStats() {
        return "provider-view/statistics";
    }
}
