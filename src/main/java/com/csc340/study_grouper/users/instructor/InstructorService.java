package com.csc340.study_grouper.users.instructor;

import com.csc340.study_grouper.users.User;
import com.csc340.study_grouper.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    UserRepository repository;

    public List<User> getProviders(){
        return repository.findByAccountType("instructor");
    }

    public User getProviderById(int providerId) { return repository.findUserById(providerId); }
}
