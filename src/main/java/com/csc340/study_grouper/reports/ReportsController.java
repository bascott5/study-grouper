package com.csc340.study_grouper.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    ReportsService service;

    //Get all the reports
    @GetMapping("/all-reports")
    public List<Reports> getAllReviews(@ModelAttribute Reports reports){
        return service.findAllReports();
    }

    //Get one report.
    @GetMapping("/{reporterID}")
    public Reports getOneReview(@PathVariable int reporterID){
        return service.findByReportID(reporterID);
    }

    //Delete the reported message
    @DeleteMapping("/delete-report/{rID}")
    public List<Reports> deleteReport(@PathVariable int rID) {
        return service.deleteReport(service.findByReportID(rID));
    }
}