package com.factory.demo.factory;

import com.factory.demo.model.EmailNotification;
import com.factory.demo.model.Notification;
import com.factory.demo.model.SMSNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    
    public Notification createNotification(String type) {
        if ("SMS".equalsIgnoreCase(type)) {
            return new SMSNotification();
        } else if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}