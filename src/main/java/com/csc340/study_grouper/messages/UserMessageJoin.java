package com.csc340.study_grouper.messages;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
public class UserMessageJoin extends Message{
    @Column
    private String first_name, last_name;

    public UserMessageJoin(int messageID, int senderID, int groupID, String message, LocalDateTime time_stamp, String first_name, String last_name) {
        super(messageID, senderID, groupID, message, time_stamp);
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UserMessageJoin(int senderID, int groupID, String message, LocalDateTime time_stamp, String first_name, String last_name) {
        super(senderID, groupID, message, time_stamp);
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UserMessageJoin() {
    }

    public String getFullName(){
        return first_name +" "+ last_name;
    }
}
