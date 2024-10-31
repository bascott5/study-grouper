package com.csc340.study_grouper.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessagesController {
    @Autowired
    MessagesService service;

    @GetMapping("/{gID}")
    public String getGroupMessagesInOrder(@PathVariable int groupID, Model model){
        model.addAttribute("messages", service.getGroupMessagesInOrder(groupID));
        return "redirect:customer-group-view";
    }


    @PostMapping("/post-message")
    public String postMessage(Message message){
        service.postMessage(message);
        return "redirect:customer-group-view";
    }

    @GetMapping("/delete-message/{mID}")
    public String deleteMessage(@PathVariable int mID){
        service.deleteMessage(service.findByID(mID));
        return "redirect:";
    }
}
