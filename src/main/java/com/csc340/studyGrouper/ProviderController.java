package com.csc340.studyGrouper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This controller is used for mapping provider account pages
 */
@Controller
public class ProviderController {

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
    @GetMapping("/provider-account")
    public String account(){
        return "provider-view/account";
    }

    /**
     * Displays the provider view of a biology chat room
     * @return biology html in provider-view
     */
    @GetMapping("/provider-biology")
    public String biology(){
        return "provider-view/biology";
    }

    /**
     * Displays the provider view of a chemistry chat room
     * @return chemistry html in provider-view
     */
    @GetMapping("/provider-chemistry")
    public String chem(){
        return "provider-view/chemistry";
    }

    /**
     * Displays the provider view of a computer architecture chat room
     * @return computer architecture html in provider-view
     */
    @GetMapping("/provider-computer-architecture")
    public String compArch(){
        return "provider-view/computer-architecture";
    }

    /**
     * Displays the provider view of a physics chat room
     * @return physics html in provider-view
     */
    @GetMapping("/provider-physics")
    public String physics(){
        return "provider-view/physics";
    }

    /**
     * Displays the provider view of a software engineering chat room
     * @return software engineering html in provider-view
     */
    @GetMapping("/provider-software-engineering")
    public String softEng(){
        return "provider-view/software-engineering";
    }

    @GetMapping("/provider-home")
    public String home(){
        return "provider-view/provider-home";
    }
}
