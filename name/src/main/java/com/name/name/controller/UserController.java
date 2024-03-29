package com.name.name.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.name.name.entity.User;
import com.name.name.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        // Save user data to the database
        userRepository.save(user);
    }
}
