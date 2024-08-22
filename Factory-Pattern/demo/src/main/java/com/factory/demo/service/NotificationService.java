package com.factory.demo.service;

import com.factory.demo.factory.NotificationFactory;
import com.factory.demo.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationFactory notificationFactory;

    @Autowired
    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendNotification(String type, String sender, String recipient, String body) {
        Notification notification = notificationFactory.createNotification(type);
        notification.sendNotification(sender, recipient, body);
    }
}