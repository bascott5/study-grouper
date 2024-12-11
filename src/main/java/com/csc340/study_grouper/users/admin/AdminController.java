package com.csc340.study_grouper.users.admin;

import com.csc340.study_grouper.reports.ReportsService;
import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
import com.csc340.study_grouper.users.student.StudentService;
import com.csc340.study_grouper.users.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    InstructorService instructorService;
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;
    StudyGroupService studyGroup;
    ReportsService reportsService;


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
        //model.addAttribute("reports-list", reportsService.findAllReports());
        return "admin-view/reviews";
    }

    /**
     * The get mapping for the statistics page to show admins user use rates
     * @return statistics html in admin-view
     */
    @GetMapping("/statistics")
    public String stats(Model model){
        List<User> allUsers = service.getAllUsers();
        List<User> students = studentService.getStudents();
        List<User> instructors = instructorService.getProviders();
        List<User> admins = adminService.getAdmins();

        int totalStudents = students.size();
        int totalInstructors = instructors.size();
        int totalUsers = allUsers.size();
        int totalAdmins = admins.size();

        double percentage = ((double) totalInstructors / totalStudents) * 100;
        double sProportion = ((double) totalStudents / totalUsers) * 100;
        double iProportion = ((double) totalInstructors / totalUsers) * 100;
        double aProportion = ((double) totalAdmins / totalUsers) * 100;

        model.addAttribute("Students", totalStudents);
        model.addAttribute("Providers", totalInstructors);
        model.addAttribute("instructorPercentage", percentage);
        model.addAttribute("admins", totalAdmins);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("sProportion", sProportion);
        model.addAttribute("iProportion", iProportion);
        model.addAttribute("aProportion", aProportion);
//        System.out.println("Total Users: " + totalUsers);
//        System.out.println("Total Students: " + totalStudents);
//        System.out.println("Total Instructors: " + totalInstructors);
//        System.out.println("Instructor Percentage: " + percentage);
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
    public String viewUsers(Model model) {
        List<User> userList = service.getAllUsers();
        model.addAttribute("username", "Admin");
        model.addAttribute("userList", userList);
        return "admin-view/view-users";
    }

    @GetMapping("/delete/{uID}")
    public String deleteUser(@PathVariable int uID){
        service.deleteUser(uID);
        return "redirect:/admin/view-users";
    }
}
