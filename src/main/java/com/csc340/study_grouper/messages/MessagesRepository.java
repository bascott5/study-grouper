package com.csc340.study_grouper.messages;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for messages table in the database
 * @author Adam Cichoski
 */
@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM messages WHERE senderID = :senderID", nativeQuery = true)
    List<Message> findBySenderID(int senderID);


    @Query(value="SELECT * FROM messages WHERE groupID =:groupID ORDER BY time_stamp desc", nativeQuery = true)
    List<Message> getGroupMessagesInOrder(int groupID);

    @Modifying
    @Transactional
    @Query(value= "DELETE FROM messages " +
            "WHERE groupid = :groupid; ", nativeQuery = true)
    void deleteByGroupID(int groupid);



}
