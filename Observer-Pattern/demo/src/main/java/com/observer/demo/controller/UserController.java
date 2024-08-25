package com.observer.demo.controller;

import com.observer.demo.model.User;
import com.observer.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registeruser")
    public String registerUser(
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String phoneNumber) {

        String userId = UUID.randomUUID().toString();
        User user = new User.Builder(userId)
                .setName(name)
                .setUsername(username)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
        userService.registerUser(user);
        return "User registered with ID: " + userId;
    }

    @PostMapping("/createlogin")
    public String createLogin(
            @RequestParam String userId,
            @RequestParam String password) {

        userService.createLogin(userId, password);
        return "User login created for userId: " + userId;
    }
}