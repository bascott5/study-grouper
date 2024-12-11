package com.csc340.study_grouper.messages;

import com.csc340.study_grouper.study_groups.StudyGroup;
import com.csc340.study_grouper.study_groups.StudyGroupService;
import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserService;
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

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
public class MessagesController {

    @Autowired
    MessagesService messageService;

    @Autowired
    UserService userService;

    @Autowired
    StudyGroupService studyGroupService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(NewMessage newMessage) {
        Message chatMessage = new Message(userService.getUserByID(newMessage.senderID), studyGroupService.getStudyGroupByID(newMessage.groupID), newMessage.message);
        System.out.println("Saving message...");
        messageService.postMessage(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        messageService.postMessage(chatMessage);
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderID());
        return chatMessage;
    }
}
