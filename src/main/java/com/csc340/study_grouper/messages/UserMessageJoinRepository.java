package com.csc340.study_grouper.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMessageJoinRepository extends JpaRepository<UserMessageJoin, Integer> {
    @Query(value="SELECT m.messageID, m.message, m.senderID, m.groupID, m.time_stamp, u.first_name, u.last_name FROM messages m " +
            "INNER JOIN users u ON m.senderID = u.uID " +
            "WHERE m.groupID =:groupID ORDER BY m.time_stamp DESC", nativeQuery = true)
    List<UserMessageJoin> userMessageJoin(int groupID);
}
