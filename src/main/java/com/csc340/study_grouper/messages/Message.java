package com.csc340.study_grouper.messages;

import com.csc340.study_grouper.users.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name ="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="messageID")
    int messageID;

    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="uID")
    User senderID;

    @Column(nullable = false)
    int groupID;

    @Column(nullable = false)
    //@CurrentTimestamp
    LocalDateTime time_stamp;

    /**
     * Constructor with all column values
     * @param messageID
     * @param senderID
     * @param groupID
     * @param message
     * @param time_stamp
     */
    public Message(int messageID, User senderID, int groupID, String message, LocalDateTime time_stamp) {
        this.messageID = messageID;
        this.message = message;
        this.senderID = senderID;
        this.groupID = groupID;
        this.time_stamp = time_stamp;
    }

    /**
     * Constructor with all required columns that are not auto generated
     * @param senderID
     * @param groupID
     * @param message
     * @param time_stamp
     */
    public Message(User senderID, int groupID, String message, LocalDateTime time_stamp){
        this.message = message;
        this.senderID = senderID;
        this.groupID = groupID;
        this.time_stamp = time_stamp;
    }

    /**
     * Basic empty constructor
     */
    public Message(){

    }

    public int getMessageID() {
        return messageID;
    }

    public String getMessage() {
        return message;
    }

    public User getSenderID() {
        return senderID;
    }

    public int getGroupID() {
        return groupID;
    }

    public LocalDateTime getTime_stamp() {
        return time_stamp;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderID(User senderID) {
        this.senderID = senderID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setTime_stamp(LocalDateTime time_stamp) {
        this.time_stamp = time_stamp;
    }
}
