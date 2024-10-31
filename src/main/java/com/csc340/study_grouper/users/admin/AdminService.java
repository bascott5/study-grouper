package com.csc340.study_grouper.users.admin;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository repository;

    public List<User> getAdmins(){
        return repository.findByAccountType(User.ADMIN);
    }
}
