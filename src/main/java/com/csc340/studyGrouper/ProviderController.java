package com.csc340.studyGrouper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProviderController {

    @GetMapping("/create-group")
    public String createGroup(){
        return "provider-view/create-group";
    }

    @GetMapping("/group-settings")
    public String groupSettings(){
        return "provider-view/group-settings";
    }

    @GetMapping("/p-account")
    public String account(){
        return "provider-view/p-account";
    }

    @GetMapping("/p-biology")
    public String biology(){
        return "provider-view/p-biology";
    }

    @GetMapping("/p-chemistry")
    public String chem(){
        return "provider-view/p-chemistry";
    }

    @GetMapping("/p-computer-architecture")
    public String compArch(){
        return "provider-view/p-computer-architecture";
    }

    @GetMapping("/p-physics")
    public String physics(){
        return "provider-view/p-physics";
    }

    @GetMapping("/p-software-engineering")
    public String softEng(){
        return "provider-view/p-software-engineering";
    }
}
