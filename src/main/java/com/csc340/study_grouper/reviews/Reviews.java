package com.csc340.study_grouper.reviews;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewID;

    @Column(nullable = false)
    private int groupID;

    @Column(nullable = false)
    private String review;

    @Column(nullable = false)
    private int senderID;

    @Column(nullable = false)
    @CurrentTimestamp
    private Timestamp time_stamp;

    /**
     * Constructor with all values
     * @param reviewID
     * @param groupID
     * @param review
     * @param senderID
     * @param time_stamp
     */
    public Reviews(int reviewID, int groupID, String review, int senderID, Timestamp time_stamp) {
        this.reviewID = reviewID;
        this.groupID = groupID;
        this.review = review;
        this.senderID = senderID;
        this.time_stamp = time_stamp;
    }

    /**
     * Constructor with all non-auto generated values
     * @param groupID
     * @param review
     * @param senderID
     * @param time_stamp
     */
    public Reviews(int groupID, String review, int senderID, Timestamp time_stamp) {
        this.groupID = groupID;
        this.review = review;
        this.senderID = senderID;
        this.time_stamp = time_stamp;
    }

    public int getReviewID() {
        return reviewID;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getReview() {
        return review;
    }

    public int getSenderID() {
        return senderID;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }
}
