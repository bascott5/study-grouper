package com.csc340.study_grouper.users.admin;

import com.csc340.study_grouper.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This controller is used for mapping admin account pages
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService service;

//    @Autowired
//    MessageService messageService;

    /**
     * The get mapping for the admin account page
     * @return account html in admin-view
     */
    @GetMapping("/account")
    public String account(){
        return "admin-view/account";
    }

    /**
     * The get mapping for the reviews page where admins can review reports on customers and providers
     * @return reviews html in admin-view
     */
    @GetMapping("/reviews")
    public String reviews(Model model){
//        model.addAttribute("reviews-list", )
        return "admin-view/reviews";
    }

    /**
     * The get mapping for the statistics page to show admins user use rates
     * @return statistics html in admin-view
     */
    @GetMapping("/statistics")
    public String stats(){
        return "admin-view/statistics";
    }

    /**
     * Displays the admin view page
     * @return
     */
    @GetMapping("/view")
    public String adminView(){
        return "admin-view/admin-view";
    }

    @GetMapping("/home")
    public String home(){
        return "admin-view/admin-home";
    }


    @GetMapping("/view-users")
    public String viewUsers(Model model, @RequestParam(name = "continue",required = false) String cont) {
        model.addAttribute("userList", service.getAllUsers());
        model.addAttribute("title", "User List");
        return "admin-view/view-users";
    }

    @GetMapping("/delete/{uID}")
    public String deleteUser(@PathVariable int uID){
        service.deleteUser(uID);
        return "admin-view/view-users";
    }
}
