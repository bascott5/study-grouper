package com.csc340.study_grouper.reports;

import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reportID;

    @Column(nullable = false)
    private int reporterID;

    @Column(nullable = false)
    private int senderID;

    @Column(nullable = false)
    private int messageID;

    @Column(nullable = false)
    private String msg_type;

    /**
     * Constructor for all values
     * @param reportID
     * @param reporterID
     * @param senderID
     * @param messageID
     * @param msg_type
     */
    public Reports(int reportID, int reporterID, int senderID, int messageID, String msg_type){
        this.reporterID=reporterID;
        this.reporterID=reporterID;
        this.senderID=senderID;
        this.messageID=messageID;
        this.msg_type=msg_type;
    }

    /**
     * Constructor for all non-auto generated values
     * @param reporterID
     * @param senderID
     * @param messageID
     * @param msg_type
     */
    public Reports(int reporterID, int senderID, int messageID, String msg_type){
        this.reporterID=reporterID;
        this.senderID=senderID;
        this.messageID=messageID;
        this.msg_type=msg_type;
    }

    public Reports(){}

    public int getReportID() {
        return reportID;
    }

    public int getReporterID() {
        return reporterID;
    }

    public int getSenderID() {
        return senderID;
    }

    public int getMessageID() {
        return messageID;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setReporterID(int reporterID) {
        this.reporterID = reporterID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }
}
