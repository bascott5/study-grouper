package com.csc340.studyGrouper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This class is used to map pages that all accounts should have access to. In this case, the login and create account
 * pages are accessible to everyone
 */
@Controller
public class GeneralController {

    /**
     * Mapping to the login page
     * @return login.html page
     */
    @GetMapping(value={"","/login"})
    public String loginPage(){
        return "login";
    }

    @GetMapping("/create-account")
    public String createAccount(){
        return "create-account";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("edit-account")
    public String editAccount(){
        return "edit-account";
    }
}
