package com.csc340.study_grouper.reports;

import com.csc340.study_grouper.reviews.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    @Autowired
    ReportsRepository repo;

    public List<Reports> findAllReports(){
        return repo.findAll();
    }

    public Reports findByReportID(int reportID){
        return repo.findById(reportID).orElse(null);
    }

    public List<Reports> findByReporterId(int reporterID){
        return repo.findByReporterId(reporterID);
    }

    public List<Reports> findBySenderId(int senderID){
        return repo.findBySenderID(senderID);
    }

    public List<Reports> findByMessageId(int messageID){
        return repo.findByMessageID(messageID);
    }

    public List<Reports> findByMessageType(String msg_type){
        return repo.findByMessageType(msg_type);
    }

    public List<Reports> deleteReport(Reports reports){
        repo.delete(reports);
        return repo.findAll();
    }


}
