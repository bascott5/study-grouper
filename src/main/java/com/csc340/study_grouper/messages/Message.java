package com.csc340.study_grouper.messages;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name ="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int messageID;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    int senderID;


    @Column(nullable = false)
    int groupID;

    @Column
    @CurrentTimestamp
    Timestamp time_stamp;

    /**
     * Constructor with all column values
     * @param messageID
     * @param senderID
     * @param groupID
     * @param message
     * @param time_stamp
     */
    public Message(int messageID, int senderID, int groupID, String message, Timestamp time_stamp) {
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
    public Message(int senderID, int groupID, String message, Timestamp time_stamp){
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

    public int getSenderID() {
        return senderID;
    }

    public int getGroupID() {
        return groupID;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }
}
