package com.csc340.study_grouper.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    MessagesRepository messagesRepository;


    /**
     * Finds a message by its messageID
     * @param mID
     * @return
     */
    public Message findByID(int mID){
        return messagesRepository.findById(mID).orElse(null);
    }

    /**
     * Returns the messages in a group, ordered by the timestamp in descending order
     * @param groupID
     * @return
     */
    public List<Message> getGroupMessagesInOrder(int groupID){
        return messagesRepository.getGroupMessagesInOrder(groupID);
    }


    /**
     * Saves a message to the database
     * @param message
     */
    public void postMessage(Message message){
        messagesRepository.save(message);
    }

    /**
     * Deletes a message from the database
     * @param message
     * @return
     */
    public List<Message> deleteMessage(Message message){
        messagesRepository.delete(message);
        return messagesRepository.findAll();
    }

    public List<Message> findOrderedGroupMessages(int gID){
        return messagesRepository.getGroupMessagesInOrder(gID);
    }

}
