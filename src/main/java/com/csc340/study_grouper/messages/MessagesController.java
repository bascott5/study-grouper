package com.csc340.study_grouper.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Adam Cichoski, Bennet Scott, Logan Keiper
 */
@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    MessagesService service;

    @GetMapping("/all")
    public List<Message> getAllMessages(){
        return service.findAll();
    }

    /**
     * Method to return messages of a group in order
     * localhost:8080/messages/group/{gID}
     * gID = groupID
     * @param groupID
     * @return the list of messages in a group in order from the most recently sent to the oldest
     */
    @GetMapping("/group/{groupID}")
    public List<Message> getGroupMessagesInOrder(@PathVariable int groupID){
        return service.getGroupMessagesInOrder(groupID);
    }

    /**
     * Returns the messages sent by a particular sender
     * localhost:8080/messages/user/{uID}
     * uID = userID (or senderID)
     * @param uID
     * @return the messages with matching senderIDs
     */
    @GetMapping("/user/{uID}")
    public List<Message> getMessagesBySenderId(@PathVariable int uID){
        return service.findBySenderID(uID);
    }

    /**
     * Posts a new message
     * localhost:8080/messages/post-message
     * @param message
     * @return the list of all messages
     */
    @PostMapping("/post")
    public List<Message> postMessage(@RequestBody Message message){
        service.postMessage(message);
        return service.findAll();
    }

    /**
     * Delete a message
     * localhost:8080/messages/delete-message/{mID}
     * mID = messageID
     * @param mID
     * @return the list of all messages
     */
    @DeleteMapping("/delete/{mID}")
    public List<Message> deleteMessage(@PathVariable int mID){
        service.deleteMessage(service.findByID(mID));
        return service.findAll();
    }


}
