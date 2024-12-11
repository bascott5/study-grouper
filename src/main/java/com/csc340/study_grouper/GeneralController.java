package com.csc340.study_grouper;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import com.csc340.study_grouper.users.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This class is used to map pages that all accounts should have access to. In this case, the login and create account
 * pages are accessible to everyone
 */
@Controller
public class GeneralController implements ErrorController {

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
    public String editAccount(Model model){
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("user", user);
        return "edit-account";
    }

    @PostMapping("edit-account")
    public String postEditAccount(User user){
        User u = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        userService.addUser(user);
        return "redirect:/"+u.getAccountType()+"/account";
    }

    @RequestMapping("/error")
    public String error(Model model) {
        String quote = "";

        String url = "https://api.chucknorris.io/jokes/random?category=dev";
        RestTemplate restTemplate = new RestTemplate();
        String jsonListResponse = restTemplate.getForObject(url, String.class);
        quote = jsonListResponse;

        model.addAttribute("quote", quote);
        return "error";
    }
}
