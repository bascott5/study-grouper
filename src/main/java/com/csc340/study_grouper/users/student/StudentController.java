package com.csc340.study_grouper.users.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/account")
    public String account(){
        return "customer-view/account";
    }

    @GetMapping("/biology")
    public String biologyChat(){
        return  "customer-view/biology";
    }

    @GetMapping("/chemistry")
    public String chemistryChat(){
        return "customer-view/chemistry";
    }

    @GetMapping("/computer-architecture")
    public String computerArchChat(){
        return "customer-view/computer-architecture";
    }

    @GetMapping("/physics")
    public String physicsChat(){
        return "customer-view/physics";
    }

    @GetMapping("/software-engineering")
    public String seChat(){
        return "customer-view/software-engineering";
    }

    @GetMapping("/group-description")
    public String groupDescription(){
        return "customer-view/group-description";
    }

    @GetMapping("/home")
    public String home(){
        return "customer-view/customer-home";
    }

    @GetMapping("/write-review")
    public String review(){
        return "customer-view/chat-settings";
    }
}
