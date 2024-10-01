package com.csc340.studyGrouper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    /**
     *
     * @return
     */
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

    @GetMapping("/find-group")
    public String findGroup(){
        return "customer-view/find-group";
    }

    @GetMapping("/group-description")
    public String groupDescription(){
        return "customer-view/group-description";
    }
}
