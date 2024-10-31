package com.csc340.study_grouper;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This class is used to map pages that all accounts should have access to. In this case, the login and create account
 * pages are accessible to everyone
 */
@Controller
public class GeneralController {
    UserService userService;
    /**
     * Mapping to the login page
     * @return login.html page
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/create-account")
    public String createAccount(){
        return "create-account";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping({"/","/home", "/index"})
    public String home(){
        return "home";
    }

    @GetMapping("edit-account")
    public String editAccount(){
        return "edit-account";
    }
}
