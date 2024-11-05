package com.csc340.study_grouper.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    ReviewsRepository repo;

    public List<Reviews> findAll(){
        return repo.findAll();
    }

    public List<Reviews> findByGroupID(int groupID){
        return repo.findByGroupId(groupID);
    }

    public Reviews findByReviewId(int reviewID){
        return repo.findById(reviewID).orElse(null);
    }

    public List<Reviews> findBySenderId(int senderID){
        return repo.findBySenderId(senderID);
    }

    public List<Reviews> findByReviewTerm(String reviewTerm){
        return repo.findByReviewTerm(reviewTerm);
    }

    public List<Reviews> addReview(Reviews review){
        repo.save(review);
        return findAll();
    }

    public List<Reviews> deleteReview(int ID){
        repo.delete(findByReviewId(ID));
        return findAll();
    }
}
