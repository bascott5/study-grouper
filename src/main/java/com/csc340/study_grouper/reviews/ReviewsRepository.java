package com.csc340.study_grouper.reviews;

import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

    @Query(value = "SELECT * FROM reviews WHERE groupID = :groupID", nativeQuery = true)
    public List<Reviews> findByGroupId(int groupID);

    @Query(value = "SELECT * FROM reviews WHERE senderID = :senderID", nativeQuery = true)
    public List<Reviews> findBySenderId(int senderID);

    @Query(value = "SELECT * FROM reviews WHERE review LIKE %:reviewTerm%", nativeQuery = true)
    public List<Reviews> findByReviewTerm(String reviewTerm);
}
