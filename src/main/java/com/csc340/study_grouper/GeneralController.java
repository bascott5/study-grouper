package com.csc340.study_grouper;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

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
    @Autowired
    UserRepository userRepository;
    /**
     * Mapping to the login page
     * @return login.html page
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/verify-user")
    public String verifyUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findUserByUsername(username).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            switch (user.getAccountType().toString()) {
                case "ADMIN":
                    return "redirect:/admin/home/" + user.getuID();
                case "INSTRUCTOR":
                    return "redirect:/instructor/home/" + user.getuID();
                case "STUDENT":
                    return "redirect:/student/home/" + user.getuID();
                default:
                    return "redirect:/home";
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
