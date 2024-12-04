package com.csc340.study_grouper;

import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        User test = userService.getUserByUsername(username).orElse(null);
        if(test != null){
            String pass = test.getPassword();
            if (pass.equals(password)){
                String accountType = test.getAccountType();
                switch(accountType){
                    case "student" : return "redirect:/student/home/"+test.getuID();
                    case "instructor" : return "redirect:/instructor/home/"+test.getuID();
                    case "admin" : return "redirect:/admin/home/"+test.getuID();
                    default : return "redirect:/home";
                }
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

    @GetMapping("/edit-account/{uID}")
    public String editAccount(@PathVariable int uID, Model model){
        model.addAttribute("user", userService.getUserByID(uID));
        return "edit-account";
    }

    @PostMapping("/edit-account")
    public String editAccount(User user){
        userService.addUser(user);
        String accountType = user.getAccountType();
        int uID = user.getuID();
        return "redirect:/"+accountType+"/account/"+uID;
    }
}
