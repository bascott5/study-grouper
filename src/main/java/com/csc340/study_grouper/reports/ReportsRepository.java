package com.csc340.study_grouper.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Integer> {

    @Query(value = "SELECT * FROM reports WHERE reporterID = :reporterID", nativeQuery = true)
    public List<Reports> findByReporterId(int reporterID);

    @Query(value = "SELECT * FROM reports WHERE senderID = :senderID", nativeQuery = true)
    public List<Reports> findBySenderID(int senderID);

    @Query(value = "SELECT * FROM reports WHERE messageID = :messageID", nativeQuery = true)
    public List<Reports> findByMessageID(int messageID);

    @Query(value = "SELECT * FROM reports WHERE msg_type = :msg_type", nativeQuery = true)
    public List<Reports> findByMessageType(String msg_type);
}
