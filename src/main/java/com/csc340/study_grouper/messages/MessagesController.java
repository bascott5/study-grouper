package com.csc340.study_grouper.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
public class MessagesController {

    MessagesService messageService;
    MessagesRepository messagesRepository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        messagesRepository.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        messagesRepository.save(chatMessage);
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderID());
        return chatMessage;
    }

    /*@Autowired
    MessagesService service;

    @GetMapping("/{gID}")
    public String getGroupMessagesInOrder(@PathVariable int groupID, Model model){
        model.addAttribute("messages", service.getGroupMessagesInOrder(groupID));
        return "redirect:student-group-view";
    }

    @PostMapping("/post-message")
    public String postMessage(Message message){
        service.postMessage(message);
        return "redirect:student-group-view";
    }

    @GetMapping("/delete-message/{mID}")
    public String deleteMessage(@PathVariable int mID){
        service.deleteMessage(service.findByID(mID));
        return "redirect:";
    }*/
}
