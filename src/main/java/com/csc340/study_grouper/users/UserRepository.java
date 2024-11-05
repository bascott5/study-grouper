package com.csc340.study_grouper.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for users table in the database
 * @author Adam Cichoski
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE name LIKE %:name%", nativeQuery = true)
    List<User> findUserByName(String name);

    @Query(value = "SELECT * FROM users WHERE accountType = :accountType", nativeQuery = true)
    List<User> findByAccountType(String accountType);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findUserByUsername(String username);
}
