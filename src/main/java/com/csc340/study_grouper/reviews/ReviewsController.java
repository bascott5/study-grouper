package com.csc340.study_grouper.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    ReviewsService service;

    @GetMapping("/{ID}")
    public Reviews getByID(@PathVariable int ID){
        return service.findByReviewId(ID);
    }

    @GetMapping("/sender/{ID}")
    public List<Reviews> getBySenderId(@PathVariable int ID){
        return service.findBySenderId(ID);
    }

    @GetMapping("/term")
    public List<Reviews> getByTerm(@RequestParam(name="review", defaultValue = "") String term){
        return service.findByReviewTerm(term);
    }

    @PostMapping("/add-review")
    public List<Reviews> addReview(@RequestBody Reviews review){
        return service.addReview(review);
    }

    @DeleteMapping("/delete/{ID}")
    public List<Reviews> deleteReview(@PathVariable int ID){
        return service.deleteReview(ID);
    }
}
