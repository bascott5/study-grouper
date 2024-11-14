package com.csc340.study_grouper.users.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/account")
    public String account(){
        return "student-view/account";
    }

    @GetMapping("/biology")
    public String biologyChat(){
        return  "student-view/biology";
    }

    @GetMapping("/chemistry")
    public String chemistryChat(){
        return "student-view/chemistry";
    }

    @GetMapping("/computer-architecture")
    public String computerArchChat(){
        return "student-view/computer-architecture";
    }

    @GetMapping("/physics")
    public String physicsChat(){
        return "student-view/physics";
    }

    @GetMapping("/software-engineering")
    public String seChat(){
        return "student-view/software-engineering";
    }

    @GetMapping("/group-description")
    public String groupDescription(){
        return "student-view/group-description";
    }

    @GetMapping("/home")
    public String home(){
        return "student-view/student-home";
    }

    @GetMapping("/write-review")
    public String review(){
        return "student-view/chat-settings";
    }
}
