package com.csc340.study_grouper.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Adam Cichoski
 */
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUserByID(int uID){
        return repository.findById(uID).orElse(null);
    }

    public List<User> getUserByName(String name){
        return repository.findUserByName(name);
    }

    public List<User> addUser(User user){
        repository.save(user);
        return getAllUsers();
    }

    public User updateUser(int uID, User user){
        User existing = getUserByID(uID);
        existing.setEmail(user.getEmail());
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setFirst_name(user.getFirst_name());
        existing.setLast_name(user.getLast_name());
        existing.setTitle(user.getTitle());
        existing.setProfile_picture(user.getProfile_picture());
        return existing;
    }


    public List<User> deleteUser(int uID){
        repository.delete(getUserByID(uID));
        return getAllUsers();
    }
}
