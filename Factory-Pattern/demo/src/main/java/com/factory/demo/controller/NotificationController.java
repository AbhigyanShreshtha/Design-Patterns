package com.factory.demo.controller;


import com.factory.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody Map<String, String> request) {
        String type = request.get("method");
        String sender = request.get("sender");
        String recipient = request.get("recipient");
        String body = request.get("body");

        notificationService.sendNotification(type, sender, recipient, body);
    }
}