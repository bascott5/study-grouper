package com.csc340.study_grouper.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {

    @Autowired
    MessagesRepository repo;


    public Message findByID(int mID){
        return repo.findById(mID).orElse(null);
    }
    public List<Message> getGroupMessagesInOrder(int groupID){
        return repo.getGroupMessagesInOrder(groupID);
    }

    public void postMessage(Message message){
        repo.save(message);
    }

    public List<Message> deleteMessage(Message message){
        repo.delete(message);
        return repo.findAll();
    }
}
