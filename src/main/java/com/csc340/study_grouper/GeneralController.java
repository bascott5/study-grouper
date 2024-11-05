package com.csc340.study_grouper;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This class is used to map pages that all accounts should have access to. In this case, the login and create account
 * pages are accessible to everyone
 */
@Controller
public class GeneralController {

    @Autowired
    UserService userService;
    /**
     * Mapping to the login page
     * @return login.html page
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/verify-user")
    public String verifyLogin(String username, String password){
        User test = userService.getUserByUsername(username);
        if(test != null){
            if (test.getPassword().equals(password)){
                return "redirect:/customer/home";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/create-account")
    public String createAccount(){
        return "create-account";
    }

    @PostMapping("/create")
    public String createUser(User user){
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
