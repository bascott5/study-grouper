package com.csc340.study_grouper.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserByName(String name){
        return repository.findUserByName(name);
    }

    public List<User> addUser(User user){
        repository.save(user);
        return getAllUsers();
    }

    public Optional<User> getUserByUsername(String username){
        return repository.findUserByUsername(username);
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

    public User updateUser(User current, User newVersion){
        current.setEmail(newVersion.getEmail());
        current.setUsername(newVersion.getUsername());
        current.setPassword(newVersion.getPassword());
        current.setFirst_name(newVersion.getFirst_name());
        current.setLast_name(newVersion.getLast_name());
        current.setTitle(newVersion.getTitle());
        current.setProfile_picture(newVersion.getProfile_picture());
        return current;
    }


    public List<User> deleteUser(int uID){
        repository.delete(getUserByID(uID));
        return getAllUsers();
    }
}
