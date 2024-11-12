package com.csc340.study_grouper.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for users table in the database
 * @author Adam Cichoski
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE name LIKE %:name%", nativeQuery = true)
    Optional<User> findUserByName(String name);

    @Query(value = "SELECT * FROM users WHERE accountType = :accountType", nativeQuery = true)
    List<User> findByAccountType(String accountType);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    Optional<User> findUserByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE uid = :uid", nativeQuery = true)
    User findUserById(int uid);
}
