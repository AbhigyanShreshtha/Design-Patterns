package com.observer.demo.service;

import com.observer.demo.model.User;
import com.observer.demo.observer.Observer;
import com.observer.demo.observer.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements Subject {
    private Map<String, User> registeredUsers = new HashMap<>();
    private Set<String> loginCreatedUsers = new HashSet<>();

    private List<Observer> observers;

    // Constructor injection of observers
    @Autowired
    public UserService(List<Observer> observers) {
        this.observers = observers;
    }

    // Register a new user
    public void registerUser(User user) {
        registeredUsers.put(user.getUserId(), user);
        checkAndNotify(user.getUserId());
    }

    // Create login for a user
    public void createLogin(String userId, String password) {
        User user = registeredUsers.get(userId);
        if (user != null) {
            // Update user with password using the Builder pattern
            User updatedUser = new User.Builder(user.getUserId())
                    .setName(user.getName())
                    .setUsername(user.getUsername())
                    .setEmail(user.getEmail())
                    .setPhoneNumber(user.getPhoneNumber())
                    .setPassword(password)
                    .build();
            registeredUsers.put(userId, updatedUser);
            loginCreatedUsers.add(userId);
            checkAndNotify(userId);
        }
    }

    // Check if both registration and login are complete, then notify observers
    private void checkAndNotify(String userId) {
        if (registeredUsers.containsKey(userId) && loginCreatedUsers.contains(userId)) {
            notifyObservers(userId);
        }
    }

    // Attach an observer
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    // Detach an observer
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    // Notify all observers about the event
    @Override
    public void notifyObservers(String userId) {
        for (Observer o : observers) {
            o.update(userId);
        }
    }
}