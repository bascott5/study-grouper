package com.csc340.study_grouper.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller to map user information from the database
 * @author Adam Cichoski
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService service;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }


    @PostMapping("/addUser")
    public List<User> addUser(@RequestBody User user){
        service.addUser(user);
        return service.getAllUsers();
    }

    @GetMapping("/{uID}")
    public User getUserByID(@PathVariable int uID){
        return service.getUserByID(uID);
    }

    @PostMapping("/updateUser/{uID}")
    public User updateUser(@PathVariable int uID, @RequestBody User newUser){
        service.updateUser(uID, newUser);
        return service.getUserByID(uID);
    }

    @DeleteMapping("/{uID}")
    public String deleteUser(@PathVariable int uID) {
        service.deleteUser(uID);
        return "User with ID " + uID + " has been deleted.";
    }
}
