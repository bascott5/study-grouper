package com.csc340.studyGrouper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 *
 * This controller is used for mapping admin account pages
 */
@Controller
public class AdminController {

    /**
     * The get mapping for the admin account page
     * @return account html in admin-view
     */
    @GetMapping("/admin-account")
    public String account(){
        return "admin-view/account";
    }

    /**
     * The get mapping for the reviews page where admins can review reports on customers and providers
     * @return reviews html in admin-view
     */
    @GetMapping("/reviews")
    public String reviews(){
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
}
